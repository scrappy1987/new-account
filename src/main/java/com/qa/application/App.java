package com.qa.application;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.qa.domain.Account;
import com.qa.service.AccountService;
import com.qa.util.JSONUtil;

public class App {

	public static void main(String[] args) {
		/*EntityManagerFactory emf = Persistence.createEntityManagerFactory("primary");
		
		EntityManager em = emf.createEntityManager();
		         
		em.getTransaction().begin();*/

	//Added new comment
	public static void main(String[] args) {
		AccountService service = new AccountService();
		JSONUtil util = new JSONUtil();
		Account joeBloggs = new Account("Joe", "Bloggs", "1234");
		Account janeBloggs = new Account("Jane", "Bloggs", "1234");
		service.addAccountFromMap(joeBloggs);
		service.addAccountFromMap(janeBloggs);
		String mapAsJSON = util.getJSONForObject(service.getAccountMap());
		System.out.println("This is the account map as JSON " + mapAsJSON);
		
		/* em.persist(joeBloggs);
		 em.persist(janeBloggs);
		          
		 em.getTransaction().commit();
		 
		 em.close();
		 emf.close();*/

	}

	}

}
