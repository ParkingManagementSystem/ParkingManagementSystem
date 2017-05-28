package org.springframework.samples.web.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.web.command.SignInCommand;
import org.springframework.samples.web.dao.mapper.AccountMapper;
import org.springframework.samples.web.domain.Account;
import org.springframework.samples.web.domain.Evaluate;
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
		accountMapper.stopAccount(id);
	}

	@Override
	public void activeAccount(String id) throws DataAccessException {
		accountMapper.activeAccount(id);
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
	public List<SignInCommand> getBlacklistAccount() throws DataAccessException {
		return accountMapper.getBlacklistAccount();
	}
	
	@Override
	public List<Account> getAccountList() throws DataAccessException {
		return accountMapper.getAccountList();
	}

	@Override
	public List<Evaluate> getShareAccountList() throws DataAccessException {
		return accountMapper.getShareAccountList();
	}

	@Override
	public String getAdminId(String id, String pwd) throws DataAccessException {
		return accountMapper.selectAdminId(id, pwd);
	}



}
