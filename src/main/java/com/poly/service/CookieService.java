package com.poly.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CookieService {

	@Autowired
	HttpServletRequest request;
	
	@Autowired
	HttpServletResponse response;
	
	//đọc cookie
	public String getCookie(String name) {
		Cookie[] cookies = request.getCookies();
		if(cookies!=null) {
			for(Cookie cookie : cookies) {
				if(cookie.getName().equalsIgnoreCase(name))
					return cookie.getValue();
			}
		}
		return "";
	}
	
	
	
	//taọ và gủi cookie về client
	public Cookie creatCookie(String name, String value,int days) {
		Cookie cookie = new Cookie(name,value);
		cookie.setMaxAge(days*60*60*24);
		cookie.setPath("/");
		
		response.addCookie(cookie);
		return cookie;
	}
	
}
