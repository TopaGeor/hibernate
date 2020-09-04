package gr.codehub.hibernate.jpa.repository;



import javax.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public abstract class Repository<T, K> implements IRepository<T, K>{

    private EntityManager entityManager;
    public Repository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

     @Override
    public Optional<T> findById(K id) {
        T t = entityManager.find(getEntityClass(), id);
        return t != null ? Optional.of(t) : Optional.empty();
    }

    @Override
    public Optional<T> save(T t) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(t);
            entityManager.getTransaction().commit();
            return Optional.of(t);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<T> findAll() {
        return entityManager.createQuery("from "+getEntityClassName()).getResultList();
    }

    @Override
    public Optional<T> findByName(String name) {
        T t = entityManager.createQuery("SELECT b FROM "+getEntityClassName()+" b WHERE b.name = :name", getEntityClass())
                .setParameter("name", name)
                .getSingleResult();
        return t != null ? Optional.of(t) : Optional.empty();
    }

    public abstract Class<T> getEntityClass();
    public abstract String getEntityClassName();



}
