package com.kodlamaio.hrms.business.abstracts;

import java.util.List;

import com.kodlamaio.hrms.entities.concretes.SystemPersonnel;

public interface SystemPersonnelService {
	List<SystemPersonnel> getAll();
}
