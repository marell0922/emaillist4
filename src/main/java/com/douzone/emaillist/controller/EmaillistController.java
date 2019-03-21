package com.douzone.emaillist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.douzone.emaillist.dao.EmaillistDao;
import com.douzone.emaillist.vo.EmaillistVo;

@Controller
public class EmaillistController {
	
	@Autowired // 여기서 찾아서 바로 .주입가능.
	private EmaillistDao dao;
	
	@RequestMapping({"", "/list"})
	public String list(Model model) {
		model.addAttribute("list", dao.getList());
		return "/list";
	}
	
	@RequestMapping("/form")
	public String form() {
		return "form";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/add")
	public String add(EmaillistVo vo) {
		dao.insert(vo);
		
		//redirect
		return "redirect:/";
	}
}
