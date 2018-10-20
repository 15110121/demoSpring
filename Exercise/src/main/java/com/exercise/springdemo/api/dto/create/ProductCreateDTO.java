package com.exercise.springdemo.api.dto.create;

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
public class ProductCreateDTO {
    @NotBlank
    @NotNull
    private String name;

    private String description;

    private double price;

    private Integer amount;

    private String category;

    private int categoryId;
}
