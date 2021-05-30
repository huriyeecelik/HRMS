package com.kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaio.hrms.business.abstracts.SystemPersonnelService;
import com.kodlamaio.hrms.dataAccess.abstracts.SystemPersonnelDao;
import com.kodlamaio.hrms.entities.concretes.SystemPersonnel;

@Service
public class SystemPersonnelManager implements SystemPersonnelService {

	private SystemPersonnelDao systemPersonnelDao;

	@Autowired
	public SystemPersonnelManager(SystemPersonnelDao systemPersonnelDao) {
		this.systemPersonnelDao = systemPersonnelDao;
	}

	@Override
	public List<SystemPersonnel> getAll() {
		return this.systemPersonnelDao.findAll();
	}

}
