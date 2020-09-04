package gr.codehub.hibernate.jpa.repository;

import gr.codehub.hibernate.jpa.model.Cart;


import javax.persistence.EntityManager;

public class CartRepository  extends Repository<Cart, Long>{

    public CartRepository(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Cart> getEntityClass() {
        return Cart.class;
    }

    @Override
    public String getEntityClassName() {
        return Cart.class.getName();
    }


}
