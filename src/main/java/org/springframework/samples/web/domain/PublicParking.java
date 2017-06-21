package org.springframework.samples.web.domain;

public class PublicParking {
	String code; //주차장 코드
	String status;
   public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
String title; //주차장 이름
   String addr; //주소
   String tel; //전화번호
   String capacity; //주차 가능 차량 수 
   String cur_parking; //현재 주차중인 대수
   String cur_parking_time; //현재 주차 차량 업데이트 시간
   String weekday_begin_time; //평일 운영 시작시각
   String weekday_end_time; //평일 운영 종료시각
   String weekend_begin_time; //주말 운영 시작시각
   String weekend_end_time; //주말 운영 종료시각
   String time_rate; //기본 주차 시간(분 단위)
   String rates; //기본 주차 요금
   String add_time_rate; //추가 단위 시간(분 단위)
   String add_rates; //추가 단위 요금
   String day_maximum; //일 최대 요금
   String fulltime_monthly; //월 정기권 금액
   double avg_rate; //별점
   
   public PublicParking() {
		
	}
   
   public double getAvg_rate() {
	return avg_rate;
}
public void setAvg_rate(double avg_rate) {
	this.avg_rate = avg_rate;
}
double percent;
   public double getPercent() {
	return percent;
}
public void setPercent(double percent) {
	this.percent = percent;
}
public String getTitle() {
      return title;
   }
   public void setTitle(String title) {
      this.title = title;
   }
   public String getAddr() {
      return addr;
   }
   public void setAddr(String addr) {
      this.addr = addr;
   }
   public String getTel() {
      return tel;
   }
   public void setTel(String tel) {
      this.tel = tel;
   }
   public String getCapacity() {
      return capacity;
   }
   public void setCapacity(String capacity) {
      this.capacity = capacity;
   }
   public String getCur_parking() {
      return cur_parking;
   }
   public void setCur_parking(String cur_parking) {
      this.cur_parking = cur_parking;
   }
   public String getCur_parking_time() {
      return cur_parking_time;
   }
   public void setCur_parking_time(String cur_parking_time) {
      this.cur_parking_time = cur_parking_time;
   }
   public String getWeekday_begin_time() {
      return weekday_begin_time;
   }
   public void setWeekday_begin_time(String weekday_begin_time) {
      this.weekday_begin_time = weekday_begin_time;
   }
   public String getWeekday_end_time() {
      return weekday_end_time;
   }
   public void setWeekday_end_time(String weekday_end_time) {
      this.weekday_end_time = weekday_end_time;
   }
   public String getWeekend_begin_time() {
      return weekend_begin_time;
   }
   public void setWeekend_begin_time(String weekend_begin_time) {
      this.weekend_begin_time = weekend_begin_time;
   }
   public String getWeekend_end_time() {
      return weekend_end_time;
   }
   public void setWeekend_end_time(String weekend_end_time) {
      this.weekend_end_time = weekend_end_time;
   }
   public String getTime_rate() {
      return time_rate;
   }
   public void setTime_rate(String time_rate) {
      this.time_rate = time_rate;
   }
   public String getRates() {
      return rates;
   }
   public void setRates(String rates) {
      this.rates = rates;
   }
   public String getAdd_time_rate() {
      return add_time_rate;
   }
   public void setAdd_time_rate(String add_time_rate) {
      this.add_time_rate = add_time_rate;
   }
   public String getAdd_rates() {
      return add_rates;
   }
   public void setAdd_rates(String add_rates) {
      this.add_rates = add_rates;
   }
   public String getDay_maximum() {
      return day_maximum;
   }
   public void setDay_maximum(String day_maximum) {
      this.day_maximum = day_maximum;
   }
   public String getFulltime_monthly() {
      return fulltime_monthly;
   }
   public void setFulltime_monthly(String fulltime_monthly) {
      this.fulltime_monthly = fulltime_monthly;
   }
   
   

}