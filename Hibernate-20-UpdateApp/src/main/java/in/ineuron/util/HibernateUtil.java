package in.ineuron.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	public static SessionFactory sessionFactory = null;
	public static Session session = null;
	public static Configuration cfg = null;

	static {
		try {
			cfg = new Configuration().configure();
			sessionFactory = cfg.buildSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Session getSession() {

		if (sessionFactory != null) {
			session = sessionFactory.openSession();
		}

		return session;
	}

	public static void closeSession() {
		if (session != null) {
			session.close();
		}
	}

	public static void closeSessionFactory() {
		if (sessionFactory != null) {
			sessionFactory.close();
		}
	}

}
