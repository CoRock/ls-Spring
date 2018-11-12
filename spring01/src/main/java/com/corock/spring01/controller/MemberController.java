package com.corock.spring01.controller;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	/* @Inject
	MemberDAO memberDao; */
	
	@RequestMapping("member/list.do")
	public String memberList(Model model) {
		List<MemberDTO> list = memberService.memberList();
		
		model.addAttribute("list", list);
		
		//	WEB-INF/views/member/member_list.jsp로 포워딩
		return "member/member_list";
	}
	
	@RequestMapping("member/write.do")
	public String write() {
		//	/WEB-INF/views/member/write.jsp로 포워딩
		return "member/write";
	}
	
	/**
	 * @ModelAttribute: 폼에서 전달된 값을 저장하는 객체(생략되어 있음)
	 * 	조건: 태그의 name과 변수명이 같아야 함!
	 */
	@RequestMapping("member/insert.do")
	public String insert(@ModelAttribute MemberDTO dto) {
	// public String insert(@RequestParam String userid, @RequestParam String passwd, ...)
		// System.out.println(dto);
		
		memberService.insertMember(dto);
		// memberDao.insertMember(dto);
		
		return "redirect:/member/list.do";
	}
	
	/**
	 * @RequestParam: request.getParameter("변수명") 대체
	 */
	@RequestMapping("member/view.do")
	public String view(String userid, Model model) {
		// 모델에 자료 저장
		model.addAttribute("dto", memberService.viewMember(userid));
		// view.jsp로 포워딩
		return "member/view";
	}
	
	@RequestMapping("member/update.do")
	public String update(MemberDTO dto, Model model) {
		// 비밀번호 체크
		boolean result = memberService.checkPw(dto.getUserid(), dto.getPasswd());
		
		if (result) {		// 비밀번호가 맞으면
			// 회원정보 수정
			memberService.updateMember(dto);
			// 수정 후 목록으로 이동
			return "redirect:/member/list.do";
		} else {			// 비밀번호가 틀리면
			model.addAttribute("dto", dto);
			model.addAttribute("join_date", memberService.viewMember(dto.getUserid()).getJoin_date());
			model.addAttribute("message", "비밀번호를 입력하세요.");
			return "member/view";
		}
	}
	
	@RequestMapping("member/delete.do")
	public String delete(String userid, String passwd, Model model) {
		boolean result = memberService.checkPw(userid, passwd);
		
		if (result) {		// 비밀번호가 맞으면 삭제 => 목록으로 이동
			memberService.deleteMember(userid);
			return "redirect:/member/list.do";
		} else {			// 비밀번호가 틀리면 되돌아감
			model.addAttribute("message", "비밀번호를 확인하세요.");
			model.addAttribute("dto", memberService.viewMember(userid));
			return "member/view";
		}
	}
	
}
