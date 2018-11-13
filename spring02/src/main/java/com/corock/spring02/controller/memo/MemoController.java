package com.corock.spring02.controller.memo;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	@RequestMapping("insert.do")
	public String insert(@ModelAttribute MemoDTO dto) {
		memoService.insert(dto);
		return "redirect:/memo/list.do";
	}
	
	// 글 번호가 PathVariable로 url에 포함되어 전달됨
	@RequestMapping("view/{idx}")
	public ModelAndView view(@PathVariable int idx, ModelAndView mav) {
		mav.setViewName("memo/view");								// 포워딩할 뷰의 이름
		mav.addObject("dto", memoService.memo_view(idx));	// 전달할 데이터
		
		return mav;
	}
	
	@RequestMapping("update/{idx}")
	public String update(@PathVariable int idx, @ModelAttribute MemoDTO dto) {
		memoService.update(dto);				// 메모 수정
		return "redirect:/memo/list.do";		// 수정 완료 후 목록으로 이동
	}
		
	// http://localhost/spring02/memo/update.do
	
}
