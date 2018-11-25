package com.springbootjsf.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springbootjsf.model.SessionBean;
import com.springbootjsf.model.User;
import com.springbootjsf.services.UserService;
import com.springbootjsf.session.SessionUtils;

@Controller(value="pc_Login")
public class LoginController extends PageCodeBase{
	
	private String kullaniciId;
	
	private String kullaniciSifre;
	
	private String message = "asdasdas";
	
	private Date date;
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
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
	
	public String doLogin() {
		
		User user = userService.checkUser(getKullaniciId(), getKullaniciSifre());
		if (user !=null) {
			System.out.println("Login Basarili");
			SessionBean sessionBean  = new SessionBean();
			sessionBean.setUser(user);
			HttpSession httpSession = SessionUtils.getSession();
			httpSession.setAttribute("sessionBean", sessionBean);
			
			return "/mainpage.xhtml" + "?faces-redirect=true";
		}else{
			System.out.println("Login Basarisiz");
		}
		
		return "";
	}

}
