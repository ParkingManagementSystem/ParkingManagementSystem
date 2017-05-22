package org.springframework.samples.web.service;

import java.util.List;
import org.springframework.samples.web.command.AccountCommand;
import org.springframework.samples.web.domain.Account;

public interface AccountService {
	
	public void insertAccount(AccountCommand accountCommand);
	
	public void updateAccount(AccountCommand accountCommand);
	
	public void deleteAccount(String id);
	
	public void stopAccount(String id);
	
	Account selectAccount(String id);
	
	List<Account> getAccountList();
	
	List<Account> getShareAccountList();
}
