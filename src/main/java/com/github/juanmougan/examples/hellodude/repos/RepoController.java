package com.github.juanmougan.examples.hellodude.repos;

import com.github.juanmougan.examples.hellodude.Endpoints;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class RepoController {
    private final RepoService repoService;

    @PostMapping(Endpoints.REPOS)
    @ResponseStatus(HttpStatus.CREATED)
    public RepoResponse registerRepo(@Valid @RequestBody final RepoDataStructureRequest request) {
        log.info("Got request: " + request);
        return repoService.create(request);
    }
}
