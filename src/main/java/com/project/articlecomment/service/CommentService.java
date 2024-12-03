package com.project.articlecomment.service;

import com.project.articlecomment.dto.CommentDto;
import com.project.articlecomment.entity.Article;
import com.project.articlecomment.entity.Comment;
import com.project.articlecomment.repository.ArticleRepository;
import com.project.articlecomment.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service        // 해당 클래스를 서비스로 선언.
public class CommentService {
    @Autowired          // 객체 주입.
    private ArticleRepository articleRepository;
    @Autowired          // 객체 주입.
    private CommentRepository commentRepository;

    public List<CommentDto> comments(Long articleId) {
//        List<Comment> comments = commentRepository.findByArticleId(articleId);
//        List<CommentDto> dtos = new ArrayList<CommentDto>();
//        for (int i = 0; i < comments.size(); i++) {
//            Comment c = comments.get(i);
//            CommentDto dto = CommentDto.createCommentDto(c);
//            dtos.add(dto);
//        }
//        return dtos;
        return commentRepository.findByArticleId(articleId)
                .stream().map(comment -> CommentDto.createCommentDto(comment))
                .collect(Collectors.toList());
    }

    @Transactional
    public CommentDto create(Long articleId, CommentDto dto) {
        Article article = articleRepository.findById(articleId).orElseThrow(() -> new IllegalArgumentException("댓글 생성 실패 " + "대상 게시글이 없음"));
        Comment comment = Comment.createComment(dto, article);
        Comment created = commentRepository.save(comment);
        return CommentDto.createCommentDto(created);        // Entity -> DTO 변환해서 리턴.
    }
}
