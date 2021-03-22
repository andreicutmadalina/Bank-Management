package repository;

import entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class UserRepo {
	
	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ro.tutorial.lab.SD");
	
	public void insertNewUser(User user) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		em.close();
	}

	public User findUserById(String idUser)
	{
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		User user = em.find(User.class, idUser);
		em.close();
		return  user;
	}

	public User findUserByName(String idUser)
	{
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		User user = em.find(User.class, idUser);
		em.close();
		return  user;
	}

	public List<User> findAllUsers()
	{
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		List<User> users = em.createQuery("SELECT s from User s", User.class).getResultList();
		em.close();
		return  users;
	}

	public void deleteUser(User user)
	{
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();

		em.createNativeQuery("SET FOREIGN_KEY_CHECKS=0")
				.executeUpdate();

		em.createNativeQuery("delete from User where idUser = :id")
				.setParameter("id", user.getIdUser())
				.executeUpdate();

		em.createNativeQuery("SET FOREIGN_KEY_CHECKS=1")
				.executeUpdate();


		em.getTransaction().commit();
		em.close();
	}

	public List<String> findAllUsersName(){

		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		List<User> users = em.createQuery("SELECT s from User s", User.class).getResultList();
		em.close();

		List<String > s = new ArrayList<String>();
		for(User us: users){
			s.add(us.getFirstName());
		}
		return s;
	}
	public List<String> findAllUsersEmail(){

		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		List<User> users = em.createQuery("SELECT s from User s", User.class).getResultList();
		em.close();

		List<String > s = new ArrayList<String>();
		for(User us: users){
			s.add(us.getEmail());
		}
		return s;
	}

	public User findUserEmail(String email)
	{
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		User user = em.find(User.class, email);
		em.close();
		return  user;
	}

	public User findUserCNP(String CNP)
	{
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		User user = em.find(User.class, CNP);
		em.close();
		return  user;
	}

	public void updateUserPassword(User user, String password)
	{
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();

		em.createNativeQuery("UPDATE user c SET c.password = :password WHERE c.idUser = :id")
				.setParameter("id", user.getIdUser())
				.setParameter("password", password)
				.executeUpdate();

		em.getTransaction().commit();
		em.close();
	}

	public User findUserbyMail(String email) {

		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		List<User> users = em.createQuery("SELECT s from user s where s.user.email =: email"). setParameter("email", email).getResultList();
		em.close();
		return  users.get(0);
	}
}
