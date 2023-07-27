package in.ineuron.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.Model.Employee;
import in.ineuron.util.HibernateUtil;

public class ReadApp {

	public static void main(String[] args) {
	
		Session session = null;
		int id=15;
		
		try {
			session = HibernateUtil.getSession();

			if (session != null) {
				
				Employee employee = session.get(Employee.class, id);
				
				if (employee!=null) {
					
					System.out.println(employee);
				}else {
					System.out.println("Employee is not available for given id "+id);
				}
				
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
			
			HibernateUtil.closeSession(session);
			
		}
	}


