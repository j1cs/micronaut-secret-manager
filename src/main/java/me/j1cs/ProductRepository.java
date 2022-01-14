package me.j1cs;


import javax.validation.constraints.NotBlank;

public interface ProductRepository {
    Product save(@NotBlank String name);
}
