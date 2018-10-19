package com.exercise.springdemo.api.dto.update;

import com.exercise.springdemo.domain.Category;
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
public class ProductUpdateDTO {

    @NotNull
    @NotBlank
    private Long id;

    @NotBlank
    @NotNull
    private String name;

    private String description;

    private double price;

    private Integer amount;

    private Long categoryId;
}
