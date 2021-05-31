package com.kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "job_adverts")
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvert {
	@Id
	@Column(name="id")
	private int id;
	
	@ManyToOne()
	@JoinColumn(name="employer_id")
	private Employer employer;
	
	@ManyToOne()
	@JoinColumn(name="job_position_id")
	private JobPosition jobPosition;
	
	@ManyToOne()
	@NotEmpty
	@NotBlank
	@JoinColumn(name="city_id")
	private City city;
	
	@NotEmpty
	@NotBlank
	@Column(name="job_description")
	private String jobDescription;

	@Column(name="max_salary")
	private int maxSalary;
	
	@Column(name="min_salary")
	private int minSalary;
	
	@NotEmpty
	@NotBlank
	@Column(name="count_of_job")
	private int countOfJob;
	
	@Column(name="deadline")
	private LocalDate deadline;
	
	@Column(name="activated")
	private boolean activated;
}
