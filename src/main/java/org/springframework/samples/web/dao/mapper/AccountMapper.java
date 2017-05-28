package org.springframework.samples.web.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.samples.web.command.SignInCommand;
import org.springframework.samples.web.domain.Account;
import org.springframework.samples.web.domain.Evaluate;

public interface AccountMapper {
	
	@Select("SELECT id FROM MEMBER WHERE id = #{id}")
	String selectId(String id);
	
	@Insert("INSERT INTO MEMBER VALUES (#{id}, #{pwd}, #{name}, #{gender}, #{phone}, #{birthday}, #{age}, #{blacklist})")
	void insertAccount(Account account);

	@Update("UPDATE MEMBER SET name = #{name}, gender = #{gender}, phone = #{phone}, birthday = #{birthday}, age = #{age}, blacklist = #{blacklist} WHERE id =#{id}")
	void updateAccount(Account account);
	
	@Delete("DELETE FROM MEMBER WHERE id = #{id}")
	void deleteAccount(String id);
	
	@Update("UPDATE MEMBER SET blacklist = 1 WHERE id = #{id}")
	void stopAccount(String id);
	
	@Update("UPDATE MEMBER SET blacklist = 0 WHERE id = #{id}")
	void activeAccount(String id);
	
	@Select("SELECT id, pwd, name, gender, phone, birthday, age, blacklist FROM MEMBER WHERE id = #{id}")
	Account selectAccount(String id);
	
	@Select("SELECT id, pwd, name, gender, phone, birthday, age, blacklist FROM MEMBER WHERE id = #{id} and pwd = #{pwd}")
	Account getAccount(@Param("id") String id, @Param("pwd") String pwd);
	
	@Select("SELECT id, pwd FROM MEMBER WHERE blacklist = 1")
	List<SignInCommand> getBlacklistAccount();
	
	@Select("SELECT * FROM MEMBER")
	List<Account> getAccountList();

	@Select("SELECT e.id, m.name, likeCount, hateCount, avgCount, m.blacklist from member m, evaluate_history e where m.id = e.id")
	List<Evaluate> getShareAccountList();
	
	@Select("SELECT id FROM MANAGER WHERE id = #{id} and pwd = #{pwd}")
	String selectAdminId(@Param("id") String id, @Param("pwd") String pwd);
	
}
