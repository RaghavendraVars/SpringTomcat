package springtomcatexample;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import model.Alien;
import model.User;

public class App {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		System.out.println("Sessionfactory value for mysqlserver Raghav :  " + sessionFactory);
		this.sessionFactory = sessionFactory;
	}

	public void addAlien(Alien alien) {

		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(alien);
		tx.commit();
		session.close();
	}

	public void addUser(User user) {

		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(user);
		tx.commit();
		session.close();
	}

	public List<User> getUsers() {

		Session session = this.sessionFactory.getCurrentSession();
		System.out.println("session in get Users : " + session);
		Transaction tx = session.beginTransaction();
		List<User> personList = (List<User>) session.createQuery("from User").list();
		session.close();
		return personList;
	}

	public List<Alien> getAliens() {

		Session session = this.sessionFactory.getCurrentSession();
		System.out.println("session in get Users : " + session);
		Transaction tx = session.beginTransaction();
		List<Alien> personList = (List<Alien>) session.createQuery("from Alien").list();
		session.close();
		return personList;
	}
}
