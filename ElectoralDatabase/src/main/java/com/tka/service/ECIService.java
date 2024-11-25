package com.tka.service;

import java.util.List;

import com.tka.dao.ECIDao;
import com.tka.entity.Candidate;

public class ECIService {

	ECIDao dao;

	public List<Candidate> getAllCandidateService() {
		dao = new ECIDao();
		List<Candidate> allCandidates = dao.getallCandidates();
		return allCandidates;
	}

	public void getcandidatepartyService(String pn) {
		dao = new ECIDao();
		List<Candidate> allCandidates = dao.getallCandidates();
		for (Candidate c : allCandidates) {
			if (c.getPartyname().equalsIgnoreCase(pn)) {
				System.out.println(c);
			}
		}
	}

	public void getcandidatenameService(String n) {
		dao = new ECIDao();

		List<Candidate> allCandidates = dao.getallCandidates();
		for (Candidate c : allCandidates) {
			if (c.getName().equalsIgnoreCase(n)) {
				System.out.println(c);
			}
		}

	}

	public void getcandidategenderService(String g) {
		dao = new ECIDao();

		List<Candidate> allCandidates = dao.getallCandidates();
		for (Candidate c : allCandidates) {
			if (c.getGender().equalsIgnoreCase(g)) {
				System.out.println(c);
			}
		}

	}

	public void getcandidateassemblyService(String a) {
		dao = new ECIDao();
		List<Candidate> allCandidates = dao.getallCandidates();
		for (Candidate c : allCandidates) {
			if (c.getAssembly().equalsIgnoreCase(a)) {
				System.out.println(c);
			}
		}

	}

	public void getcandidateageService(int a) {
		dao = new ECIDao();
		dao.getcandidatesbyage(a);
	}

	public void insertcandidateService(int id, String name, String partyname, String assembly, String gender, int age) {
		dao = new ECIDao();
		dao.insertCandidate(name, partyname, assembly, gender, age, id);
	}

	public void updatecandidateService(int id, String name, String partyname, String assembly, String gender, int age) {
		dao = new ECIDao();
		dao.updateCandidate(id, name, partyname, assembly, gender, age);

	}

	public void deletecandidateService(int id) {
		dao = new ECIDao();
		dao.deleteCandidate(id);
	}

}
