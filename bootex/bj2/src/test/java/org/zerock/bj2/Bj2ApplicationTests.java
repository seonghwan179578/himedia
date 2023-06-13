package org.zerock.bj2;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.bj2.mappers.TimeMapper;

import javax.sql.DataSource;
import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
class Bj2ApplicationTests {

	@Autowired
	DataSource dataSource;

	@Autowired
	TimeMapper timeMapper;

	@Test
	public void testTime() {

		log.info(timeMapper.getTime()); // 한국 시간이 출력되는지 확인

	}


	@Test
	void contextLoads() {
	log.info("Context Load......");
	}



	@Test
	public void testConnection() {
			
		try( java.sql.Connection con = dataSource.getConnection()) {

			log.info(con);

		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
