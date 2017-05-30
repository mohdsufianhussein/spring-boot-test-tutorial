package com.github.brunocleite.springboot;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Bird {

    @Id
    private Long id;
    private String specie;

    public Bird(String specie) {
        this.specie = specie;
    }

    public Bird() {

    }
}
