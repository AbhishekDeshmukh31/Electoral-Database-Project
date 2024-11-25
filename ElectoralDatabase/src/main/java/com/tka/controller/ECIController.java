package com.tka.controller;

import java.util.List;

import com.tka.entity.Candidate;
import com.tka.service.ECIService;

public class ECIController {

	ECIService service;

	public List<Candidate> getAllCandidates() {
		service = new ECIService();
		List<Candidate> allCandidates = service.getAllCandidateService();
		return allCandidates;
	}

	public void getcandidatebyPartyController(String pn) {
		service = new ECIService();
		service.getcandidatepartyService(pn);

	}

	public void getcandidatebyNameController(String n) {
		service = new ECIService();
		service.getcandidatenameService(n);

	}

	public void getcandidatebyGenderController(String g) {
		service = new ECIService();
		service.getcandidategenderService(g);

	}

	public void getcandidatebyAssemblyController(String a) {
		service = new ECIService();
		service.getcandidateassemblyService(a);
	}

	public void getcandidatebyAgeController(int a) {
		service = new ECIService();
		service.getcandidateageService(a);

	}

	public void insertcandidatebyController(int id, String name, String partyname, String assembly, String gender,
			int age) {
		service = new ECIService();
		service.insertcandidateService(id, name, partyname, assembly, gender, age);

	}

	public void updatecandidatebyController(int id, String name, String partyname, String assembly, String gender,
			int age) {
		service = new ECIService();
		service.updatecandidateService(id, name, partyname, assembly, gender, age);

	}

	public void deletecandidatebyController(int id) {
		service = new ECIService();
		service.deletecandidateService(id);

	}

}
