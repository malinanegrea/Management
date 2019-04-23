package com.proj.persistence.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proj.persistence.entity.Application;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Integer> {

}
