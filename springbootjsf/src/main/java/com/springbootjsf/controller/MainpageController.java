package com.springbootjsf.controller;

import java.rmi.server.SocketSecurityException;

import org.springframework.stereotype.Controller;

import com.springbootjsf.model.User;

@Controller(value="mainPage")
public class MainpageController extends PageCodeBase{
	
	public String getSession() {
		User user = getSessionBean().getUser();
		System.out.println(user.toString());
		return "";
	}
}
