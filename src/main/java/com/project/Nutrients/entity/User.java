package com.project.Nutrients.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private Date age;

    @Column
    private String user_id;

    @Column
    private String user_password;

    @Column
    private String nickname;

    @Column
    private Date created_at;

    @Column
    private Date updated_at;



}
