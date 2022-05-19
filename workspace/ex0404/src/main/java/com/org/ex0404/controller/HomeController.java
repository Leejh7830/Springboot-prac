package com.org.ex0404.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.org.ex0404.dao.MemberDao;
import com.org.ex0404.dto.Member;
import com.org.ex0404.study.AA;

@Controller
public class HomeController {
	
//	@Autowired
//	AA a1;
//	
//	@Autowired
//	AA a2;
	
	@Autowired
	MemberDao dao;
	
	// spring 3 버전 RequestMapping
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		
		model.addAttribute("aaa",  LocalDateTime.now() );
//		System.out.println("a1 = "+a1);
//		System.out.println("a2 = "+a2);
//		System.out.println("a1 == a2 ? = "+(a1==a2));
		return "home";
	}
	
	// spring 5 버전
	@GetMapping("insert")
	public String insert(Model model) {
		return "insert";
	}
	
	// form태그 이용해서 method post
	@PostMapping("insert")
	public String insert( Member member ) {
		dao.insert(member);
		System.out.println(member.getUsername() + "님 등록되었습니다.");
		return "redirect:select";
	}
	
	// get -> 주소 바로
	@GetMapping("select")
	public String select(Model model) {
		List<Member> list = dao.selectall();
		model.addAttribute("list", list);
		return "select";
	}
	
	@PostMapping("delete")
	public String delete( @RequestParam(
			name = "id",required = false) Integer id[] ) {
		List<Integer> list=null;
		if (id != null) {
			list = Arrays.asList(id);
			System.out.println(list);
			dao.delete(list);
		} else {
			System.out.println("id : null");
		}
		return "redirect:select";
	}
	
	@GetMapping("update")
	public String update(int id, Model model) {
		Member member = dao.selectone(id);
		model.addAttribute("member", member);
		return "update";
	}
	
	@PostMapping("update")
	public String update( Member member ) {
		System.out.println("업데이트?"+member);
		dao.update(member);
		return "redirect:select";
	}
	
	
}
