package com.poly.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.poly.dao.ProductDao;
import com.poly.entity.Item;
import com.poly.entity.Product;



@SessionScope
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService{
	@Autowired
	ProductDao dao;
	
	Map<Integer, Item> map = new HashMap<>();
	@Override
	public Item add(Integer id) {
		try {
			Product prod = dao.findById(id).get();
			Item item = map.get(id);
			if(item == null) {
				item = new Item(id,prod.getName(),prod.getPrice(),1,prod.getImage());
				map.put(id, item);
			} else {
				item.setQty(item.getQty() + 1);
			}
			return item;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@Override
	public void remove(Integer id) {
		map.remove(id);
	}
	
	@Override
	public Item update(Integer id, int qty) {
		Item item = map.get(id);
		item.setQty(qty);
		return item;
	}
	
	@Override
	public void clear() {
		map.clear();
	}
	
	@Override
	public Collection<Item> getItems() {
		return map.values();
	}
	
	@Override
	public int getCount() {
		return map.values().stream()
				.mapToInt(item -> item.getQty())
				.sum();
	}
	
	@Override
	public double getAmount() {
		return map.values().stream()
				.mapToDouble(item -> item.getPrice()*item.getQty())
				.sum();
	}
}