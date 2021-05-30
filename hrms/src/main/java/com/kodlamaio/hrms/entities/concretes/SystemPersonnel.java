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
@Table(name = "system_personnel")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SystemPersonnel extends User {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotEmpty
	@ManyToOne()
	@JoinColumn(name = "user_id")
	private User user;

	@NotEmpty
	@NotBlank(message = "First Name cannot be empty")
	@Column(name = "first_name")
	private String firstName;

	@NotEmpty
	@NotBlank(message = "Last Name cannot be empty")
	@Column(name = "last_name")
	private String lastName;

}
