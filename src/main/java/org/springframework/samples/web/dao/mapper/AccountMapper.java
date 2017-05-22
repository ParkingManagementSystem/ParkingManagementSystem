package org.springframework.samples.web.dao.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.samples.web.domain.Account;

import java.util.List;

public interface AccountMapper {
	
	@Insert("INSERT INTO MEMBER VALUES (#{id}, #{pwd}, #{name}, #{gender}, #{phone}, #{birthday}, #{age}, #{blacklist})")
	void insertAccount(Account account);
	
	void updateAccount(Account account);
	
	void deleteAccount(String id);
	
	void stopAccount(String id);
	
	void activeAccount(String id);
	
	@Select("SELECT id, pwd, name, gender, phone, birthday, age, blacklist FROM MEMBER WHERE id = #{id}")
	Account selectAccount(String id);
	
	List<Account> getAccountList();

	List<Account> getShareAccountList();
}
