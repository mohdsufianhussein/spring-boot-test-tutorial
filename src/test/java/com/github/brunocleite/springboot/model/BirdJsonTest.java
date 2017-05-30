package com.github.brunocleite.springboot.model;

import com.github.brunocleite.springboot.Bird;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@JsonTest
public class BirdJsonTest {

    @Autowired
    private JacksonTester<Bird> json;

    @Test
    public void testSerialize() throws Exception {
        Bird bird = new Bird("Barn Owl");
        // Assert against a `.json` file in the same package as the test
        assertThat(this.json.write(bird)).isEqualToJson("bird.json");
        // Or use JSON path based assertions
        assertThat(this.json.write(bird)).hasJsonPathStringValue("@.specie");
        assertThat(this.json.write(bird)).extractingJsonPathStringValue("@.specie")
                .isEqualTo("Barn Owl");
    }

    @Test
    public void testDeserialize() throws Exception {
        String content = "{\"specie\":\"Barn Owl\"}";
        assertThat(this.json.parse(content))
                .isEqualTo(new Bird("Barn Owl"));
        assertThat(this.json.parseObject(content).getSpecie()).isEqualTo("Barn Owl");
    }

}
