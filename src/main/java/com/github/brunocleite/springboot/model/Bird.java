package com.github.brunocleite.springboot.model;

import lombok.Data;

@Data
public class Bird {

    private String specie;

    public Bird(String specie) {
        this.specie = specie;
    }

    public Bird() {

    }
}
