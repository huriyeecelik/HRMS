package com.kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaio.hrms.business.abstracts.EmployerService;
import com.kodlamaio.hrms.core.utilities.abstracts.EmailService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.ErrorResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;
import com.kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import com.kodlamaio.hrms.dataAccess.abstracts.UserDao;
import com.kodlamaio.hrms.entities.concretes.Employer;
import com.kodlamaio.hrms.entities.concretes.User;

@Service
public class EmployerManager implements EmployerService {
	private EmployerDao employerDao;
	private UserDao userDao;
	private EmailService emailService;

	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		this.employerDao = employerDao;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "Data listelendi");
	}

	@Override
	public Result add(Employer employer) {
		if (control(employer) != null) {
			return control(employer);
		}

		User user = new User();
		user.setEmail(employer.getUser().getEmail());
		user.setPassword(employer.getUser().getPassword());
		user = userDao.save(user);
		employer.setUser(user);
		this.employerDao.save(employer);
		return new SuccessResult("Kaydınız gerçekleşti");
	}

	private Result control(Employer employer) {
		DataResult<List<Employer>> employers = getAll();
		String[] emailSplit = employer.getUser().getEmail().split("@");
		if (!emailSplit[1].equals(employer.getWebSite()))
			return new ErrorResult("E-posta adresinizin domaini web siteniz ile aynı olmalıdır.");
		if (!employers.getData().isEmpty()) {
			for (Employer emp : employers.getData()) {
				if (emp.getUser().getEmail().equals(employer.getUser().getEmail()))
					return new ErrorResult("Bu e-posta adresiyle başka bir kullanıcı mevcut.");
				if (!emailService.checkEmail(employer.getUser().getEmail()))
					return new ErrorResult("Email doğrulaması başarısız.");
			}
		}
		return new SuccessResult();
	}

}
