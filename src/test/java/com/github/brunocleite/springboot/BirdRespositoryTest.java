package com.github.brunocleite.springboot;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
/**
 * @DataJpaTest Auto configures Spring Boot for testing JPA repositories
 * It uses embedded database, so H2 DB dependency should be added to pom.xml
 */
@DataJpaTest
public class BirdRespositoryTest {

    @Autowired
    private BirdRepository birdRepository;

    private Bird savedBird;

    @Before
    public void beforeEach(){
        Bird bird = new Bird("owl");
        savedBird = birdRepository.save(bird);
    }

    @Test
    public void canPersistBird(){
        assertThat(savedBird.getSpecie()).isEqualTo("owl");
    }

    @Test
    public void canGetBirdBySpecie(){
        Bird foundBird = birdRepository.findBirdBySpecie("owl");
        assertThat(foundBird.getSpecie()).isEqualTo("owl");
    }

    @Test
    public void canUpdateBird(){
        Bird foundBird = birdRepository.findBirdBySpecie("owl");
        foundBird.setSpecie("Spotted Owl");
        Bird foundBird2 = birdRepository.findBirdBySpecie("Spotted Owl");
        assertThat(foundBird2.getSpecie()).isEqualTo("Spotted Owl");
    }

    @Test
    public void canDeleteBird(){
        assertThat(birdRepository.count()).isEqualTo(1);
        Bird owl = birdRepository.findBirdBySpecie("owl");
        birdRepository.delete(owl);
        assertThat(birdRepository.count()).isEqualTo(0);
    }

}
