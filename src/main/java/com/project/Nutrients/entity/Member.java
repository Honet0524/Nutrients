package com.project.Nutrients.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@ToString
public class Member extends BaseTime implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "birth")
    private Date birth;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "nickname")
    private String nickname;

    public void patch(Member member) {
        if (member.name != null) {
            this.name = member.name;
        }
        if (member.birth != null) {
            this.birth = member.birth;
        }
        if (member.email != null) {
            this.email = member.email;
        }
        if (member.password != null) {
            this.password = member.password;
        }
        if (member.nickname != null) {
            this.nickname = member.nickname;
        }
    }

    @Builder
    public Member(String name, Date birth, String email, String password, String nickname) {
        this.name = name;
        this.birth = birth;
        this.email = email;
        this.password = password;
        this.nickname = nickname;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("Member"));
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
