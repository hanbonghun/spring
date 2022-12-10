package org.example.springboot.config.auth.dto;

import lombok.Getter;
import org.example.springboot.domain.user.User;

import java.io.Serializable;

//User entity는 다른 엔티티와 관계가 형성될 수 있으므로 직렬화 할 때 그 대상에 자식들까지 포함되므로 성능 이슈 및 부수 효과 발생 따라서 직렬화 기능을 가진 세션 Dto를 추가로 만드는 것이 좋다
@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}
