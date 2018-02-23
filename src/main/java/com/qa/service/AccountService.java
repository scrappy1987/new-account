package com.qa.service;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import com.qa.domain.Account;
import com.qa.repository.DBServiceImpl;
import com.qa.util.JSONUtil;

@ApplicationScoped
@Alternative
public class AccountService implements DBServiceImpl {

	private Map<Integer, Account> accountMap;
	@Inject
	private JSONUtil jUtil;
	private int count = 0;

	public AccountService() {
		accountMap = new HashMap<Integer, Account>();
	}

	public int getNumberOfAccountWithFirstName(String firstNameOfAccount) {
		return (int) accountMap.values().stream()
				.filter(eachAccount -> eachAccount.getFirstName().equals(firstNameOfAccount)).count();
	}
	
	@Override
	public String createAccount(String object) {
		Account userAccount = jUtil.getObjectForJSON(object, Account.class);
		accountMap.put(count, userAccount);
		count++;
		return "{\"message\": \"Account successfully added\"}";
	}

	@Override
	public String findAnAccount(Long id) {
		int intId = id.intValue();
		return jUtil.getJSONForObject(accountMap.get(intId));
	}

	@Override
	public String getAllAccounts() {
		return jUtil.getJSONForObject(accountMap);
	}

	@Override
	public String updateAccount(Long id, String object) {
		Account accnt = jUtil.getObjectForJSON(object, Account.class);
		if(accnt!=null) {
			int intId = id.intValue();
			Account oldAccnt = accountMap.get(intId);
			oldAccnt.setAccountNumber(accnt.getAccountNumber());
			oldAccnt.setFirstName(accnt.getFirstName());
			oldAccnt.setSecondName(accnt.getSecondName());
			accountMap.put(intId, oldAccnt);
		}
		return "{\"message\": \"account sucessfully updated\"}";
	}

	@Override
	public String deleteAccount(Long id) {
		int intId = id.intValue();
		boolean countExists = accountMap.containsKey(intId);
		if (countExists) {
			accountMap.remove(intId);
		}
		return  "{\"message\": \"account sucessfully deleted\"}";
	}

}
