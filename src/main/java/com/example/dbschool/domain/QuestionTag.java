package com.example.dbschool.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class QuestionTag {
    @Id @ManyToOne Question question;
    @Id String name;
}
