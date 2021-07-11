package com.poly.controllerAdmin;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poly.service.ParamService;

@Controller
public class StataisSaleController {
	
	@Autowired
	ParamService prsv;
	
	static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

	
	@RequestMapping("admin/statissale")
	public String statisView(Model model) {
		Date today = new Date();
        String thisday = formatter.format(today);
		System.out.println(thisday);
		model.addAttribute("dateto", new Date());
		model.addAttribute("datefrom", thisday);
		return "admin/statis";
	}
	
	@PostMapping("admin/statissale")
	public String statis(Model model) {
		String dateto = prsv.getString("dateto", formatter.format(new Date()));
		String dateform = prsv.getString("dateform", formatter.format(new Date()));
		return "admin/statis";
	}
}
