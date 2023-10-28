package com.example.dbschool.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Question {
    @Id Long id;
    @ManyToOne Member writer;
    @ManyToOne Lecture lecture;
    String title;
    String content;
}
