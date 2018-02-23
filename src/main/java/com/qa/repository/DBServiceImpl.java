package com.qa.repository;

public interface DBServiceImpl {
	public String createAccount(String object);
	public String findAnAccount(Long id);
	public String getAllAccounts();
	public String updateAccount(Long id, String object);
	public String deleteAccount(Long id);
}
