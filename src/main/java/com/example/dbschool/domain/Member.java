package com.example.dbschool.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Member {
    @Id String email;
    String name;
    String password;
    String phoneNumber;
    String studentNumber;
    @ManyToOne
    Depart depart;
}
