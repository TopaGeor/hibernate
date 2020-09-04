package gr.codehub.hibernate.jpa.repository;

import gr.codehub.hibernate.jpa.model.Product;

import javax.persistence.EntityManager;
import java.util.Optional;

public class ProductRepository extends Repository<Product, Long>{

    public ProductRepository(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Product> getEntityClass() {
        return Product.class;
    }

    @Override
    public String getEntityClassName() {
        return Product.class.getName();
    }


}
