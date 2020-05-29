package com.springbootjsf.controller;

import java.rmi.server.SocketSecurityException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

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
