package com.exercise.springdemo.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    @NotNull
    @NotBlank
    private int id;

    @NotBlank
    @NotNull
    private String name;

    private String description;

    private double price;

    private Integer amount;

    private String category;

    private int categoryId;
}
