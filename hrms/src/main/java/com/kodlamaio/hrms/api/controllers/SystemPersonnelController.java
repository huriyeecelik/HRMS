package com.kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.hrms.business.abstracts.SystemPersonnelService;
import com.kodlamaio.hrms.entities.concretes.SystemPersonnel;

@RestController
@RequestMapping("/api/systemPersonnel")
public class SystemPersonnelController {

	private SystemPersonnelService systemPersonnelService;

	@Autowired
	public SystemPersonnelController(SystemPersonnelService systemPersonnelService) {
		this.systemPersonnelService = systemPersonnelService;
	}
	
	@GetMapping("/getAll")
	public List<SystemPersonnel> getAll() {
		return this.systemPersonnelService.getAll();
	}
}
