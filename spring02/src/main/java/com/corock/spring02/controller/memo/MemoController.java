package com.corock.spring02.controller.memo;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.corock.spring02.model.memo.dto.MemoDTO;
import com.corock.spring02.service.memo.MemoService;

@Controller
@RequestMapping("memo/*")	// 공통적인 url pattern
public class MemoController {

	@Inject	// 의존관계 주입
	MemoService memoService;
	
	// http://localhost/spring02/memo/list.do
	@RequestMapping("list.do")	// 세부적인 url pattern
	public ModelAndView list(ModelAndView mav) {
		List<MemoDTO> items = memoService.list();
		return new ModelAndView("memo/memo_list", "list", items);
		
		/*
		//	servlet-context.xml - WEB-INF/views/memo/memo_list.jsp
		mav.setViewName("memo/memo_list");	// 포워딩할 뷰의 이름
		mav.addObject("list", items);					// 전달할 데이터
		return mav;
		*/		
	}

	// http://localhost/spring02/memo/insert.do
	// http://localhost/spring02/memo/update.do
	
}
