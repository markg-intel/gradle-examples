package net.petrikainulainen.gradle.webapp.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * @author Petri Kainulainen
 */
public class HelloControllerTest {

    private MockMvc mymockMvc;

    @Before
    public void setUp() {
        mymockMvc = MockMvcBuilders.standaloneSetup(new HelloController())
                .build();
    }

    @Test
    public void renderHelloView_ShouldReturnResponseStatusOk() throws Exception {
        mymockMvc.perform(get("/"))
                .andExpect(status().isOk());
    }

    @Test
    public void renderHelloView_ShouldRenderHelloPage() throws Exception {
        mymockMvc.perform(get("/"))
                .andExpect(view().name("index"));
    }
}
