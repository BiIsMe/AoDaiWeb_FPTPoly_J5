package com.poly.controllerAdmin;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.dao.OrderDao;
import com.poly.dao.OrderDetailDao;
import com.poly.entity.Order;
import com.poly.entity.Orderdetail;
import com.poly.entity.Product;
import com.poly.service.ParamService;
import com.poly.service.SessionService;

@Controller
public class OrderController {

	@Autowired
	OrderDao dao;
	
	@Autowired
	OrderDetailDao dtdao;
	
	@Autowired
	ParamService prsv;
	
	@Autowired
	SessionService session;
	
	@RequestMapping("admin/order")
	public String showOr(Model model, @RequestParam("p") Optional<Integer> pg) {
		Sort sort = Sort.by(Direction.DESC, "id");
		Pageable pageable = PageRequest.of(pg.orElse(0), 10,sort);
		Page<Order> page = dao.findAll(pageable);
		model.addAttribute("page",page);	
		session.set("pageordadmin", page.getNumber());
		return "admin/order";
	}
	
	@RequestMapping("admin/order/{id}")
	public String detailOr(@PathVariable("id") Integer id,Model model) {
		List<Orderdetail> list = dtdao.findByIdOrder(id);
		model.addAttribute("listOrder",list);
		int pageNum = session.get("pageordadmin",0);
		Sort sort = Sort.by(Direction.DESC, "id");
		Pageable pageable = PageRequest.of(pageNum, 10,sort);
		Page<Order> page = dao.findAll(pageable);
		model.addAttribute("page",page);
		model.addAttribute("id",id);
		long total = dtdao.sumTotalPrice(id);
		model.addAttribute("totalPrice",total);
		return "admin/order";
	}
}
