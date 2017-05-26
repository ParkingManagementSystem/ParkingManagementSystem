package org.springframework.samples.web.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Arg;
import org.apache.ibatis.annotations.ConstructorArgs;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;
import org.springframework.samples.web.command.ShareParkingCommand;
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
	
	List<ShareParking> getShareParkingList();
}
