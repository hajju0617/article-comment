package com.project.articlecomment.repository;

import com.project.articlecomment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByArticleId(Long ArticleId);  // 특정 게시글의 모든 댓글 조회.
}
