package com.github.brunocleite.springboot.services;

import com.github.brunocleite.springboot.model.Bird;
import org.springframework.stereotype.Service;

@Service
public class BirdService {

    public Bird getBird(String specie){
        Bird birdy = new Bird(specie);
        return birdy;
    }
}
