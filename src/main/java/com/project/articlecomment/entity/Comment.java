package com.project.articlecomment.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@ToString
@AllArgsConstructor
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
}
