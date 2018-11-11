package com.corock.spring01.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.corock.spring01.model.dto.MemberDTO;
import com.corock.spring01.service.MemberService;

/** 
 * @Controller: 스프링에서 관리하는 컨트롤러 빈으로 등록
 * @RequestMapping: url mapping
 */
@Controller
public class MemberController {

	@Inject	// MemberService 인스턴스를 주입시킴
	MemberService memberService;
	
	@RequestMapping("member/list.do")
	public String memberList(Model model) {
		List<MemberDTO> list = memberService.memberList();
		
		model.addAttribute("list", list);
		
		//	WEB-INF/views/member/member_list.jsp로 포워딩
		return "member/member_list";
	}
	
}
