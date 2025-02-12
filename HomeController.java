package com.Controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.Entity.Student;
import com.Util.HibernateUtil;

public class HomeController {

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();

		Session session = sf.openSession();

		Student st1 = new Student();
		st1.setSid(102);
		st1.setSname("ravi");
		st1.setSaddress("nagpur");

//		session.save(st1);
//		session.saveOrUpdate(st1);
		session.beginTransaction().commit();
		System.out.println("Data Inserted");

	}
}
