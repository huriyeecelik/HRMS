package com.kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employer {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotEmpty
	@ManyToOne()
	@JoinColumn(name = "user_id")
	private User user;

	@NotEmpty
	@NotBlank(message = "Company Name cannot be empty")
	@Column(name = "company_name")
	private String companyName;

	@NotEmpty
	@NotBlank(message = "Web Site cannot be empty")
	@Column(name = "website")
	private String webSite;

	@NotEmpty
	@NotBlank(message = "Phone Number cannot be empty")
	@Column(name = "phone_number")
	private String phoneNumber;

	@Column(name = "verified")
	private Boolean verified;

	@Column(name = "verified_hrms")
	private Boolean verifiedHrms;

}
