package com.project.Nutrients.dto;

import com.project.Nutrients.entity.Member;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class MemberDto {

    private Long id;
    private String name;

    public Member toEntity() {
        return new Member(id, name);
    }
}
