package com.service.provider;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class ProcessingService {
	
	@WebMethod
	public String test(String testString) {
		return testString;
	}

}
