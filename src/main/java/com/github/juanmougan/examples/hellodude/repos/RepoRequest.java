package com.github.juanmougan.examples.hellodude.repos;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.Value;

import javax.validation.constraints.NotBlank;

@Value
@Builder
// Because Lombok and Jackson: https://stackoverflow.com/a/67344418/3923525
@JsonDeserialize(builder = RepoRequest.RepoRequestBuilder.class)
public class RepoRequest {
    // TODO not working from outside, maybe the bean isn't properly created?
    @NotBlank(message = "ownerName is mandatory")
    String ownerName;
}
