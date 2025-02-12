package com.methods;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class Controller {

	public static void getAllEmployees(SessionFactory sf) {
		Session session = sf.openSession();

		Query<EmployeeDetails> employees = session.createQuery("from EmployeeDetails");

		List<EmployeeDetails> empList = employees.getResultList();

		for (EmployeeDetails employeeDetails : empList) {
			System.out.println(employeeDetails);
		}

	}

	public static void getMinSalary(SessionFactory sf) {
		Session session = sf.openSession();

		Query<Double> minsal = session.createQuery("seLect min(salary) FROM EmployeeDetails");

		double min_salary = minsal.getSingleResult();

		System.out.println("min salary = " + min_salary);
	}

	public static void find2ndMinSalary(SessionFactory sf) {
		Session session = sf.openSession();

		Query<Double> minsal = session.createQuery(
				"select min(salary) from EmployeeDetails where salary>(select min(salary) from EmployeeDetails)");

		double secondmin_salary = minsal.getSingleResult();

		System.out.println("secondmin_salary = " + secondmin_salary);
	}

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();
		// getAllEmployees(sf);
		// getMinSalary(sf);

		// find2ndMinSalary(sf);

		//fetchingEmployeeByGmail(sf);
		
		fetchNameAndSalary(sf);
	}

	private static void fetchNameAndSalary(SessionFactory sf) {
		Session s = sf.openSession();

		Query<Object[]> namesAndSalary = s.createQuery("select name,salary from EmployeeDetails");

		List<Object[]> ns = namesAndSalary.getResultList();
		
		for (Object[] objects : ns) {
			System.out.println(Arrays.toString(objects));
		}
	}

	private static void fetchingEmployeeByGmail(SessionFactory sf) {
		Session s = sf.openSession();

		Query<String> emails = s.createQuery("select emailid from EmployeeDetails where emailid like '%gmail%'");

		List<String> emailList = emails.getResultList();

		for (String email : emailList) {
			System.out.println(email);
		}
	}

}
