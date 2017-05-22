package org.springframework.samples.web.service;

import java.util.Calendar;
import java.util.GregorianCalendar;
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
//	
	@Override
	public void insertAccount(AccountCommand accountCommand) {
		Account account = new Account();
		account.setCommand(accountCommand);
		
		//accountCommand => account로 바꿔서 셋팅해주고 리턴해주기
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(accountCommand.getBirthday());
		int year = calendar.get(Calendar.YEAR);
		//Add one to month {0 - 11}
//		int month = calendar.get(Calendar.MONTH) + 1;
//		int day = calendar.get(Calendar.DAY_OF_MONTH);
		account.setAge(Calendar.getInstance().get(Calendar.YEAR) - year + 1); //연도 수정
		account.setBlacklist(0);
		
		accountDao.insertAccount(account);
	}

	@Override
	public void updateAccount(AccountCommand accountCommand) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAccount(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stopAccount(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Account selectAccount(String id) {
		// TODO Auto-generated method stub
		return null;
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

}
