package com.kodlamaio.hrms.core.utilities.concretes;

import com.kodlamaio.hrms.core.utilities.abstracts.CandidateCheckService;
import com.kodlamaio.hrms.entities.concretes.Candidate;

public class CandidateCheckManager implements CandidateCheckService {

	@Override
	public boolean checkIfRealPerson(Candidate canditate) {
		return true;
	}

}
