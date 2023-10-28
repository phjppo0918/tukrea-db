package com.example.dbschool.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Univ {
    @Id String code;
    String name;
    String emailDomain;
}
