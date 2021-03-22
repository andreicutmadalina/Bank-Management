package repository;

import entity.Admin;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AdminRepo {

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ro.tutorial.lab.SD");

    public void insertNewAdmin(Admin admin) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(admin);
        em.getTransaction().commit();
        em.close();
    }

    public Admin findAdminById(String idAdmin)
    {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Admin admin = em.find(Admin.class, idAdmin);
        em.close();
        return  admin;
    }
}
