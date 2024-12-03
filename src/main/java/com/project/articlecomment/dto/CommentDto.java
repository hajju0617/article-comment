package com.project.articlecomment.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.articlecomment.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor     // 모든 필드를 매개변수로 갖는 생성자 자동 생성.
@NoArgsConstructor      // 매개변수가 아예 없는 기본 생성자 자동 생성.
@Getter                 // 각 필드 값을 조회할 수 있는 getter 메서드 자동 생성.
@ToString               // 모든 필드를 출력할 수 있는 toString 메서드 자동 생성
public class CommentDto {
    private Long id;
    @JsonProperty("article_id")
    private Long articleId;     // 댓글의 부모 id
    private String nickname;
    private String body;        // 댓글 본문.

    // static -> 정적 메서드. 즉, 객체 생성없이 호출 가능한 메서드.
    public static CommentDto createCommentDto(Comment comment) {        // 이러한 방식으로 객체를 만드는 메서드를 생성메서드라 함.
        return new CommentDto(          // CommentDto 생성자 호출
                  comment.getId()                   // 댓글 엔터티 id
                , comment.getArticle().getId()      // 댓글 엔터티가 속한 부모 게시글의 id
                , comment.getNickname()             // 댓글 엔터티의 nickname
                , comment.getBody());               // 댓글 엔터티의 body(본문)
    }
}
