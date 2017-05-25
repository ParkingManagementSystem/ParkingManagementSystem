package org.springframework.samples.web.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.web.dao.mapper.AccountMapper;
import org.springframework.samples.web.domain.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements AccountDao {
	
	@Autowired
	private AccountMapper accountMapper;
	
	@Override
	public boolean hasId(String id) throws DataAccessException {
		return id.equals(accountMapper.selectId(id)) ? true : false;
	}
	
	@Override
	public void insertAccount(Account account) throws DataAccessException {
		// TODO Auto-generated method stub
		accountMapper.insertAccount(account);
	}

	@Override
	public void updateAccount(Account account) throws DataAccessException {
		accountMapper.updateAccount(account);
	}

	@Override
	public void deleteAccount(String id) throws DataAccessException {
		accountMapper.deleteAccount(id);
	}

	@Override
	public void stopAccount(String id) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Account selectAccount(String id) throws DataAccessException {
		return accountMapper.selectAccount(id);
	}
	
	@Override
	public Account getAccount(String id, String pwd) throws DataAccessException {
		return accountMapper.getAccount(id, pwd);
	}

	@Override
	public List<Account> getAccountList() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> getShareAccountList() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

}
