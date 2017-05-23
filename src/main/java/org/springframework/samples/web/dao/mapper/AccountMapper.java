package org.springframework.samples.web.dao.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.samples.web.domain.Account;

import java.util.List;

public interface AccountMapper {
	
	@Select("SELECT id FROM MEMBER WHERE id = #{id}")
	String selectId(String id);
	
	@Insert("INSERT INTO MEMBER VALUES (#{id}, #{pwd}, #{name}, #{gender}, #{phone}, #{birthday}, #{age}, #{blacklist})")
	void insertAccount(Account account);
	
	void updateAccount(Account account);
	
	void deleteAccount(String id);
	
	void stopAccount(String id);
	
	void activeAccount(String id);
	
	@Select("SELECT id, pwd, name, gender, phone, birthday, age, blacklist FROM MEMBER WHERE id = #{id}")
	Account selectAccount(String id);
	
	@Select("SELECT id, pwd, name, gender, phone, birthday, age, blacklist FROM MEMBER WHERE id = #{id} and pwd = #{pwd}")
	Account getAccount(@Param("id") String id, @Param("pwd") String pwd);
	
	List<Account> getAccountList();

	List<Account> getShareAccountList();
}
