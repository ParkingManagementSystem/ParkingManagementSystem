package org.springframework.samples.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.web.command.AccountCommand;
import org.springframework.samples.web.dao.AccountDao;
import org.springframework.samples.web.domain.Account;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	private AccountDao accountDao;
	
	@Override
	public void insertAccount(AccountCommand accountCommand) {
		//accountCommand => account
		accountDao.insertAccount(new Account(accountCommand));
	}

	@Override
	public void updateAccount(AccountCommand accountCommand) {
		//accountCommand => account
		accountDao.updateAccount(new Account(accountCommand));
	}

	@Override
	public void deleteAccount(String id) {
		accountDao.deleteAccount(id);
	}

	@Override
	public void stopAccount(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Account selectAccount(String id) {
		return accountDao.selectAccount(id);
	}

	@Override
	public Account getAccount(String id, String pwd) {
		return accountDao.getAccount(id, pwd);
	}
	
	@Override
	public List<Account> getAccountList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> getShareAccountList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasId(String id) {
		return accountDao.hasId(id);
	}

	@Override
	public String getAdminId(String id, String pwd) {
		return accountDao.getAdminId(id, pwd);
	}
	

}
