package org.example.springboot.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
    //스프링 시큐리티에서는 권한 코드에 항상 ROLE_이 있어야 한다
    GUEST("ROLE_GUEST","손님"),  //title : view에서 보여지는 값
    USER("ROLE_USER","일반 사용자");

    private final String key;
    private final String title;
}
