package com.springbootjsf.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springbootjsf.model.SessionBean;
import com.springbootjsf.model.User;
import com.springbootjsf.services.UserService;
import com.springbootjsf.session.SessionUtils;

@ManagedBean(value = "pc_Login")
@Scope("session")
public class LoginController extends PageCodeBase {

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
		
		User user = hashPassword(getKullaniciSifre(),getKullaniciId());
		if (user != null) {
			System.out.println("Login Basarili");
			SessionBean sessionBean = new SessionBean();
			sessionBean.setUser(user);
			HttpSession httpSession = SessionUtils.getSession();
			httpSession.setAttribute("sessionBean", sessionBean);

			return "mainpage" + "?faces-redirect=true";
		} else {
			
			System.out.println("Login Basarisiz");
			getFacesContext().addMessage(null, new FacesMessage("Login", "Login Başarısız"));
		}

		return "";
	}
	
	private User hashPassword(String plainTextPassword,String username){
		
		List<String> allPwd = userService.findAllPassword();
		
		User user = null;
		
		boolean chechPwd = false;
		
		for (String string : allPwd) {
			chechPwd = BCrypt.checkpw(plainTextPassword, string);
			if (chechPwd) {
				user = userService.checkUser(username, string);
				return user;
			}
		}
		return user;
	}

}
