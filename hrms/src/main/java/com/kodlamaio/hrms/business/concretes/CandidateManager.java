package com.kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaio.hrms.business.abstracts.CandidateService;
import com.kodlamaio.hrms.core.utilities.abstracts.CandidateCheckService;
import com.kodlamaio.hrms.core.utilities.abstracts.EmailService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.ErrorResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;
import com.kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import com.kodlamaio.hrms.dataAccess.abstracts.UserDao;
import com.kodlamaio.hrms.entities.concretes.Candidate;
import com.kodlamaio.hrms.entities.concretes.User;

@Service
public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;
	private UserDao userDao;
	private EmailService emailService;
	private CandidateCheckService candidateCheckService;

	@Autowired
	public CandidateManager(CandidateDao candidateDao, UserDao userDao, EmailService emailService,
			CandidateCheckService candidateCheckService) {
		this.candidateDao = candidateDao;
		this.userDao = userDao;
		this.emailService = emailService;
		this.candidateCheckService = candidateCheckService;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(), "Data listelendi");
	}

	@Override
	public Result add(Candidate candidate) {
		if (control(candidate) != null) {
			return control(candidate);
		}

		User user = new User();
		user.setEmail(candidate.getUser().getEmail());
		user.setPassword(candidate.getUser().getPassword());
		user = userDao.save(user);
		candidate.setUser(user);
		this.candidateDao.save(candidate);
		return new SuccessResult("Kaydınız gerçekleşti");
	}

	private Result control(Candidate candidate) {
		DataResult<List<Candidate>> candidates = getAll();
		if (!candidates.getData().isEmpty()) {
			for (Candidate can : candidates.getData()) {
				if (!candidateCheckService.checkIfRealPerson(candidate))
					return new ErrorResult("TC Kimlik Numarası doğrulaması başarısız.");
				if (can.getUser().getEmail().equals(candidate.getUser().getEmail()))
					return new ErrorResult("Bu e-posta adresiyle başka bir kullanıcı mevcut.");
				if (can.getNationalIdentity().equals(candidate.getNationalIdentity()))
					return new ErrorResult("Bu T.C. Kimlik numarasında başka bir kullanıcı mevcut.");
				if (!emailService.checkEmail(candidate.getUser().getEmail()))
					return new ErrorResult("Email doğrulaması başarısız.");
			}
		}
		return new SuccessResult();
	}

}
