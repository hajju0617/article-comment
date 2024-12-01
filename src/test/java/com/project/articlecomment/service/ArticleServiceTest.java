package com.project.articlecomment.service;

import com.project.articlecomment.dto.ArticleForm;
import com.project.articlecomment.entity.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ArticleServiceTest {
    @Autowired
    ArticleService articleService;  // 객체 선언 (외부 객체를 주입해야 하므로 @Autowired 붙임.)
    @Test
    void index() {
        // 예상 데이터.
        Article a = new Article(1L, "안녕하세요", "반가워요");
        Article b = new Article(2L, "안녕", "반가워");
        Article c = new Article(3L, "안녕하세요 반가워요", "네 반가워요");
        List<Article> expected = new ArrayList<Article>(Arrays.asList(a, b, c));

        // 실제 데이터.
        List<Article> articles = articleService.index();

        // 비교 및 검증.
        assertEquals(expected.toString(), articles.toString());
    }

    @Test
    void show_성공_존재하는_id입력() {
        // 예상 데이터.
        Long id = 1L;
        Article expected = new Article(id, "안녕하세요", "반가워요");

        // 실제 데이터.
        Article article = articleService.show(id);

        // 비교 및 검증.
        assertEquals(expected.toString(), article.toString());
    }
    @Test
    void show_실패_존재하지_않는_id입력() {
        // 예상 데이터.
        Long id = -1L;
        Article expected = null;

        // 실제 데이터.
        Article article = articleService.show(id);

        // 비교 및 검증.
        assertEquals(expected, article);
    }

    @Transactional
    @Test
    void create_성공_title과_content만_있는_dto입력() {
        // 예상 데이터.
        String title = "연말 잘 보내세요";
        String content = "올 한해도 수고하셨습니다";
        ArticleForm dto = new ArticleForm(null, title, content);
        Article expected = new Article(4L, title, content);

        // 실제 데이터.
        Article article = articleService.create(dto);

        // 비교 및 검증.
        assertEquals(expected.toString(), article.toString());
    }
    @Transactional
    @Test
    void create_실패_id가_포함된_dto입력() {
        // 예상 데이터.
        Long id = 4L;
        String title = "연말 잘 보내세요";
        String content = "올 한해도 수고하셨습니다";
        ArticleForm dto = new ArticleForm(id, title, content);
        Article expected = null;

        // 실제 데이터.
        Article article = articleService.create(dto);

        // 비교 및 검증.
        assertEquals(expected, article);
    }
}