package gr.codehub.hibernate.jpa.repository;

import gr.codehub.hibernate.jpa.model.Customer;

import javax.persistence.EntityManager;

public class CustomerRepository   extends Repository<Customer, Long>{

    public CustomerRepository(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Customer> getEntityClass() {
        return Customer.class;
    }

    @Override
    public String getEntityClassName() {
        return Customer.class.getName();
    }


}
