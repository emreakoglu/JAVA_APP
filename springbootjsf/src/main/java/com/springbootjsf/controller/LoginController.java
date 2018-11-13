package com.springbootjsf.controller;

import org.springframework.stereotype.Controller;

@Controller(value="pc_Login")
public class LoginController {
	
	private String kullaniciId;
	
	private String kullaniciSifre;
	
	private String message = "asdasdas";
	

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
		System.out.println(getKullaniciId());
		System.out.println(getKullaniciSifre());
	}

}
