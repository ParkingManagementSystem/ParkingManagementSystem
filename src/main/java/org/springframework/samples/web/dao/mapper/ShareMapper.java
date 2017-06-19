package org.springframework.samples.web.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Arg;
import org.apache.ibatis.annotations.ConstructorArgs;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;
import org.springframework.samples.web.command.ShareParkingCommand;
import org.springframework.samples.web.domain.Apply;
import org.springframework.samples.web.domain.ShareParking;

public interface ShareMapper {

	@Insert("INSERT INTO SHARE_PARKING (SHARE_PARKING_CODE, WRITER_ID, PARKING_NAME, ADDRESS, GU, ALTITUDE, LONGITUDE, PHONE, CAR_TYPE, COST, BLACKLIST, TITLE, CONTENT, IMAGE) VALUES"
			+ "( SHARE_SEQ.NEXTVAL , #{writerId}, #{parkingName}, #{address}, #{gu}, #{altitude}, #{longitude}, #{phone}, #{carType}, #{cost}, #{blackList}, #{title}, #{content}, null )")
	void insertShareParking(ShareParking shareParking);
	
	void udpateShareParking(ShareParking shareParking);
	
	@Select("SELECT SHARE_PARKING_CODE, PARKING_NAME, ADDRESS, GU, ALTITUDE, LONGITUDE, PHONE," +
         "CAR_TYPE, COST, BLACKLIST, TITLE, CONTENT, WRITER_ID FROM SHARE_PARKING " +
		 "WHERE SHARE_PARKING_CODE = #{shareParkingCode}")
	@ConstructorArgs({
	@Arg(column = "SHARE_PARKING_CODE",javaType=String.class, jdbcType = JdbcType.NVARCHAR),@Arg(column = "WRITER_ID",javaType=String.class, jdbcType = JdbcType.NVARCHAR),
	@Arg(column = "PARKING_NAME",javaType=String.class, jdbcType = JdbcType.NVARCHAR), @Arg(column = "ADDRESS",javaType=String.class, jdbcType = JdbcType.NVARCHAR),
	@Arg(column = "GU",javaType=String.class, jdbcType = JdbcType.NVARCHAR),
	@Arg(column = "ALTITUDE", javaType=Double.class, jdbcType = JdbcType.NUMERIC),
	@Arg(column = "LONGITUDE", javaType=Double.class, jdbcType = JdbcType.NUMERIC),
	@Arg(column = "PHONE",javaType=String.class, jdbcType = JdbcType.NVARCHAR),@Arg(column = "CAR_TYPE",javaType=String.class, jdbcType = JdbcType.NVARCHAR),
	@Arg(column = "COST", javaType=int.class, jdbcType = JdbcType.NUMERIC),@Arg(column = "BLACKLIST" , javaType=int.class, jdbcType = JdbcType.NUMERIC),
	@Arg(column = "TITLE",javaType=String.class, jdbcType = JdbcType.NVARCHAR),@Arg(column = "CONTENT",javaType=String.class, jdbcType = JdbcType.NVARCHAR),
	})
	ShareParkingCommand getShareParkingCommand(String shareParkingCode); 
	
	@Select("SELECT SHARE_PARKING_CODE, PARKING_NAME, ADDRESS, GU, ALTITUDE, LONGITUDE, PHONE," +
	         "CAR_TYPE, COST, BLACKLIST, TITLE, CONTENT, WRITER_ID FROM SHARE_PARKING ")
		@ConstructorArgs({
		@Arg(column = "SHARE_PARKING_CODE",javaType=String.class, jdbcType = JdbcType.NVARCHAR),@Arg(column = "WRITER_ID",javaType=String.class, jdbcType = JdbcType.NVARCHAR),
		@Arg(column = "PARKING_NAME",javaType=String.class, jdbcType = JdbcType.NVARCHAR), @Arg(column = "ADDRESS",javaType=String.class, jdbcType = JdbcType.NVARCHAR),
		@Arg(column = "GU",javaType=String.class, jdbcType = JdbcType.NVARCHAR),
		@Arg(column = "ALTITUDE", javaType=Double.class, jdbcType = JdbcType.NUMERIC),
		@Arg(column = "LONGITUDE", javaType=Double.class, jdbcType = JdbcType.NUMERIC),
		@Arg(column = "PHONE",javaType=String.class, jdbcType = JdbcType.NVARCHAR),@Arg(column = "CAR_TYPE",javaType=String.class, jdbcType = JdbcType.NVARCHAR),
		@Arg(column = "COST", javaType=int.class, jdbcType = JdbcType.NUMERIC),@Arg(column = "BLACKLIST" , javaType=int.class, jdbcType = JdbcType.NUMERIC),
		@Arg(column = "TITLE",javaType=String.class, jdbcType = JdbcType.NVARCHAR),@Arg(column = "CONTENT",javaType=String.class, jdbcType = JdbcType.NVARCHAR),
		})
	List<ShareParking> getShareParkingList();
	
	@Insert("INSERT INTO APPLY_HISTORY (APPLY_CODE, SHARE_PARKING_CODE, APPROVAL, APPLIER_CODE, WRITER_CODE) VALUES" 
			+" (APPLY_SEQ.NEXTVAL , #{shareParkingCode}, #{approval}, #{applierCode}, #{writerCode} )")
	void insertShareApply(Apply apply);
	
	@Select("SELECT APPLY_CODE, SHARE_PARKING_CODE, APPROVAL, APPLIER_CODE, WRITER_CODE FROM APPLY_HISTORY WHERE SHARE_PARKING_CODE = #{shareParkingCode} AND APPROVAL =0")
	@ConstructorArgs({
	@Arg(column = "APPLY_CODE",javaType=String.class, jdbcType = JdbcType.NVARCHAR),
	@Arg(column = "SHARE_PARKING_CODE",javaType=String.class, jdbcType = JdbcType.NVARCHAR),
	@Arg(column = "APPROVAL",javaType=int.class, jdbcType = JdbcType.NUMERIC),
	@Arg(column = "APPLIER_CODE", javaType=String.class, jdbcType = JdbcType.NVARCHAR),
	@Arg(column = "WRITER_CODE", javaType=String.class, jdbcType = JdbcType.NVARCHAR),
	})
	List<Apply> getApplyList(String shareParkingCode);
	
	@Select("SELECT APPLY_CODE, APPROVAL, SHARE_PARKING_CODE, APPLIER_CODE applierCode, WRITER_CODE FROM APPLY_HISTORY WHERE SHARE_PARKING_CODE = '2' and APPLIER_CODE = 'bomi' ")
	@ConstructorArgs({
	@Arg(column = "APPLY_CODE",javaType=String.class, jdbcType = JdbcType.NVARCHAR),
	@Arg(column = "SHARE_PARKING_CODE",javaType=String.class, jdbcType = JdbcType.NVARCHAR),
	@Arg(column = "APPROVAL",javaType=int.class, jdbcType = JdbcType.NUMERIC),
	@Arg(column = "APPLIER_CODE", javaType=String.class, jdbcType = JdbcType.NVARCHAR),
	@Arg(column = "WRITER_CODE", javaType=String.class, jdbcType = JdbcType.NVARCHAR)
	})
	Apply getApply(String shareParkingCode, String applierCode);
}
