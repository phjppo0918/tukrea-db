package com.example.dbschool.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class AnswerComment {
    @Id
    Long id;
    @ManyToOne
    Answer answer;
    @ManyToOne Member writer;
    String content;
}
