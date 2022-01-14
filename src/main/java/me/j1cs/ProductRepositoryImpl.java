package me.j1cs;

import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@RequiredArgsConstructor
@Singleton
public class ProductRepositoryImpl implements ProductRepository {
    private final EntityManager entityManager;

    @Override
    @Transactional
    public Product save(String name) {
        Product product = Product.builder().name(name).build();
        entityManager.persist(product);
        return product;
    }
}
