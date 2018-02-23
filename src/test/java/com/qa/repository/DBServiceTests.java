package com.qa.repository;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.domain.Account;
import com.qa.repository.DBService;
import com.qa.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class DBServiceTests {
	@InjectMocks
	private DBService dbServ;
	@Mock
	private EntityManager em;
	@Mock
	private Query query;
	
	private JSONUtil util;
	
	private static final String MOCK_DATA_ARRAY =  "[{\"firstName\":\"John\",\"secondName\":\"Doe\",\"accountNumber\":\"1234\"}]";
	private static final String MOCK_OBJECT = "{\"firstName\":\"John\",\"secondName\":\"Doe\",\"accountNumber\":\"1234\"}";

	@Before
	public void setup() {
		//dbServ.setManager(em);
		//util = new JSONUtil();
		//dbServ.setUtil(util);
	}
	
	@Test
	public void testGetAllAccounts() {
		//Mockito.when..... when em is called to create a query in get all accounts return a query
		//Mockito.when(em.createQuery(Mockito.anyString())).thenReturn(query);
		//List<Account> accounts = new ArrayList<Account>();
		//accounts.add(new Account("John", "Doe", "1234"));
		//Mockito.when..... when query calls getResultListthe return the accounts arrayList
		//Mockito.when(query.getResultList()).thenReturn(accounts);
		//Assert.assertEquals(MOCK_DATA_ARRAY, dbServ.getAllAcounts());
	}
	@Test
	public void testFindAnAccount() {
		fail("Not yet implemented");
	}
	@Test
	public void testCreateAnAccount() {
		//Mockito.when(dbServ.createAccount("Amy","Huberman","AH004")).thenReturn(true);
		//Assert.assertEquals(true, dbServ.createAccount("Amy","Huberman","AH004"));
		//Mockito.verify(dbServ).createAccount("Amy","Huberman","AH004");
		//Mockito.verify(dbServ, Mockito.never()).deleteUser(1L);
	}
	@Test
	public void testUpdateAnAccount() {
		fail("Not yet implemented");
	}
	@Test
	public void testDeleteAccount() {
		fail("Not yet implemented");
	}

}
