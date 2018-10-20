package com.exercise.springdemo.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {

    @NotNull
    @NotBlank
    private int id;

    @NotNull
    @NotBlank
    private String name;

    private String description;

    private Set<ProductDTO> products = new HashSet<>();
}
