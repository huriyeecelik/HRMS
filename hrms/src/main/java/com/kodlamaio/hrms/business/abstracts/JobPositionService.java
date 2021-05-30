package com.kodlamaio.hrms.business.abstracts;

import java.util.List;

import com.kodlamaio.hrms.entities.concretes.JobPosition;

public interface JobPositionService {

	List<JobPosition> getAll();

	JobPosition add(JobPosition jobPosition);
}
