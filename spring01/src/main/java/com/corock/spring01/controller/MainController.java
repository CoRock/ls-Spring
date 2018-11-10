package com.corock.spring01.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.corock.spring01.model.dto.ProductDTO;

/**
 * @Controller: Controller Annotation(컨트롤러 객체를 자동으로 생성)
 * 	현재 클래스를 스프링에서 관리하는 컨트롤러 빈으로 등록함
 * @RequestMapping: url mapping
 */
@Controller	// 
public class MainController {
	
	// 로그 객체 생성(로깅을 위한 변수)
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@RequestMapping("/")
	public String main(Model model) {
		// Model에 자료 저장(서블릿의 request 객체에 해당됨)
		// Model: 데이터를 담는 그릇 역할, map 구조로 저장됨
		// model.addAttribute("변수명", 값)
		model.addAttribute("message", "홈페이지 방문을 환영합니다.");

		return "main";		// /WEB-INF/views/main.jsp로 포워딩됨
	}

	/**
	 * @RequestParam: get, post 방식으로 전달된 파라미터 변수
	 * 		request.getparameter("변수명")를 대체하는 코드
	 * 		defaultValue = "기본 값"
	 */
	@RequestMapping("gugu.do")	// url mapping
	public String gugu(Model model, @RequestParam(defaultValue = "2") int dan) {
		// int dan = 7;
		String result = "";
		
		for (int i = 1; i <= 9; i++) {
			result += dan + "x" + i + "=" + dan * i + "<br>";
		}
		
		// 모델에 자료 저장
		model.addAttribute("result", result);
		
		// <beans:property name="prefix" value="/WEB-INF/views/" />
		// <beans:property name="suffix" value=".jsp" />
		// return "WEB-INF/views/gugu.jsp";
		
		return "test/gugu";		// views/test/gugu.jsp로 포워딩
	}
	
	@RequestMapping("test.do")
	public void test() {
		// a void return type: method name과 같은 페이지로 이동
		// /WEB-INF/views/test.jsp
		// return "test";
	}
	
	@RequestMapping("test/doA")
	public String doA(Model model) {
		/**
		 * cf. in JSP
		 * 	request.setAttribute("message", "홈페이지 방문을 환영합니다.");
		 * 	String page = "/test/doA.jsp";
		 * 	RequestDispatcher rd = request.getRequestDispatcher(page);
		 * 	rd.forward(request, response);
		 */
		model.addAttribute("message", "홈페이지 방문을 환영합니다.");
		return "test/doA";
	}
	
	@RequestMapping("test/doB")
	public void doB() {
		// 리턴 타입이 void인 경우 url name과 같은 페이지로 포워딩
		logger.info("call doB()");
	}
	
	/**
	 * Model: 전달할 데이터
	 * ModelAndView: 데이터와 포워딩할 페이지 정보 포함
	 * 
	 * new ModelAndView("페이지이름", "변수", 값);
	 */
	@RequestMapping("test/doC")
	public ModelAndView doC() {
		Map<String, Object> map = new HashMap<>();
		map.put("product", new ProductDTO("샤프", 1000));

		// views/test/doC.jsp
		return new ModelAndView("test/doC", "map", map);
	}
	
	@RequestMapping("test/doD")
	public String doD() {
		return "redirect:/test/doE";
	}
	
	@RequestMapping("test/doE")	// doE.jsp로 포워딩
	public void doE() { }
	
	// 
	/**
	 * doF(): 뷰를 리턴하는 것이 아닌 데이터 자체를 리턴할 경우 
	 * @ResponseBody: dto를 json으로 변환
	 */
//	@ResponseBody
//	@RequestMapping("test/doF")
//	public ProductDTO doF() {
//		return new ProductDTO("냉장고", 500000);
//	}

}
