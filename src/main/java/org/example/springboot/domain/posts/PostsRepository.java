package org.example.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

//db 접근 레포지토리
// 인터페이스 생성후 JpaRepository<Entity클래스, Pk타입> 상속하면 기본 crud메소드 생성
//Entitiy와 repository는 함께 위치
public interface PostsRepository extends JpaRepository<Posts,Long> {

    //SpringDataJpa에서 제공하지 않는 메소드는 쿼리로 작성 가능
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
}
