package com.kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kodlamaio.hrms.entities.concretes.SystemPersonnel;

@Repository
public interface SystemPersonnelDao extends JpaRepository<SystemPersonnel, Integer> {

}
