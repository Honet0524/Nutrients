package com.project.Nutrients.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
public class Diary {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column
    private Date created_at;

    @Column
    private String title;

    @Column
    private String content;
}
