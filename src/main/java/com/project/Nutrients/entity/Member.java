package com.project.Nutrients.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@ToString
public class Member extends BaseTime{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private Date birth;
    @Column
    private String memberId;
    @Column
    private String memberPassword;
    @Column
    private String nickname;

    public void patch(Member member) {
        if (member.name != null) {
            this.name = member.name;
        }
        if (member.birth != null) {
            this.birth = member.birth;
        }
        if (member.memberId != null) {
            this.memberId = member.memberId;
        }
        if (member.memberPassword != null) {
            this.memberPassword = member.memberPassword;
        }
        if (member.nickname != null) {
            this.nickname = member.nickname;
        }
    }

}
