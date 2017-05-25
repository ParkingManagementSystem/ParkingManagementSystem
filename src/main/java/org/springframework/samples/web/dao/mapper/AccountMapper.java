package org.springframework.samples.web.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.samples.web.domain.Account;

public interface AccountMapper {
	
	@Select("SELECT id FROM MEMBER WHERE id = #{id}")
	String selectId(String id);
	
	@Insert("INSERT INTO MEMBER VALUES (#{id}, #{pwd}, #{name}, #{gender}, #{phone}, #{birthday}, #{age}, #{blacklist})")
	void insertAccount(Account account);

	@Update("UPDATE MEMBER SET name = #{name}, gender = #{gender}, phone = #{phone}, birthday = #{birthday}, age = #{age}, blacklist = #{blacklist} WHERE id =#{id}")
	void updateAccount(Account account);
	
	@Delete("DELETE FROM MEMBER WHERE id =#{id}")
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
