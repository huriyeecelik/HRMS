package com.kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.hrms.business.abstracts.JobAdvertService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.JobAdvert;

@RestController
@RequestMapping("/api/jobAdverts")
public class JobAdvertsController {

	private JobAdvertService jobAdvertService;

	@Autowired
	public JobAdvertsController(JobAdvertService jobAdvertService) {
		this.jobAdvertService = jobAdvertService;
	}
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvert jobAdvert) {
		return this.jobAdvertService.add(jobAdvert);
	}

	@GetMapping("/getJobAdvertByActived")
	public DataResult<List<JobAdvert>> getJobAdvertByActived() {
		return this.jobAdvertService.getJobAdvertByActived();
	}

	@GetMapping("/getJobAdvertByActivedAndDeadline")
	public DataResult<List<JobAdvert>> getJobAdvertByActivedAndDeadline() {
		return this.jobAdvertService.getJobAdvertByActivedAndDeadline();
	}

	@GetMapping("/getJobAdvertByActivedAndEmployerId")
	public DataResult<List<JobAdvert>> getJobAdvertByActivedAndEmployerId(int employerId) {
		return this.jobAdvertService.getJobAdvertByActivedAndEmployerId(employerId);
	}

}
