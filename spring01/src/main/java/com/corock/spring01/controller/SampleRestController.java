package com.corock.spring01.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.corock.spring01.model.dto.ProductDTO;

/**
 * @RestController: ajax 처리 전용 컨트롤러(백그라운드에서 실행됨)
 * 	뷰를 리턴하는 것이 아닌 json을 리턴
 * 	Spring 4.0부터 사용 가능
 */
@RestController
public class SampleRestController {

	@RequestMapping("test/doF")
	public ProductDTO doF() {
		// json 데이터가 리턴됨
		return new ProductDTO("냉장고", 500000);
	}
	
}
