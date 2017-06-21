package org.springframework.samples.web.service;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.springframework.samples.web.domain.PublicParking;
import org.springframework.stereotype.Service;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

@Service
public class ParkingParserImpl  implements XmlParser{
	   public final static String PUBLIC_PARKING_KEY = "696343594872747939347852774461";
	   public final static String PUBLIC_PARKING_URL = "http://openapi.seoul.go.kr:8088/"+ PUBLIC_PARKING_KEY +"/xml/GetParkInfo/1/907/";
	   
	   //@Autowired
	   private  ArrayList<PublicParking> list = null;
	   @Override
	   public ArrayList<PublicParking> apiParserSearch() {
	      URL url;
	      ArrayList<PublicParking> list = null;
	      try {
	         url = new URL(getURLParam(null));
	         XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
	           XmlPullParser parser = factory.newPullParser();
	           factory.setNamespaceAware(true);
	           
	           BufferedInputStream bis = new BufferedInputStream(url.openStream());
	           parser.setInput(bis, "utf-8");
	           
	           
	           String tag = null;
	           int event_type = parser.getEventType();
	           PublicParking parking = null;
	           
	           while (event_type != XmlPullParser.END_DOCUMENT) {
	               switch(event_type) {
	               case XmlPullParser.END_DOCUMENT: //문서의 끝
	                  break;
	               case XmlPullParser.START_DOCUMENT:
	                  list = new ArrayList<PublicParking>();
	          
	                  break;
	               case XmlPullParser.END_TAG:
	                  tag = parser.getName();
	                  if(tag.equals("row"))
	                  {
	                     list.add(parking);
	                     parking = null;
	                  }
	                  break;
	               case XmlPullParser.START_TAG:
	                  tag = parser.getName();
	                  switch(tag) {
	                  case "row":
	                     parking = new PublicParking();
	                     break;
	                  case "ADDR":
	                	  if(parking != null)
		                        parking.setAddr(parser.nextText());
		                     break;
	                  case "CAPACITY":
	                     if(parking != null)
	                        parking.setCapacity(parser.nextText());
	                     break;
	                  case "PARKING_CODE":
		            		if(parking != null)
		            			parking.setCode(parser.nextText());
		            		break;
		            	case "PARKING_NAME":
		            		if(parking != null)
		            			parking.setTitle(parser.nextText());
		            		break;
		            	case "TEL":
		            		if(parking != null)
		            			parking.setTel(parser.nextText());
		            		break;
	                  case "CUR_PARKING":
		                     if(parking != null)
		                        parking.setCur_parking(parser.nextText());
		                     break;
	                  case "CUR_PARKING_TIME":
		            		if(parking != null)
		            			parking.setCur_parking_time(parser.nextText());
		            		break;
		            	case "WEEKDAY_BEGIN_TIME":
		            		if(parking != null)
		            			parking.setWeekday_begin_time(parser.nextText());
		            		break;
		            	case "WEEKDAY_END_TIME":
		            		if(parking != null)
		            			parking.setWeekday_end_time(parser.nextText());
		            		break;
		            	case "WEEKEND_BEGIN_TIME":
		            		if(parking != null)
		            			parking.setWeekend_begin_time(parser.nextText());
		            		break;
		            	case "WEEKEND_END_TIME":
		            		if(parking != null)
		            			parking.setWeekend_end_time(parser.nextText());
		            		break;
		            	case "TIME_RATE":
		            		if(parking != null)
		            			parking.setTime_rate(parser.nextText());
		            		break;
		            	case "RATES":
		            		if(parking != null)
		            			parking.setRates(parser.nextText());
		            		break;
		            	case "ADD_TIME_RATE":
		            		if(parking != null)
		            			parking.setAdd_time_rate(parser.nextText());
		            		break;
		            	case "ADD_RATES":
		            		if(parking != null)
		            			parking.setAdd_rates(parser.nextText());
		            		break;
		            	case "DAY_MAXIMUM":
		            		if(parking != null)
		            			parking.setDay_maximum(parser.nextText());
		            		break;
		            	case "FULLTIME_MONTHLY":
		            		if(parking != null)
		            			parking.setFulltime_monthly(parser.nextText());
		            		break;
		            	case "QUE_STATUS":
		            		if(parking != null)
		            			parking.setStatus(parser.nextText());
		            		break;
	                  }
	               }

	               event_type = parser.next();
	           }
	           for(PublicParking a : list)
               {
		        Double aa = Double.valueOf(a.getCapacity()).doubleValue()/ (Double.valueOf(a.getCapacity()).doubleValue()+ Double.valueOf(a.getCur_parking()).doubleValue())*10;
		        a.setPercent(aa);
               }
	      } catch (MalformedURLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      } catch (UnsupportedEncodingException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } catch (XmlPullParserException e) {
	            // TODO Auto-generated catch block
	           e.printStackTrace();
	        }
	        return list;
	   }
	  
	    
	   @Override
	   public ArrayList<PublicParking> apiParserSearch2(String location) {
		   URL url;
		      ArrayList<PublicParking> list2 = null;
		      try {
		         url = new URL(getURLParam(location));
		         XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
		           XmlPullParser parser = factory.newPullParser();
		           factory.setNamespaceAware(true);
		           
		           BufferedInputStream bis = new BufferedInputStream(url.openStream());
		           parser.setInput(bis, "utf-8");
		           
		           
		           String tag = null;
		           int event_type = parser.getEventType();
		           PublicParking parking = null;
		           
		           while (event_type != XmlPullParser.END_DOCUMENT) {
		               switch(event_type) {
		               case XmlPullParser.END_DOCUMENT: //문서의 끝
		                  break;
		               case XmlPullParser.START_DOCUMENT:
		                  list2 = new ArrayList<PublicParking>();
		          
		                  break;
		               case XmlPullParser.END_TAG:
		                  tag = parser.getName();
		                  if(tag.equals("row"))
		                  {
		                     list2.add(parking);
		                     parking = null;
		                  }
		                  break;
		               case XmlPullParser.START_TAG:
		                  tag = parser.getName();
		                  switch(tag) {
		                  case "row":
		                     parking = new PublicParking();
		                     break;
		                  case "ADDR":
		                	  if(parking != null)
			                        parking.setAddr(parser.nextText());
			                     break;
		                  case "CAPACITY":
		                     if(parking != null)
		                        parking.setCapacity(parser.nextText());
		                     break;
		                  case "PARKING_CODE":
			            		if(parking != null)
			            			
			            			parking.setCode(parser.nextText());
			            		break;
			            	case "PARKING_NAME":
			            		if(parking != null){
			            			parking.setTitle(parser.nextText());
			            		}
			            		break;
			            	case "TEL":
			            		if(parking != null)
			            			parking.setTel(parser.nextText());
			            		break;
		                  case "CUR_PARKING":
			                     if(parking != null)
			                        parking.setCur_parking(parser.nextText());
			                     break;
		                  case "CUR_PARKING_TIME":
			            		if(parking != null)
			            			parking.setCur_parking_time(parser.nextText());
			            		break;
			            	case "WEEKDAY_BEGIN_TIME":
			            		if(parking != null)
			            			parking.setWeekday_begin_time(parser.nextText());
			            		break;
			            	case "WEEKDAY_END_TIME":
			            		if(parking != null)
			            			parking.setWeekday_end_time(parser.nextText());
			            		break;
			            	case "WEEKEND_BEGIN_TIME":
			            		if(parking != null)
			            			parking.setWeekend_begin_time(parser.nextText());
			            		break;
			            	case "WEEKEND_END_TIME":
			            		if(parking != null)
			            			parking.setWeekend_end_time(parser.nextText());
			            		break;
			            	case "TIME_RATE":
			            		if(parking != null)
			            			parking.setTime_rate(parser.nextText());
			            		break;
			            	case "RATES":
			            		if(parking != null)
			            			parking.setRates(parser.nextText());
			            		break;
			            	case "ADD_TIME_RATE":
			            		if(parking != null)
			            			parking.setAdd_time_rate(parser.nextText());
			            		break;
			            	case "ADD_RATES":
			            		if(parking != null)
			            			parking.setAdd_rates(parser.nextText());
			            		break;
			            	case "DAY_MAXIMUM":
			            		if(parking != null)
			            			parking.setDay_maximum(parser.nextText());
			            		break;
			            	case "FULLTIME_MONTHLY":
			            		if(parking != null)
			            			parking.setFulltime_monthly(parser.nextText());
			            		break;
			            	case "QUE_STATUS":
			            		if(parking != null)
			            			parking.setStatus(parser.nextText());
			            		break;
		                  }
		               }

		               event_type = parser.next();
		           }
		           for(PublicParking a : list2)
	               {
			        Double aa = Double.valueOf(a.getCapacity()).doubleValue()/ (Double.valueOf(a.getCapacity()).doubleValue()+ Double.valueOf(a.getCur_parking()).doubleValue())*10;
			        a.setPercent(aa);
	               }
		      } catch (MalformedURLException e) {
		         // TODO Auto-generated catch block
		         e.printStackTrace();
		      } catch (UnsupportedEncodingException e) {
		            // TODO Auto-generated catch block
		            e.printStackTrace();
		        } catch (IOException e) {
		            // TODO Auto-generated catch block
		            e.printStackTrace();
		        } catch (XmlPullParserException e) {
		            // TODO Auto-generated catch block
		           e.printStackTrace();
		        }
		        return list2;
	}


	@Override
	    public String getURLParam(String search){
	        String url;
	        if(search == null){
	        	url = PUBLIC_PARKING_URL;
	        }else{
	        	url = PUBLIC_PARKING_URL+search;
	        }
	        	
	        return url;
	    }
	 

}
