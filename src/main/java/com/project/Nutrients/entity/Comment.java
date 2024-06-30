package com.project.Nutrients.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class Comment {

    @ManyToOne
    @JoinColumn(name = "review_id")
    private Review review_id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user_id;

    @Column
    private String title;

    @Column
    private Date created_at;
}
