package com.kodlamaio.hrms.business.abstracts;

import java.util.List;

import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.JobAdvert;

public interface JobAdvertService {
	Result add(JobAdvert jobAdvert);

	DataResult<List<JobAdvert>> getJobAdvertByActived();

	DataResult<List<JobAdvert>> getJobAdvertByActivedAndDeadline();

	DataResult<List<JobAdvert>> getJobAdvertByActivedAndEmployerId(int employerId);

}
