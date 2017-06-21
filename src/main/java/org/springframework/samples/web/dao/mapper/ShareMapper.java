package org.springframework.samples.web.dao.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Arg;
import org.apache.ibatis.annotations.ConstructorArgs;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;
import org.springframework.samples.web.command.ApplyCommand;
import org.springframework.samples.web.command.ShareParkingCommand;
import org.springframework.samples.web.domain.Apply;
import org.springframework.samples.web.domain.ShareParking;
import org.springframework.samples.web.domain.Time;

public interface ShareMapper {

	@Insert("INSERT INTO SHARE_PARKING (SHARE_PARKING_CODE, WRITER_ID, PARKING_NAME, ADDRESS, GU, ALTITUDE, LONGITUDE, PHONE, CAR_TYPE, COST, BLACKLIST, TITLE, CONTENT) VALUES"
			+ "( SHARE_SEQ.NEXTVAL, #{writerId}, #{parkingName}, #{address}, #{gu}, #{altitude}, #{longitude}, #{phone}, #{carType}, #{cost}, #{blackList}, #{title}, #{content} )")
	void insertShareParking(ShareParking shareParking);
	
	@Select("SELECT SHARE_SEQ.CURRVAL FROM DUAL")
	String getShareParkingCode();
	
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
			+" (APPLY_SEQ.NEXTVAL , #{shareParkingCode}, #{approval}, #{applierCode}, #{writerCode})")
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
	
	@Select("SELECT APPLY_CODE, APPROVAL, SHARE_PARKING_CODE, APPLIER_CODE, WRITER_CODE FROM APPLY_HISTORY WHERE SHARE_PARKING_CODE = #{param1} and APPLIER_CODE = #{param2} ")
	@ConstructorArgs({
	@Arg(column = "APPLY_CODE",javaType=String.class, jdbcType = JdbcType.NVARCHAR),
	@Arg(column = "SHARE_PARKING_CODE",javaType=String.class, jdbcType = JdbcType.NVARCHAR),
	@Arg(column = "APPROVAL",javaType=int.class, jdbcType = JdbcType.NUMERIC),
	@Arg(column = "APPLIER_CODE", javaType=String.class, jdbcType = JdbcType.NVARCHAR),
	@Arg(column = "WRITER_CODE", javaType=String.class, jdbcType = JdbcType.NVARCHAR)
	})
	Apply getApply(String shareParkingCode, String applierCode);
	
	@Update("update apply_history set approval = 1 where apply_code= #{applyCode}")
	void updateApply(String applyCode);
	
	@Insert("INSERT INTO TIME (TIME_CODE, START_DATE, START_HOUR, START_MINUTE, END_HOUR, END_MINUTE, APPLY_CODE, END_DATE) VALUES"
			+ " (TIME_SEQ.NEXTVAL, #{startDate}, #{startHour}, #{startMinute}, #{endHour}, #{endMinute}, #{applyCode}, #{endDate})")
	void insertShareTime(Time time);
	
	@Select("SELECT a.apply_code, a.share_parking_code, a.approval, a.applier_code, a.writer_code, t.time_code, t.start_date, t.start_hour, t.start_minute, t.end_hour, t.end_minute, t.end_date "
			+ "FROM APPLY_HISTORY a, TIME t WHERE a.APPLY_CODE = t.APPLY_CODE AND a.share_parking_code = #{shareParkingCode}")
	@Results({
		@Result(column = "apply_code", property = "applyCode"),
		@Result(column = "share_parking_code", property = "shareParkingCode"),
		@Result(column = "applier_code", property = "applierCode"),
		@Result(column = "writer_code", property = "writerCode"),
		@Result(column = "time_code", property = "time.timeCode"),
		@Result(column = "start_date", property = "time.startDate"),
		@Result(column = "start_hour", property = "time.startHour"),
		@Result(column = "start_minute", property = "time.startMinute"),
		@Result(column = "end_hour", property = "time.endHour"),
		@Result(column = "end_minute", property = "time.endMinute"),
		@Result(column = "end_date", property = "time.endDate")
	})
	List<ApplyCommand> getApplyCommandList(String shareParkingCode);
	
	@Select("select count(*) from evaluate_history where ID= #{id}")
	int isEvaluate(String id);
	
	@Insert("Insert into EVALUATE_HISTORY values (0,0,0,#{id},0)")
	void insertEvaluate(String id);
	
	@Select("select count(*) from apply_history where SHARE_PARKING_CODE = #{param1} and APPLIER_CODE = #{param2}")
	int isAccepted(String code, String id);
	
	
	
	@Select("SELECT share_parking_code shareParkingCode, writer_id writerId, "
			+ "parking_name parkingName, address, gu, altitude, longitude, "
			+ "phone, car_type carType, cost, blacklist, title, content, image "
			+ "FROM SHARE_PARKING "
			+ "WHERE writer_id = #{writer_id}")
	List<ShareParking> getShareParkingListByWriter(String writer_id);
	
	
	@Select("select count(*) from apply_history where SHARE_PARKING_CODE = #{param1} and APPLIER_CODE = #{param2} and approval = 0")
	int isApplied(String code, String id);
	
	//이미지 저장
	void saveImage(Map<String, Object> hmap);
//	void saveImage(Map<String, Object> img, String shareParkingCode);
}
