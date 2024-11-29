package com.project.articlecomment.api;


import com.project.articlecomment.dto.ArticleForm;
import com.project.articlecomment.entity.Article;
import com.project.articlecomment.repository.ArticleRepository;
import com.project.articlecomment.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // REST 컨트롤러 선언.
@Slf4j
public class ArticleApiController {
    @Autowired
    private ArticleService articleService;      // @Service로 인해 에러표시 사라짐.


    @GetMapping("/api/articles")
    public List<Article> index() {      // 모든 데이터 조회.
        return articleService.index();
//        return articleRepository.findAll();
    }

    @GetMapping("/api/articles/{id}")
    public Article show(@PathVariable Long id) {  // 단일 데이터 조회.
        return articleService.show(id);
    }

    @PostMapping("/api/articles")
    public ResponseEntity<Article> create(@RequestBody ArticleForm dto) {     // 새로운 데이터 생성.
        Article created = articleService.create(dto);
        return created != null ? ResponseEntity.status(HttpStatus.OK).body(created) : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PatchMapping("/api/articles/{id}")
    public ResponseEntity<Article> update(@PathVariable Long id, @RequestBody ArticleForm dto) {      // 데이터 수정.
        Article updated = articleService.update(id, dto);
        return updated != null ? ResponseEntity.status(HttpStatus.OK).body(updated) : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<Article> delete(@PathVariable Long id) {        // 데이터 삭제.
        Article deleted = articleService.delete(id);
        return deleted != null ? ResponseEntity.status(HttpStatus.NO_CONTENT).build() : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
