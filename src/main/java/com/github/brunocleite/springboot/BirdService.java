package com.github.brunocleite.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BirdService {

    @Autowired
    private BirdRepository birdRepository;

    public Bird getBird(String specie){
        return birdRepository.findBirdBySpecie(specie);
    }
}
