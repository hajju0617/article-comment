package com.project.articlecomment.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity     // 해당 클래스가 엔터티임을 선언.
@ToString
@AllArgsConstructor     // 모든 필드를 매개변수로 하는 생성자
@NoArgsConstructor      // 기본 생성자
@Getter
public class Article {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String title;

    @Column
    private String content;


}
