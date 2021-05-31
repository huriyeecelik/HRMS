package com.kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "candidates")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Candidate {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotEmpty
    @ManyToOne()
	@JoinColumn(name = "user_id")
	private User user;

	@NotEmpty
	@NotBlank
	@Column(name = "first_name")
	private String firstName;

	@NotEmpty
	@NotBlank
	@Column(name = "last_name")
	private String lastName;

	@NotEmpty
	@NotBlank
	@Column(name = "national_identity")
	private String nationalIdentity;

	@NotEmpty
	@NotBlank
	@Column(name = "birthday_year")
	private Integer birthdayYear;

	@Column(name = "verified")
	private Boolean verified;
}
