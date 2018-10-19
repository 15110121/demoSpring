package com.exercise.springdemo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @NotBlank
    private String name;

    private String description;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "category")
    private Set<Product> products = new HashSet<>();

    public Category removeProduct(Product product){
        if(this.products==null) {
            this.products = new HashSet<>();
            return this;
        }
        if(product!=null) this.products.remove(product);
        return this;

    }
    public Category addProduct(Product product){
        if(this.products==null) {
            this.products = new HashSet<>();
            return this;
        }
        if(product!=null) this.products.add(product);
        return this;

    }
}
