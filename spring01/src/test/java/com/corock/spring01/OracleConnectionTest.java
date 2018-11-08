package com.corock.spring01;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OracleConnectionTest {

	// 로깅을 위한 변수 선언(import 주의!)
    private static final Logger logger = LoggerFactory.getLogger(OracleConnectionTest.class);
    private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";

    // 연결 문자열	jdbc:oracle:thin:@호스트:포트번호:SID
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
    private static final String USER = "spring";
    private static final String PW = "1234";
	
	@Test	// JUnit이 테스트하는 method
	public void test() throws Exception {
		Class.forName(DRIVER); // 드라이버 로딩
		try (Connection conn = DriverManager.getConnection(URL, USER, PW)) {
			logger.info("오라클에 연결되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
