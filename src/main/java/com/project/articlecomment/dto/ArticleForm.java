package com.project.articlecomment.dto;

import com.project.articlecomment.entity.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



@ToString
@AllArgsConstructor     // 모든 필드를 매개변수로 갖는 생성자 자동 생성.
@Getter
public class ArticleForm {
    private Long id;
    private String title;
    private String content;

    public ArticleForm() {
        System.out.println("생성자 호출!!");
    }


    public Article toEntity() {
        return new Article(id, title, content);
    }
}
