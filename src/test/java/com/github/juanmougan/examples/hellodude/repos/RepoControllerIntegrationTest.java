package com.github.juanmougan.examples.hellodude.repos;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.juanmougan.examples.hellodude.Endpoints;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class RepoControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void givenNotValidOwnerName_whenRegisterRepo_thenReturnBadRequest() throws Exception {
        // GIVEN an invalid input
        final RepoDataStructureRequest request = RepoDataStructureRequest.builder().build();
        final String requestBody = objectMapper.writeValueAsString(request);
        // WHEN a repo is registered THEN a 400 error is returned
        mockMvc.perform(
                post(Endpoints.REPOS)
                        .contentType(APPLICATION_JSON)
                        .content(requestBody)
        ).andExpect(status().isBadRequest());
    }

    @Test
    public void givenValidOwnerName_whenRegisterRepo_thenReturnCreated() throws Exception {
        // GIVEN a valid input
        final RepoDataStructureRequest request = RepoDataStructureRequest.builder()
                .ownerName("juanmougan")
                .build();
        final String requestBody = objectMapper.writeValueAsString(request);
        // WHEN a repo is registered THEN a 201 is returned
        mockMvc.perform(
                post(Endpoints.REPOS)
                        .contentType(APPLICATION_JSON)
                        .content(requestBody)
        ).andExpect(status().isCreated());
    }
}
