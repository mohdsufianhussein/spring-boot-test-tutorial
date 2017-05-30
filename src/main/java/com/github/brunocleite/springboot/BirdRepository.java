package com.github.brunocleite.springboot;

import org.springframework.data.repository.CrudRepository;

public interface BirdRepository extends CrudRepository<Bird, Long> {

    Bird findBirdBySpecie(String specie);

}
