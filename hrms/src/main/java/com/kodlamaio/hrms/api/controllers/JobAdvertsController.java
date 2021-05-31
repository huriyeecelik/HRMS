package com.kodlamaio.hrms.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.hrms.business.abstracts.JobAdvertService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import com.kodlamaio.hrms.entities.concretes.JobAdvert;

@RestController
@RequestMapping("/api/jobAdverts")
public class JobAdvertsController {

	private JobAdvertService jobAdvertService;

	@Autowired
	public JobAdvertsController(JobAdvertService jobAdvertService) {
		this.jobAdvertService = jobAdvertService;
	}
	@PostMapping(value = "/add")
	public ResponseEntity<?> add(@Valid @RequestBody JobAdvert jovAdvert) {
		return ResponseEntity.ok(this.jobAdvertService.add(jovAdvert));
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
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions) {
		Map<String, String> validationErrors = new HashMap<String, String>();
		for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}

		ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors, "Doğrulama Hataları");
		return errors;
	}


}
