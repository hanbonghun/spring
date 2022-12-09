package org.example.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//db 접근 레포지토리
// 인터페이스 생성후 JpaRepository<Entity클래스, Pk타입> 상속하면 기본 crud메소드 생성
//Entitiy와 repository는 함께 위치
public interface PostsRepository extends JpaRepository<Posts,Long> {
}
