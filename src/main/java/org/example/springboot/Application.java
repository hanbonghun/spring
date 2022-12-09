package org.example.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // 해당 annotation 이 있는 곳부터 설정을 읽어감 (스프링 부트 자동 설정, bean 읽기, 생성 등)
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class); //내장 WAS 실행 -> 어디서나 스프링 부트 배포 가능
    }
}