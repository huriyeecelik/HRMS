package com.kodlamaio.hrms.core.utilities.concretes;

import org.springframework.stereotype.Service;

import com.kodlamaio.hrms.core.utilities.abstracts.EmailService;

@Service
public class EmailManager implements EmailService {

	@Override
	public boolean checkEmail(String email) {
		return false;
	}

}
