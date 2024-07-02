package com.project.Nutrients.dto;

import com.project.Nutrients.entity.Member;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@ToString
public class MemberDto {

    private Long id;
    private String name;
    private Date birth;
    private String memberId;
    private String memberPassword;
    private String nickname;


    public Member toEntity() {
        return new Member(id, name, birth, memberId, memberPassword, nickname);
    }
}
