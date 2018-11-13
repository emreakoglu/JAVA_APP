package com.akoglu.webapp;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.akoglu.model.BeanRequest;
import com.akoglu.service.BeanRequestService;


//@Component(value="beanRequestController")
@Controller(value="beanRequestController")
@RequestMapping("/beanRequestController")
@Scope("request")
public class BeanRequestBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(BeanRequestBean.class);
	
	@Autowired
	BeanRequestService beanRequestService;
	private BeanRequest beanRequest;
	
	private List<BeanRequest> requests;
	
	public BeanRequestBean() {
		
	}
	
	@PostConstruct
	public void init() {
		this.beanRequest = new BeanRequest();
		this.requests = beanRequestService.findAll();
	}
	

	@RequestMapping(value = "/save")
	public void save() {
		logger.info("new car is going to be saved: {} ", this.beanRequest);
		beanRequestService.add(beanRequest);
		this.init();
	}
	
	public void requests() {
		List<BeanRequest> beanRequests = beanRequestService.findAll();
		this.requests = beanRequests;
	}

	public BeanRequestService getBeanRequestService() {
		return beanRequestService;
	}

	public void setBeanRequestService(BeanRequestService beanRequestService) {
		this.beanRequestService = beanRequestService;
	}

	public BeanRequest getBeanRequest() {
		return beanRequest;
	}

	public void setBeanRequest(BeanRequest beanRequest) {
		this.beanRequest = beanRequest;
	}

	public List<BeanRequest> getRequests() {
		return requests;
	}

	public void setRequests(List<BeanRequest> requests) {
		this.requests = requests;
	}
	
	

}
