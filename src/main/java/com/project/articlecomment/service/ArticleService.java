package com.project.articlecomment.service;

import com.project.articlecomment.dto.ArticleForm;
import com.project.articlecomment.entity.Article;
import com.project.articlecomment.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service    // 이 클래스를 서비스로 인식해 서비스 객체 생성.
@Slf4j
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;    // ArticleRepository 객체 주입.

    public List<Article> index() {
        return articleRepository.findAll();
    }

    public Article show(Long id) {
        return articleRepository.findById(id).orElse(null);
    }

    public Article create(ArticleForm dto) {
        Article article = dto.toEntity();
        if (article.getId() != null) {
            return null;
        }
        return articleRepository.save(article);
    }

    public Article update(Long id, ArticleForm dto) {
        Article article = dto.toEntity();
        Article target = articleRepository.findById(id).orElse(null);
        if (target == null || id != article.getId()) {
            return null;
        }
        target.patch(article);
        return articleRepository.save(target);
    }

    public Article delete(Long id) {
        Article target = articleRepository.findById(id).orElse(null);
        if (target == null) {
            return null;
        }
        articleRepository.delete(target);
        return target;
    }

    @Transactional
    public List<Article> createArticles(List<ArticleForm> dtos) {
        List<Article> articleList = dtos.stream().map(dto -> dto.toEntity()).collect(Collectors.toList());
//        List<Article> articleList = new ArrayList<>();
//        for (int i = 0; i < dtos.size(); i++) {
//            ArticleForm dto = dtos.get(i);
//            Article entity = dto.toEntity();
//            articleList.add(entity);
//        }
        articleList.stream().forEach(article -> articleRepository.save(article));
//        for (int i = 0; i < articleList.size(); i++) {
//            Article article = articleList.get(i);
//            articleRepository.save(article)
//        }
        articleRepository.findById(-1L).orElseThrow(() -> new IllegalArgumentException("실패!"));     // 강제로 예외 발생.
        return articleList;
    }
}
