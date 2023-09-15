package tp2.example.tp2.model;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

//SESSION BEAN
@Stateless //to say that is a session bean
public class EmployeeSB {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TP2_PU");
    EntityManager em = entityManagerFactory.createEntityManager();

    public List<EmployesEntity> getEmployees() {
        Query q = em.createQuery("select e from EmployesEntity e");
        return q.getResultList();
    }

}

