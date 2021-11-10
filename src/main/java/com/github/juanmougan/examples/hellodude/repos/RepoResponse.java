package com.github.juanmougan.examples.hellodude.repos;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class RepoResponse {
    String ownerName;
}
