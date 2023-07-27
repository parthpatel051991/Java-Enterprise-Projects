package in.ineuron.main;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Employee;
import in.ineuron.util.HibernateUtil;

public class SaveOrUpdateApp {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;
		boolean flag = false;

		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter Employee id to be updated or created ::");
		int id = scanner.nextInt();

		System.out.print("Enter Employee name  ::");
		String name = scanner.next();

		System.out.print("Enter Employee salary ::");
		double esal = scanner.nextDouble();

		try {
			session = HibernateUtil.getSession();

			if (session != null) {
				transaction = session.beginTransaction();
				Employee employee = new Employee();
				employee.setEmpId(id);
				employee.setEmpName(name);
				employee.setEmpSal(esal);

				session.saveOrUpdate(employee);

				flag = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();

				Employee employee = session.get(Employee.class, id);
				System.out.println("Details Updated or Created as Follows ::" + employee);

			}

			HibernateUtil.closeSession();
			HibernateUtil.closeSessionFactory();
		}

	}
}
