package br.com.robson;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@ApplicationScoped
public class EntityManagerProducer {

    @PersistenceContext(unitName = "ProjetoDataInfo")
    private EntityManager entityManager;

    @Produces
    public EntityManager produceEntityManager() {
        return entityManager;
    }

}
