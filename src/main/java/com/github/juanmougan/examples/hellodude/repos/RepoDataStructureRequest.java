package com.github.juanmougan.examples.hellodude.repos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
// I need both NoArgsConstructor and AllArgsConstructor if I want to use a Builder
@Builder
public class RepoDataStructureRequest {
    @NotBlank(message = "ownerName is mandatory")
    private String ownerName;
}
