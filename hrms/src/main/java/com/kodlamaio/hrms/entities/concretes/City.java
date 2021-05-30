package com.kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "cities")
@AllArgsConstructor
@NoArgsConstructor
public class City {

	    @Id
	    @GeneratedValue
	    @Column(name = "id")
	    private int id;

	    @NotNull
	    @NotEmpty
	    @Column(name = "name")
	    private String name;

	    @OneToMany(mappedBy = "city")
	    private List<JobAdvert> jobAdverts;
	}

