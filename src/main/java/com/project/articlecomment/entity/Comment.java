package com.project.articlecomment.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.articlecomment.dto.CommentDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@ToString
@AllArgsConstructor     // 모든 필드를 매개변수로 갖는 생성자 자동 생성.
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne      // Comment 엔터티와  Article 엔터티를 N : 1 관계로 설정.
    @JoinColumn(name = "article_id")    // FK 매핑. (Article 엔터티의 PK와 매핑)
    private Article article;

    @Column
    private String nickname;

    @Column
    private String body;



    public static Comment createComment(CommentDto dto, Article article) {
        if (dto.getId() != null) {
            throw new IllegalArgumentException("댓글 생성 실패. 댓글의 id가 없어야 함.");
        }
        if (dto.getArticleId() != article.getId()) {
            throw new IllegalArgumentException("댓글 생성 실패. 게시글의 id가 잘못됐음.");
        }
        return new Comment(
                  dto.getId()
                , article
                , dto.getNickname()
                , dto.getBody()
        );
    }

    public void patch(CommentDto dto) {
        if (this.id != dto.getId()) {
            throw new IllegalArgumentException("댓글 수정 실패. 잘못된 id가 입력됐음");
        }
        if (dto.getNickname() != null) {
            this.nickname = dto.getNickname();
        }
        if (dto.getBody() != null) {
            this.body = dto.getBody();
        }
    }
}
