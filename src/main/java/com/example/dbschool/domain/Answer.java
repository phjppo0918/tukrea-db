package com.example.dbschool.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Answer {
    @Id Long id;
    @ManyToOne Question question;
    @ManyToOne Member writer;
    String content;
}
