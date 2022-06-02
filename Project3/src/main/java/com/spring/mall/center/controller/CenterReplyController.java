package com.spring.mall.center.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.mall.center.service.CenterReplyService;
import com.spring.mall.center.vo.CenterReplyVO;

@Controller
@RequestMapping("/admin/**")
public class CenterReplyController {
	@Autowired
	private CenterReplyService centerReplyService;
	
	public CenterReplyController() {
		System.out.println("======= CenterReplyController() 객체 생성~~");
	}
	
	
//	
//	@GetMapping("/adminGetProductList.do")
//	public String adminGetProductList(Model model) {
//		ProductVO vo = null;
//		List<ProductVO> adminProductList = productService.getProductList(vo);
//		model.addAttribute("adminProductList",adminProductList);
//		
//		System.out.println("상품목록페이지(productList.jsp)이동 - getProductList()");
//		return "admin/productList";
//	}
	
	
}