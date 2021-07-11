package com.poly.controllerUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.dao.AccountDao;
import com.poly.entity.Account;
import com.poly.service.CookieService;
import com.poly.service.ParamService;
import com.poly.service.SessionService;

@Controller
public class LoginSignupController {

	@Autowired
	ParamService prsv;
	@Autowired
	CookieService cookie;
	@Autowired
	SessionService session;
	@Autowired
	HttpServletRequest request;
	@Autowired
	HttpServletResponse response;
	@Autowired
	AccountDao dao;
	
	
	@RequestMapping("xeoxo/login")
	public String loginForm(Model model) {
		String username = cookie.getCookie("username");
		String pass = cookie.getCookie("password");
		
		request.setAttribute("username", username);
		request.setAttribute("password", pass);
		model.addAttribute("account", new Account());
		return "site/login";
	}
	
	@PostMapping("xeoxo/login")
	public String doLogin(Model model) {
		String username = prsv.getString("username", "");
		String pass = prsv.getString("password", "");
		boolean remember = prsv.getBoolean("remember", false);
		System.out.println(remember);
		Account acc = new Account();
		acc = dao.findById(username).orElse(new Account());	 	//lỗi ko nhận đc hàm findbyid khi return về null
		if(acc.getUsername()==null) {
			model.addAttribute("message", "username is not exist");
			model.addAttribute("account", new Account());
			return "site/login";
		}
		else {
			if(!pass.equals(acc.getPassword())) {
				model.addAttribute("message", "wrong pass");
				model.addAttribute("account", new Account());
				return "site/login";
			}
			else {
				int day = remember?1:0;
				cookie.creatCookie("username", username, day);
				cookie.creatCookie("password", pass, day);
				request.setAttribute("message", "login successful");
				session.set("username"	, username); 
				session.set("nameUser", acc.getName());
				model.addAttribute("account", new Account());
				if(acc.isAdmin()) {
					return "admin/index";
				}
				else
					return "redirect:/xeoxo/index";
			}
		}		
	}
	
	@RequestMapping("xeoxo/logout")
	public String logout(Model model) {
		session.set("username", null);
		session.set("totalPrice", null);
		return "redirect:/xeoxo/index";
	}
	
	@PostMapping("xeoxo/signup")
	public String signup(Model model,@Validated @ModelAttribute("account") Account account,
				BindingResult error) {
		try {
			if(error.hasErrors()) {
				model.addAttribute("message2","Điền đầy đủ thông tin");
				return "site/login";
			}
			else {
				dao.save(account);
				session.set("username"	, account.getUsername()); 
				return "redirect:/xeoxo/index";
			}
		} catch (Exception e) {
			model.addAttribute("message2","Điền đầy đủ thông tin");
			return "site/login";
		}
	}
}
