package com.spring.mall.user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.mall.user.service.AdminUserService;
import com.spring.mall.user.vo.UserVO;

@Controller
@RequestMapping("/admin/**")
public class AdminUserController {

	@Autowired
	private AdminUserService adminUserService;

	public AdminUserController() {
		System.out.println(">> AdminController() 객체 생성~~");
	}

	// 관리자 메인 홈페이지 연결
	@GetMapping("adminMain.do")
	public String adminMain() {
		return "admin/adminMain";
	}

	// 1.관리자 회원목록 출력
	@GetMapping("/adminUserList.do")
	public String adminUserList(UserVO vo, HttpSession session) {
		System.out.println("관리자 회원목록(userList.jsp 이동 - adminUserList()");
		List<UserVO> AdminusersList = adminUserService.AdminUserList(vo);
		session.setAttribute("AdminusersList", AdminusersList);

		return "admin/userList";
	}

	// 2. 관리자 회원 상세목록 출력
	@GetMapping("adminUser.do")
	public String adminUser(UserVO vo, HttpSession session, Model model) {
		UserVO userA =  adminUserService.selectUser(vo);
		model.addAttribute("userA",userA);
//		session.setAttribute("userA", userA);
		 System.out.println(vo);
		System.out.println("관리자 회원상세페이지(user.jsp 이동 - adminUser()");
		return "admin/user";
	}

	// 3. 관리자 회원상태 휴먼회원으로 변경(0)
	@GetMapping("deleteUser.do")
	public String deleteUser(@RequestParam String user_id, UserVO vo) {
		vo.setUser_id(user_id);
		adminUserService.deleteUser(vo);
		System.out.println(vo);
		return "redirect:adminUserList.do";
	}
	
	//4. 회원 아이디, 이름으로 검색 
	@ModelAttribute("conditionMapU")
	public Map<String, String> searchConditionMap(){
		System.out.println("==> Map searchConditionMap() 실행");
		Map<String, String> conditionMapU = new HashMap<String, String>();
		conditionMapU.put("아이디", "USER_ID");
		conditionMapU.put("이름", "USER_NAME");
		

		return conditionMapU;
		
	}
	
	@RequestMapping("searchUserList.do")
	public String searchProductList(@RequestParam String searchKeyword, @RequestParam String searchCondition,UserVO vo,Model model) {
		System.out.println("searchKeyword : " + searchKeyword);
		System.out.println("searchCondition : "+ searchCondition);
		vo.setSearchKeyword(searchKeyword);
		System.out.println(vo);
		
		
		List<UserVO> searchUserList = adminUserService.searchUserList(vo);
		model.addAttribute("AdminusersList", searchUserList);
		model.addAttribute("searchKeyword", searchKeyword);
//		return "redirect:adminUserList.do";
		return "admin/userList";
	}
	

}
