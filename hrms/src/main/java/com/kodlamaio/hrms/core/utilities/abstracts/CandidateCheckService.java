package com.kodlamaio.hrms.core.utilities.abstracts;

import com.kodlamaio.hrms.entities.concretes.Candidate;

public interface CandidateCheckService {

	boolean checkIfRealPerson(Candidate canditate);

}
