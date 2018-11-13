package com.akoglu.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akoglu.model.BeanRequest;


@Repository
public interface BeanRequestRepository extends JpaRepository<BeanRequest, Long> {
	

}
