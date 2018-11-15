package com.group14.project.web.test.dao;

import static org.junit.Assert.assertEquals;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.group14.project.web.dao.UserDao;

@ActiveProfiles("dev")
@ContextConfiguration(value = { "classpath:com/group14/project/web/config/dao-context.xml",
		"classpath:com/group14/project/web/test/config/datasource.xml", "classpath:com/group14/project/web/config/security-context.xml",
		"classpath:com/group14/project/web/config/service-context.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class UserDaoTest {
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private DataSource dataSource;
	
	@Before
	public void init() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		DataTestGeneration.generateData(jdbcTemplate);
	}
	
	@Test
	public void testIsUsernameExisted() {
		assertEquals(false, userDao.isUsernameExisted("tuanthanh98"));
	}
}
