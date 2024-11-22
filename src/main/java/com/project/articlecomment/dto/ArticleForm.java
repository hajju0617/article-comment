package com.project.articlecomment.dto;

import com.project.articlecomment.entity.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;


@AllArgsConstructor
@ToString
public class ArticleForm {

    private String title;

    private String content;



    public Article toEntity() {
        return new Article(null, title, content);
    }
}
