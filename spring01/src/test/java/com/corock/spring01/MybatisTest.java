package com.corock.spring01;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

// JUnit Test Case로 만든 클래스
// JUnit 4 버전으로 테스트
@RunWith(SpringJUnit4ClassRunner.class)
// 스프링 설정 파일의 위치를 지정
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class MybatisTest {

	// 로깅을 위한 변수
	private static final Logger logger = LoggerFactory.getLogger(MybatisTest.class);
	
	@Inject		// 의존관계 주입 코드(스프링에서 객체를 생성하여 전달)
	private SqlSessionFactory sqlFactory;
	
	@Test		// JUnit이 테스트할 코드
	public void testFactory() {
		logger.info("sqlFactory: " + sqlFactory);
	}
	
	@Test
	public void testSession() {
		// mybatis 실행을 위한 SqlSession 객체 생성
		try (SqlSession sqlSession = sqlFactory.openSession()) {
			logger.info("sqlSession: " + sqlSession);
			logger.info("mybatis 연결 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
