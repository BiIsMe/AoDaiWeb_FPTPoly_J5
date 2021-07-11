package com.poly.controllerAdmin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.poly.dao.CategoryDao;
import com.poly.dao.ProductDao;
import com.poly.entity.Category;
import com.poly.entity.Product;
import com.poly.service.ParamService;
import com.poly.service.SessionService;

@Controller
public class ProductController {
	
	@Autowired
	ProductDao dao;
	
	@Autowired
	ParamService prsv;
	
	@Autowired
	SessionService session;
	
	@Autowired
	CategoryDao catedao;

	@RequestMapping("admin/index")
	public String adminIndex() {
		return "admin/index";
	}
	
	@RequestMapping("admin/product")
	public String adminProduct(Model model, @RequestParam("p") Optional<Integer> pg) {
		Pageable pageable = PageRequest.of(pg.orElse(0), 7);
		Page<Product> page = dao.findAll(pageable);
		model.addAttribute("page",page);
		model.addAttribute("product",new Product());	
		session.set("pageprodadmin", page.getNumber());
		return "admin/prodview";
	}
	
	@RequestMapping(value="admin/product", params = "btnInsert")
	public String addPro(Model model, @Validated @ModelAttribute("product") Product product,
			BindingResult errors , @RequestParam("image") MultipartFile img) {
		int pageNum = session.get("pageprodadmin",0);		
		prsv.saveFile(img, "/images/phukien");
		product.setImage(img.getOriginalFilename());
		dao.save(product);			
		Pageable pageable = PageRequest.of(pageNum, 7);
		Page<Product> page = dao.findAll(pageable);
		model.addAttribute("page",page);
		model.addAttribute("product", new Product());	
		return "admin/prodview";
	}
	
	@ModelAttribute("categories")
	public Map<String, String> getCate(){
		Map<String, String> map = new HashMap<String, String>();
		List<Category> clist = catedao.findAll();
		for(Category c : clist) {
			map.put(c.getId(), c.getName());
		}
		return map;
	}
	
	@RequestMapping(value="admin/product", params="btnReset")
	public String resetP(Model model) {
		int pageNum = session.get("pageprodadmin",0);
		Pageable pageable = PageRequest.of(pageNum, 7);
		Page<Product> page = dao.findAll(pageable);
		model.addAttribute("page",page);
		model.addAttribute("product",new Product());
		return "admin/prodview";
	}
	
	@RequestMapping(value="admin/product", params="btnUpdate")
	public String updatePro(Model model) {
		int id = prsv.getInt("id", 0);
		Product prod = dao.findById(id).orElse(new Product());
		String ima = prod.getImage();
		System.out.println(ima);
//		if(img!=null) {
//			prsv.saveFile(img, "/images/phukien");
//			prod.setImage(img.getOriginalFilename());
//		}	
		prod.setImage(ima);
		dao.save(prod);
		int pageNum = session.get("pageprodadmin",0);
		Pageable pageable = PageRequest.of(pageNum, 7);
		Page<Product> page = dao.findAll(pageable);
		model.addAttribute("page",page);
		model.addAttribute("product",prod);
		return "admin/prodview";
	}
	
	@RequestMapping("admin/product/{id}")
	public String detailPro(@PathVariable("id") Integer id, Model model) {
		Product product = dao.findById(id).orElse(new Product());
		model.addAttribute("product",product);
		model.addAttribute("imgPro",product.getImage());
		int pageNum = session.get("pageprodadmin",0);
		Pageable pageable = PageRequest.of(pageNum, 7);
		Page<Product> page = dao.findAll(pageable);
		model.addAttribute("page",page);
		return "admin/prodview";
	}
}
