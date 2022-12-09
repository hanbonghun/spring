package org.example.springboot.web;


import org.example.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //json 반환하는 컨트롤러로 만듦
public class HelloController {

    @GetMapping("/hello") //http get 요청 받을 수 있는 api 생성
    public String hello(){
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name,
                                     @RequestParam("amount")int amount){
        return new HelloResponseDto(name,amount);
    }
}
