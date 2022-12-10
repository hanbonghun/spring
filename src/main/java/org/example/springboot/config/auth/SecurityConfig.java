package org.example.springboot.config.auth;

import lombok.RequiredArgsConstructor;
import org.example.springboot.domain.user.Role;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity //spring security 설정 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected  void configure(HttpSecurity http) throws Exception{
        http
                .csrf().disable().headers().frameOptions().disable() //h2 console 화면 이용을 위해 옵션 disable
                .and()
                    .authorizeRequests() //URL별 권한 관리를 설정하는 옵션의 시작
                    .antMatchers("/","css/**","/images/**","/js/**","/h2-console/**").permitAll()
                    .antMatchers("/api/v1/**").hasRole(Role.USER.name())  // 해당 url은 USER권한 사람만 가능
                    .anyRequest().authenticated() //나머지 url 요청은 인증된 사용자 (로그인) 만 허용
                .and()
                    .logout()
                    .logoutSuccessUrl("/")
                .and()
                    .oauth2Login()
                    .userInfoEndpoint() //OAuth2 로그인 성공 이후 사용자 정보를 가져올 때의 설정 담당
                    .userService(customOAuth2UserService); // 소셜 로그인 성공 시 UserService 인터페이스의 구현체 등록, 사용자 정보 가져오고 추가 진행할 기능 명시 가능
    }
}
