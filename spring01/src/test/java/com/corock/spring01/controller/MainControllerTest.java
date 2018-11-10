package com.corock.spring01.controller;

import static org.junit.Assert.fail;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @RunWith: JUnit 4 버전으로 테스트 
 * @WebAppConfiguration: web application의 설정 정보를 가져옴
 * @ContextConfiguration: 환경설정 파일을 지정
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml" })
public class MainControllerTest {

	/**
	 * @Inject: 의존관계 주입(DI), 제어권의 역전(IoC)
	 * MockMvc: mvc를 테스트하기 위한 객체
	 */
	@Inject
	WebApplicationContext wac;
	MockMvc mockMvc;
	
	/** 
	 * @Before: JUnit test 전에 실행되는 코드
	 * @Test: JUnit이 테스트하는 코드
	 */
	@Before
	public void setup() throws Exception {
		// mvc 테스트를 위한 인스턴스 생성
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	@Test
	public void testMain() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/doA"));
	}

	@Test
	public void testGugu() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/gugu.do"));
	}

	@Test
	public void testTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/test"));
	}

	@Test
	public void testDoA() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/test/doA"));
	}

	@Test
	public void testDoB() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/test/doB"));
	}

	@Test
	public void testDoC() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/test/doC"));
	}

	@Test
	public void testDoD() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/test/doD"));
	}

	@Test
	public void testDoE() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/test/doE"));
	}

}
