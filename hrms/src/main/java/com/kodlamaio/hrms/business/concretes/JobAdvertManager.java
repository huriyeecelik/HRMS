package com.kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaio.hrms.business.abstracts.JobAdvertService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;
import com.kodlamaio.hrms.dataAccess.abstracts.JobAdvertDao;
import com.kodlamaio.hrms.entities.concretes.JobAdvert;

@Service
public class JobAdvertManager implements JobAdvertService {
	private JobAdvertDao jobAdvertDao;

	@Autowired
	public JobAdvertManager(JobAdvertDao jobAdvertDao) {
		this.jobAdvertDao = jobAdvertDao;

	}

	@Override
	public Result add(JobAdvert jobAdvert) {
		this.jobAdvertDao.save(jobAdvert);
		return new SuccessResult("Kaydınız gerçekleşti");
	}

	@Override
	public DataResult<List<JobAdvert>> getJobAdvertByActived() {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getJobAdvertByActived(),
				"Aktif datalar listelendi");
	}

	@Override
	public DataResult<List<JobAdvert>> getJobAdvertByActivedAndDeadline() {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getJobAdvertByActivedAndDeadline(),
				"Data tarihe göre listelendi");
	}

	@Override
	public DataResult<List<JobAdvert>> getJobAdvertByActivedAndEmployerId(int employerId) {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getJobAdvertByActivedAndEmployerId(employerId), "Data listelendi");
	}

}
