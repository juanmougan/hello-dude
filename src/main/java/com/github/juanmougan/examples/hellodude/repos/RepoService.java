package com.github.juanmougan.examples.hellodude.repos;

import org.springframework.stereotype.Service;

@Service
public class RepoService {
    public RepoResponse create(final RepoDataStructureRequest request) {
        // TODO real service here
        return RepoResponse.builder()
                .ownerName(request.getOwnerName())
                .build();
    }
}
