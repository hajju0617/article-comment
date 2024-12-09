package com.project.articlecomment.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity     // 해당 클래스가 엔터티임을 선언.
@ToString
@AllArgsConstructor     // 모든 필드를 매개변수로 하는 생성자
@NoArgsConstructor      // 기본 생성자
@Getter
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String content;

    @OneToMany(mappedBy = "article", cascade = CascadeType.REMOVE, orphanRemoval = true)
    @ToString.Exclude // 순환 참조 방지
    private List<Comment> comments = new ArrayList<>();

    public Article(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public void patch(Article article) {
        if (article.title != null) {
            this.title = article.title;
        }
        if (article.content != null) {
            this.content = article.content;
        }
    }
}
