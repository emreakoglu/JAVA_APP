package com.springbootjsf.controller;

import javax.faces.application.Application;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.context.annotation.Scope;

import com.springbootjsf.model.SessionBean;


public abstract class PageCodeBase {
	
	@ManagedProperty(value="#{sessionBean}")
	private SessionBean sessionBean;

	public SessionBean getSessionBean() {
		FacesContext context = FacesContext.getCurrentInstance();
		Application application = context.getApplication();
		return application.evaluateExpressionGet(context, "#{sessionBean}", SessionBean.class);
	}

	public void setSessionBean(SessionBean sessionBean) {
		this.sessionBean = sessionBean;
	}
	
	public FacesContext getFacesContext() {
		FacesContext context = FacesContext.getCurrentInstance();
		return context;
	}
	

}
