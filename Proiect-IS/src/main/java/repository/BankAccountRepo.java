package repository;

import entity.BankAccount;
import entity.Transactions;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class BankAccountRepo {

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ro.tutorial.lab.SD");

    public void insertNewBankAccount(BankAccount account) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(account);
        em.getTransaction().commit();
        em.close();
    }

    public BankAccount findBankAccountById(String idAccount)
    {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        BankAccount account = em.find(BankAccount.class, idAccount);
        em.close();
        return  account;
    }

    public List<BankAccount> findAllBankAccounts()
    {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        List<BankAccount> accounts = em.createQuery("SELECT s from BankAccount s", BankAccount.class).getResultList();
        em.close();
        return  accounts;
    }

    public void updateBalance(BankAccount account, double balance) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        em.createQuery("Update BankAccount b Set b.balance = :balance where b.idAccount = :id")
                      .setParameter("id", account.getIdAccount())
                      .setParameter("balance", balance)
                      .executeUpdate();

        em.getTransaction().commit();
        em.close();
    }

    public void updateTransactions(BankAccount account, List<Transactions> transactions) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        em.createQuery("Update BankAccount b Set b.transactions = :transactions where b.idAccount = :id")
                .setParameter("id", account.getIdAccount())
                .setParameter("transactions", transactions)
                .executeUpdate();

        em.getTransaction().commit();
        em.close();
    }

    public void deleteAccount(BankAccount account)
    {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        em.createNativeQuery("SET FOREIGN_KEY_CHECKS=0")
                .executeUpdate();

        em.createNativeQuery("delete from BankAccount where idAccount = :id")
                .setParameter("id", account.getIdAccount())
                .executeUpdate();

        em.createNativeQuery("SET FOREIGN_KEY_CHECKS=1")
                .executeUpdate();

        em.getTransaction().commit();
        em.close();
    }

    public List<BankAccount> findAllBankAccountsForUser(String idUser)
    {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        List<BankAccount> accounts = em.createQuery("SELECT s from BankAccount s where s.user.idUser =: idUser"). setParameter("idUser", idUser).getResultList();
        em.close();
        return  accounts;
    }

    public List<BankAccount> findAllBankAccountsForUserwithMail(String email)
    {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        List<BankAccount> accounts = em.createQuery("SELECT s from BankAccount s where s.user.email =: email"). setParameter("email", email).getResultList();
        em.close();
        return  accounts;
    }

    public List<String> findAllIdAccountsForUserwithMail(String email)
    {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        List<BankAccount> accounts = em.createQuery("SELECT s from BankAccount s where s.user.email =: email"). setParameter("email", email).getResultList();
        em.close();
        List<String> s = new ArrayList<String>() ;
        for (BankAccount m : accounts){
            String string = m.getIdAccount();
            s.add(string);
        }
        return s;
    }

    public List<String> findAllIdAccountForUser(String idUser){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        List<BankAccount> accounts = em.createQuery("SELECT s from BankAccount s where s.user.idUser =: idUser"). setParameter("idUser", idUser).getResultList();
        em.close();
        List<String> s = new ArrayList<String>() ;
        for (BankAccount m : accounts){
            String string = m.getIdAccount();
            s.add(string);
        }
        return s;
    }

    public List<BankAccount> findAllBankAccountsForUserName(String firstName)
    {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        List<BankAccount> accounts = em.createQuery("SELECT s from BankAccount s where s.user.firstName =: firstName"). setParameter("firstName", firstName).getResultList();
        em.close();
        return  accounts;
    }
}
