package org.example.springboot.domain.posts;

import lombok.Builder;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor //기본 생성자 자동 추가 public Post(){}
@Entity //실제 db 테이블과 매칭될 클래스 ->Entity 클래스
public class Posts {
    
    @Id //pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) //pk 규칙
    private Long id;

    @Column(length =500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false) //column 을 TEXT 로 설정
    private String content;

    //column 없어도 클래스의 필드는 모두 칼럼
    private String author;

    @Builder
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content){
        this.title = title;
        this.content= content;
    }
}
