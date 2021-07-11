package com.poly.controllerUser;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.dao.ProductDao;
import com.poly.entity.Product;
import com.poly.service.ParamService;
import com.poly.service.SessionService;
import com.poly.service.ShoppingCartService;

@Controller
public class IndexController {
	@Autowired
	SessionService session;
	
	@Autowired
	ParamService paramsv;
	
	@Autowired
	ProductDao dao;

	@RequestMapping("xeoxo/index")
	public String index(Model model,
				@RequestParam("p") Optional<Integer> pg) {
		//load lan dau session rong, cho mac dinh la all
		String category = session.get("categoryFilter", "all");
		model.addAttribute("categoryFilter",category);
		session.set("categoryFilter", category);
		
		Sort sort = Sort.by(Direction.DESC, "price");
		Pageable pageable = PageRequest.of(pg.orElse(0), 9,sort);	
		if(category.equals("all")) category="";
		Page<Product> page = dao.findByFilter("%"+category+"%", pageable);
		model.addAttribute("page",page);
		//luu trang hien tai
		int pageNum = page.getNumber();
		session.set("pageNum", pageNum); 
		return "site/index";
	}
	
	@PostMapping("xeoxo/index")
	public String indexAndSearch(Model model,
			@RequestParam("categoryFilter") String category ,
			@RequestParam("p") Optional<Integer> pg) {
		session.set("categoryFilter", category);
		model.addAttribute("categoryFilter",category);
		Sort sort = Sort.by(Direction.DESC, "price");
		Pageable pageable = PageRequest.of(pg.orElse(0), 9,sort);
		if(category.equals("all")) category="";
		Page<Product> page = dao.findByFilter("%"+category+"%", pageable);
		model.addAttribute("page",page);
		return "site/index";
	}
	
	
	
}
