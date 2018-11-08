package com.corock.spring01.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller	// 현재 클래스를 스프링에서 관리하는 컨트롤러 빈으로 등록함
public class MainController {
	
	// 로깅을 위한 변수
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	// url mapping
	@RequestMapping("/")
	public String main(Model model) {
		// Model에 자료 저장(서블릿의 request 객체에 해당됨)
		model.addAttribute("message", "홈페이지 방문을 환영합니다.");

		return "main";		// /WEB-INF/views/main.jsp로 포워딩됨
	}
	
}
