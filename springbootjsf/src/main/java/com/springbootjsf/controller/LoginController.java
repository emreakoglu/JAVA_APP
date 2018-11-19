package com.springbootjsf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.springbootjsf.services.UserService;

@Controller(value="pc_Login")
public class LoginController {
	
	private String kullaniciId;
	
	private String kullaniciSifre;
	
	private String message = "asdasdas";
	
	@Autowired
	private UserService userService;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getKullaniciId() {
		return kullaniciId;
	}

	public void setKullaniciId(String kullaniciId) {
		this.kullaniciId = kullaniciId;
	}

	public String getKullaniciSifre() {
		return kullaniciSifre;
	}

	public void setKullaniciSifre(String kullaniciSifre) {
		this.kullaniciSifre = kullaniciSifre;
	}
	
	public void clickHelloWorldButton() {
		System.out.println("Merhaba Dunya Tıklandı");
	}
	
	public void doLogin() {
		
		boolean check = userService.checkUser(getKullaniciId(), getKullaniciSifre());
		if (check) {
			System.out.println("Login Basarili");
		}
	}

}
