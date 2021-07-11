package com.poly.controllerUser;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.poly.dao.AccountDao;
import com.poly.dao.OrderDao;
import com.poly.dao.OrderDetailDao;
import com.poly.dao.ProductDao;
import com.poly.entity.Account;
import com.poly.entity.Item;
import com.poly.entity.Order;
import com.poly.entity.Orderdetail;
import com.poly.entity.Product;
import com.poly.service.ParamService;
import com.poly.service.SessionService;
import com.poly.service.ShoppingCartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CartController {

	@Autowired
	ShoppingCartService cart;
	
	@Autowired
	ParamService paramsv;
	
	@Autowired
	SessionService session;
	
	@Autowired
	AccountDao acdao;
	
	@Autowired
	OrderDao ordao;
	
	@Autowired
	OrderDetailDao odtdao;
	
	@Autowired
	ProductDao pdao;
	
	@RequestMapping("xeoxo/cart/view")
	public String viewCart(Model model) {
		String user = session.get("username");
		Account acc = acdao.findById(user).orElse(new Account());
		model.addAttribute("addressUser",acc.getAddress());
		model.addAttribute("emailUser",acc.getEmail());
		model.addAttribute("cart",cart);
		double total = cart.getAmount();
		model.addAttribute("totalPrice",total);
		session.set("totalPrice", total);
		return "site/cart";
	}
	
	@RequestMapping("xeoxo/return")
	public String returnHome() {
		return "redirect:/xeoxo/index";
	}
	
	@RequestMapping("xeoxo/index/add/{id}")
	public String addCart(Model model, @PathVariable("id") Integer id) {
		int pageNumber = session.get("pageNum", 0);
		cart.add(id);
		return "redirect:/xeoxo/index?p="+pageNumber;
	}
	
	@RequestMapping("xeoxo/cart/delete/{id}")
	public String deleteCart(@PathVariable("id") Integer id) {
		cart.remove(id);
		return "redirect:/xeoxo/cart/view";
	}
	
	@PostMapping("xeoxo/cart/update")
	public String updateCart(Model model) {
		int id = paramsv.getInt("id", 0);
		int qty = paramsv.getInt("qty", 0);
		cart.update(id, qty);
		return "redirect:/xeoxo/cart/view";
	}
	
	@RequestMapping("xeoxo/cart/payment")
	public String payment(Model model) {
		//lay account
		String user = session.get("username");
		Account acc = acdao.findById(user).orElse(new Account());
		//lam viec voi order
		Order order = new Order();
		order.setAccount(acc);
		order.setAddress(acc.getAddress());
		order.setMail(acc.getEmail());
		ordao.save(order);
		//lam viec voi orderdetail
		order = ordao.findTheTopId(user);
		Collection<Item> items = cart.getItems();
		for(Item item:items) {
			Product product = pdao.findById(item.getId()).orElse(new Product());
			Orderdetail detail = new Orderdetail();
			detail.setOrder(order);
			detail.setProduct(product);
			detail.setPrice(product.getPrice());
			detail.setQuantity(item.getQty());
			odtdao.save(detail);
		}
		cart.clear();
		model.addAttribute("totalPrice",session.get("totalPrice"));
		model.addAttribute("idOrder",order.getId());
		return "site/success";
	}
}
