package com.example.dbschool.domain;

import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

public class AnswerComment {
    @Id
    Long id;
    @ManyToOne
    Answer answer;
    @ManyToOne Member writer;
    String content;
}
