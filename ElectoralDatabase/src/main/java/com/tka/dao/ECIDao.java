package com.tka.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionException;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import com.tka.entity.Candidate;
import com.tka.utility.ECIUtility;

public class ECIDao {

	Session session;
	Transaction tx;

	public List<Candidate> getallCandidates() {

		session = ECIUtility.getmysqlSession();
		@SuppressWarnings("deprecation")
		Criteria criteria = session.createCriteria(Candidate.class);
		@SuppressWarnings("unchecked")
		List<Candidate> allcandidate = criteria.list();

		ECIUtility.close();
		session.close();

		return allcandidate;
	}

	@SuppressWarnings("unchecked")
	public void getcandidatesbyage(int age) {

		try {
			session = ECIUtility.getmysqlSession();
			@SuppressWarnings("deprecation")
			Criteria criteria = session.createCriteria(Candidate.class);
			criteria.add(Restrictions.ge("age", age));
			List<Candidate> candidatebyparty = criteria.list();
			for (Candidate c : candidatebyparty) {
				System.out.println(c);

			}
		} catch (SessionException e) {
			e.printStackTrace();
		} finally {
			ECIUtility.close();
			session.close();
		}
	}

	public void insertCandidate(String name, String partyname, String assembly, String gender, int age, int id) {

		session = ECIUtility.getmysqlSession();
		try {
			Candidate candidate = new Candidate(name, partyname, assembly, gender, age, id);
			tx = session.beginTransaction();
			session.saveOrUpdate(candidate);
			session.getTransaction().commit();
		} catch (SessionException e) {
			e.printStackTrace();
		} finally {
			ECIUtility.close();
			session.close();
		}

	}

	public void updateCandidate(int id, String name, String partyname, String assembly, String gender, int age) {
		session = ECIUtility.getmysqlSession();
		try {
			tx = session.beginTransaction();
			String hql = "UPDATE Candidate c SET c.name = :newname,c.partyname =:newpname,c.assembly=:nassmb,c.gender=:ngen,c.age=:nage WHERE c.SrNo = :id";
			@SuppressWarnings("unchecked")
			Query<Candidate> updatequery = session.createQuery(hql);
			updatequery.setParameter("newname", name);
			updatequery.setParameter("id", id);
			updatequery.setParameter("newpname", partyname);
			updatequery.setParameter("nassmb", assembly);
			updatequery.setParameter("ngen", gender);
			updatequery.setParameter("nage", age);
			int result = updatequery.executeUpdate();
			System.out.println("Rows Affected: " + result);
			session.getTransaction().commit();
		} catch (SessionException e) {
			e.printStackTrace();
		} finally {
			ECIUtility.close();
			session.close();
		}

	}

	public void deleteCandidate(int SrNo) {
		session = ECIUtility.getmysqlSession();
		try {
			tx = session.beginTransaction();
			String hql = "DELETE FROM Candidate c where c.SrNo = :SrNo";
			session.createQuery(hql).setParameter("SrNo", SrNo).executeUpdate();
			session.getTransaction().commit();

		} catch (SessionException e) {
			e.printStackTrace();
		} finally {
			ECIUtility.close();
			session.close();
		}

	}

}
