package com.akoglu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;

import com.akoglu.model.BeanRequest;
import com.akoglu.repositories.BeanRequestRepository;

@Service
public class BeanRequestService {
	
	
	@Autowired
	BeanRequestRepository beanRequestRepository;
	
	public BeanRequest create() {
		BeanRequest beanRequest = new BeanRequest();
		return beanRequest;
	}
	
	public BeanRequest findById(Long id) {
		return beanRequestRepository.findOne(id);
	}
	
	public void delete(BeanRequest beanRequest) {
		beanRequestRepository.delete(beanRequest);
	}
	
	public void add(BeanRequest beanRequest) {
		beanRequestRepository.saveAndFlush(beanRequest);
	}
	
	public List<BeanRequest> findAll() {
		return beanRequestRepository.findAll();
	}

}
