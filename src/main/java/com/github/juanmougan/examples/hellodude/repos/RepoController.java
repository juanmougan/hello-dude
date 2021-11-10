package com.github.juanmougan.examples.hellodude.repos;

import com.github.juanmougan.examples.hellodude.Endpoints;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

//@RestController(Endpoints.API_PREFIX)
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class RepoController {
    private final RepoService repoService;

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @PostMapping("/hello")
    public String helloPost(@RequestBody final RepoRequest request) {
        log.info("Got request: " + request);
        return "hello POST";
    }

    @PostMapping(Endpoints.REPOS)
    @ResponseStatus(HttpStatus.CREATED)
//    public RepoResponse registerRepo(@Valid @RequestBody final RepoRequest request) {
    public RepoResponse registerRepo(@RequestBody final RepoRequest request) {
        log.info("Got request: " + request);
        return repoService.create(request);
    }
}
