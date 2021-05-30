package com.kodlamaio.hrms.core.utilities.adapters;

import org.springframework.stereotype.Service;

import com.kodlamaio.hrms.core.utilities.abstracts.CandidateCheckService;
import com.kodlamaio.hrms.entities.concretes.Candidate;

@Service
public class MernisServiceAdapter implements CandidateCheckService {

	@Override
	public boolean checkIfRealPerson(Candidate canditate) {
		System.out.println("Kişi doğrulandı : " + canditate.getFirstName() + " " + canditate.getLastName());
		return true;

	}

}
