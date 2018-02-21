package com.qa.repository;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.repository.DBService;
import com.qa.util.JSONUtil;



@RunWith(MockitoJUnitRunner.class)
public class DBServiceTest {

	@InjectMocks
	private DBService endpoint;
	
	@Mock
	private EntityManager manager;
	
	@Mock
	private Query query;
	
	private JSONUtil util;
	
	private static final String MOCK_ARRAY =  "[{\"firstName\":\"Brendan\",\"secondName\":\"Greene\",\"accountNumber\":\"1234\"}]";
	
	private static final String MOCK_OBJECT =  "[{\"firstName\":\"Brendan\",\"secondName\":\"Greene\",\"accountNumber\":\"1234\"}]";

	
	@Before
	public void setUp() {
		endpoint.setManager(manager);
		util = new JSONUtil();
		endpoint.setUtil(util);
		
	}
	
	@Test
	public void testGetAllAccounts() {
		
	}
	
	@Test
	public void testFindAnAccount

}
