package gr.codehub.hibernate.jpa.repository;

import gr.codehub.hibernate.jpa.model.CartProduct;
import gr.codehub.hibernate.jpa.model.Product;

import javax.persistence.EntityManager;

public class CartProductRepository  extends Repository<CartProduct, Long>{

    public CartProductRepository(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<CartProduct> getEntityClass() {
        return CartProduct.class;
    }

    @Override
    public String getEntityClassName() {
        return CartProduct.class.getName();
    }


}
