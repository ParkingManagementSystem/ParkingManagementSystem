package org.springframework.samples.web.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.web.domain.Account;

public interface AccountDao {
	
	boolean hasId(String id) throws DataAccessException;
	
	void insertAccount(Account account) throws DataAccessException;
	
	void updateAccount(Account account) throws DataAccessException;
	
	void deleteAccount(String id) throws DataAccessException;
	
	void stopAccount(String id) throws DataAccessException;
	
	Account selectAccount(String id) throws DataAccessException;
	
	Account getAccount(String id, String pwd) throws DataAccessException;
	
	List<Account> getAccountList() throws DataAccessException;
	
	List<Account> getShareAccountList() throws DataAccessException;
	
	String getAdminId(String id, String pwd) throws DataAccessException;
	
}