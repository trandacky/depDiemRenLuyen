package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entity.TaiKhoan;
import com.example.demo.service.TaiKhoanService;

@Controller
public class AdminController {

	@Autowired
	private TaiKhoanService taiKhoanService;
	@RequestMapping(value = { "/logout" }, method = RequestMethod.GET)
	public String index(Model model) {
		
		return "redirect:index";
	}
	@RequestMapping(value = { "/index" }, method = RequestMethod.GET)
	public String index2(Model model) {
		TaiKhoan taiKhoan= new TaiKhoan();
		taiKhoan.setMaSinhVien("admin");
		taiKhoan.setMatKhau("admin");
		taiKhoan.setQuyen(4);
		taiKhoan.setTen("Kỳ");
		taiKhoanService.setData(taiKhoan);
		return "/index";
	}
	@RequestMapping(value = { "/loginfail" }, method = RequestMethod.GET)
	public String loginfail(Model model) {
	
		return "/index";
	}
	@RequestMapping(value = { "/quanly" }, method = RequestMethod.GET)
	public String loginAdmin(Model model) {
		return "redirect:/quanly/taikhoan";
	}
	 public static String encrytePassword(String password) {
	        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	        return encoder.encode(password);
	    }
}
