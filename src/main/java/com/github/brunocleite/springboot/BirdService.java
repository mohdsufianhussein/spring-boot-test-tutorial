package com.github.brunocleite.springboot;

import org.springframework.stereotype.Service;

@Service
public class BirdService {

    public Bird getBird(String specie){
        Bird birdy = new Bird(specie);
        return birdy;
    }
}
