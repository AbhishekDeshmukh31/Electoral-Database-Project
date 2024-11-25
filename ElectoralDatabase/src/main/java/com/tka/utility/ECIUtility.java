package com.tka.utility;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tka.entity.Candidate;

public class ECIUtility {

	private static Configuration cfg;
	private static SessionFactory mysqlfactory;

	private ECIUtility() {
		super();
	}

	public static Session getmysqlSession() {
		cfg = new Configuration().configure("hibernate.mysqlcfg.xml").addAnnotatedClass(Candidate.class);

		try {
			mysqlfactory = cfg.buildSessionFactory();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return mysqlfactory.openSession();
	}

	public static void close() {

		if (mysqlfactory != null) {
			mysqlfactory.close();
		}
	}

}
