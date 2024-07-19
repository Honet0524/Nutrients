package com.project.Nutrients.dto;

import com.project.Nutrients.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Date;

@AllArgsConstructor
@ToString
@Getter
public class MemberDto {

    private Long id;
    private String name;
    private Date birth;
    private String email;
    private String password;
    private String nickname;


    public Member toEntity() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        return new Member(id, name, birth, email, encoder.encode(password), nickname);
    }
}
