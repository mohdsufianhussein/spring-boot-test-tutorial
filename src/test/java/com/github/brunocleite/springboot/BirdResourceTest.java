package com.github.brunocleite.springboot;

import com.github.brunocleite.springboot.Bird;
import com.github.brunocleite.springboot.BirdResource;
import com.github.brunocleite.springboot.BirdService;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.BDDMockito.given;

/**
 * SpringRunner is a JUnit class runner that loads a Spring application context for use in a JUnit test and enables autowiring of beans into the test class.
 * It is an alias for SpringJUnit4ClassRunner
 */
@RunWith(SpringRunner.class)
/**
 * @WebMvcTest will:
 * - Auto-configure Spring MVC, Jackson, Gson, Message converters etc.
 * - Load relevant components (@Controller, @RestController, @JsonComponent etc)
 * - Configure MockMVC
 */
@WebMvcTest(BirdResource.class)
@Log4j2
public class BirdResourceTest {

    @Autowired
    private MockMvc mvc;

    /**
     * @MockBean will create a mock object of this bean and add to Application Context
     */
    @MockBean
    private BirdService birdService;

    @Test
    public void getBirdShouldReturnABird() throws Exception {
        //Given
        given(this.birdService.getBird("Peregrine Falcon"))
                .willReturn(new Bird("Peregrine Falcon"));

        //When
        MvcResult result = this.mvc.perform(
                get("/bird").
                accept(MediaType.APPLICATION_JSON_VALUE).
                param("specie", "Peregrine Falcon"))

        //Then
                .andExpect(status().isOk())
                .andExpect(content().json("{\"specie\":\"Peregrine Falcon\"}"))
                .andReturn();

        String content = result.getResponse().getContentAsString();
        log.info(content);
    }





}