package com.springbootjsf.listener;

import java.io.IOException;

import javax.faces.application.ResourceHandler;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springbootjsf.model.SessionBean;

@WebFilter("/*")
public class CharacterEncodingFilter implements Filter {

	public static final int NOT_LOGGED_IN = 1;
	public static final int NOT_AUTH = 2;
	public static final int NOT_FOUND = 3;
	public static final int SUCCESS = 4;
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		HttpServletRequest req = null;
		HttpServletResponse res = null;
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		req = (HttpServletRequest) request;
		res = (HttpServletResponse) response;
		
		if (req.getRequestURI().startsWith(req.getContextPath() + ResourceHandler.RESOURCE_IDENTIFIER)) {
		    chain.doFilter(request, response);
		    return;
		}
		
		if (isSecureResource(req)) {
			if (!req.getServletPath().equals("/login.xhtml")) {

				int msgType = checkUser(req, res);

				if (msgType < 3) {
					switch (msgType) {
					case NOT_AUTH:
						res.sendRedirect(req.getContextPath() + "/mainpage.xhtml");
						return;
					case NOT_LOGGED_IN:
						res.sendRedirect(req.getContextPath() + "/login.xhtml");
						return;

					default:
						break;
					}
				}
			}
		}

		
		chain.doFilter(request, response);

	}
	
	private boolean isSecureResource(HttpServletRequest requ) {
		if (!(requ.getServletPath().endsWith(".jsp") || requ.getServletPath().endsWith(".xhtml")
				|| requ.getServletPath().endsWith(".html") || requ.getServletPath().endsWith(".htm"))) {
			return false;
		}
		return true;
	}
	
	private int checkUser(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = ((HttpServletRequest) request).getSession(false);

		SessionBean ses = (session != null) ? (SessionBean) session.getAttribute("sessionBean") : null;

		if (ses != null) {
			if (ses.getUser().getUsername() != null) {
				return SUCCESS;
			}
			return NOT_LOGGED_IN;
		}

		return NOT_LOGGED_IN;
	}
}
