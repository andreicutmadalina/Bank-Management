package repository;

import entity.Transactions;
import entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class TransactionsRepo {

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ro.tutorial.lab.SD");

    public void insertNewTransactions(Transactions transactions) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(transactions);
        em.getTransaction().commit();
        em.close();
    }

    public List<Transactions> findTransactionsForAccount(String idAccount){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        List<Transactions> transactions = em.createQuery("SELECT* from transactions t where s.account.id =: idAccont").
                setParameter("idAccount", idAccount).getResultList();
        em.close();
        return  transactions;

   }
}
