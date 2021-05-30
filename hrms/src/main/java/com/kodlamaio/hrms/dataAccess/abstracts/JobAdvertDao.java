package com.kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kodlamaio.hrms.entities.concretes.JobAdvert;

@Repository
public interface JobAdvertDao extends JpaRepository<JobAdvert, Integer> {
	
	@Query("from JobAdvert  where activated=true")
	List<JobAdvert> getJobAdvertByActived();
	
	@Query("from JobAdvert  where activated=true order by deadline desc")
	List<JobAdvert> getJobAdvertByActivedAndDeadline();
	
	@Query("from JobAdvert  where activated=true and employer.id=:employerId")
	List<JobAdvert> getJobAdvertByActivedAndEmployerId(int employerId);
}
