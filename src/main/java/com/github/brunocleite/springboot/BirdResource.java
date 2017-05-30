package com.github.brunocleite.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bird")
public class BirdResource {

    @Autowired
    private BirdService birdService;

    @GetMapping
    public Bird getBird(@RequestParam String specie){
        return birdService.getBird(specie);
    }

}
