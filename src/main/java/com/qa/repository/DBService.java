package com.qa.repository;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import com.qa.Integration.AccountEndpoint;
import com.qa.businessLogic.BLogic;
import com.qa.domain.Account;
import com.qa.util.JSONUtil;
@Transactional(SUPPORTS)
@Default
public class DBService implements DBServiceImpl{

	@PersistenceContext(unitName="primary")
	private EntityManager em;
	@Inject
	private JSONUtil jUtil;
	
	@Transactional(REQUIRED)
	public String createAccount(String message) {
		Account accnt;
		accnt = jUtil.getObjectForJSON(message, Account.class);
		BLogic bLog = new BLogic();
		if(!bLog.isValid(accnt.getAccountNumber())){
			return "{\"message\": \"This account is blocked\"}";
		}
		em.persist(accnt);
		return "{\"message\": \"Account successfully added\"}";
	}
	
	public String getAllAccounts() {
		Query query = em.createQuery("Select a FROM Account a");
		Collection<Account> accountList = (Collection<Account>) query.getResultList();
		return jUtil.getJSONForObject(accountList);
	}
	
	public String findAnAccount(Long id) {
		Account accountFound = findAccount(id);
		if(accountFound!=null) {
			return jUtil.getJSONForObject(accountFound);
		}
		return "{\"message\": \"Account not found\"}";
	}
	
	@Transactional(REQUIRED)
	public String updateAccount(Long id, String account) {
		Account accntToUpdate = jUtil.getObjectForJSON(account, Account.class);
		Account accntInDB = findAccount(id);
		if(accntToUpdate!=null) {
			BLogic bLog = new BLogic();
			if(!bLog.isValid(accntToUpdate.getAccountNumber())){
				return "{\"message\": \"This account is blocked\"}";
			}
			accntInDB.setFirstName(accntToUpdate.getFirstName());
			accntInDB.setSecondName(accntToUpdate.getSecondName());
			accntInDB.setAccountNumber(accntToUpdate.getAccountNumber());
		}
		return "{\"message\": \"account sucessfully updated\"}";
	}
	
	@Transactional(REQUIRED)
	public String deleteAccount(Long id) {
		Account accntToDelete = findAccount(id);
		if(accntToDelete!=null) {
			em.remove(accntToDelete);
		}
		return "{\"message\": \"account sucessfully deleted\"}";
	}
	
	private Account findAccount(Long id) {
		return em.find(Account.class, id);
	}
}
