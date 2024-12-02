package com.project.articlecomment.repository;

import com.project.articlecomment.entity.Article;
import com.project.articlecomment.entity.Comment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest    // 해당 클래스를 `JPA`와 연동해서 테스트하겠다는 선언
class CommentRepositoryTest {
    @Autowired  // 외부에서 객체를 주입.(DI)
    CommentRepository commentRepository;

    @Test
    @DisplayName("특정 게시글의 모든 댓글 조회")
    void findByArticleId() {
        // case 1 : 4번 게시글
        {
            Long articleId = 4L;
            List<Comment> comments = commentRepository.findByArticleId(articleId);  // 실제 데이터.

            // 예상데이터
            Article article = new Article(4L, "연말에 뭐하세요?", "댓글로 알려주세요");
            Comment a = new Comment(1L, article, "Park", "집돌이");
            Comment b = new Comment(2L, article, "Kim", "공부");
            Comment c = new Comment(3L, article, "Choi", "여행");
            List<Comment> expected = Arrays.asList(a, b, c);

            // 비교 및 검증
            assertEquals(expected.toString(), comments.toString(), "4번 글의 모든 댓글 출력.");
        }
        // case 2 : 2번 게시글.
        {
            Long articleId = 1L;
            List<Comment> comments = commentRepository.findByArticleId(articleId);  // 실제 데이터.

            // 예상데이터
            Article article = new Article(1L, "안녕하세요?", "반가워요");
            List<Comment> expected = Arrays.asList();

            // 비교 및 검증
            assertEquals(expected.toString(), comments.toString(), "1번 글에는 댓글 없음.");
        }
    }

    @Test
    @DisplayName("특정 닉네임의 모든 댓글 조회")
    void findByNickname() {
        // case 1 : "Park"의 모든 댓글 조회.
        {
            String nickname = "Park";
            List<Comment> comments = commentRepository.findByNickname(nickname);    // 실제 데이터

            // 예상 데이터
            Comment a =  new Comment(1L, new Article(4L, "연말에 뭐하세요?", "댓글로 알려주세요"), nickname, "집돌이");
            Comment b =  new Comment(4L, new Article(5L, "크리스마스에 뭐하세요?", "댓글 써주세요"), nickname, "맛집");
            Comment c =  new Comment(7L, new Article(6L, "올 한 해 수고하셨어요", "댓글댓글"), nickname, "수고하셨어요");
            List<Comment> expected = Arrays.asList(a, b, c);

            // 비교 및 검증
            assertEquals(expected.toString(), comments.toString());
        }
    }
}