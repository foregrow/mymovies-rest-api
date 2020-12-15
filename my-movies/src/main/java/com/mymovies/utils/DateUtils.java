package com.mymovies.utils;


public class DateUtils {
	
	/*private static final int MAX_MINUTES = 60;
	private static final int MIN_MINUTES = 1;
	
	private static final int ADDED_HOURS = 3;
	
	public static Map<String, String> getDatesFromAndTo() {
		Map<String, String> dates = new HashMap<String, String>();
		LocalDateTime ldt = LocalDateTime.now();
		//fromTime=2020-12-04T00:00:00Z&toTime=2020-12-04T23:59:59Z&communityId=1&languageId=404&cid=
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		String fromTime="";
		String toTime="";
		try {
			fromTime = dateFormat.format(dateFormat.parse(ldt.toString()));
			ldt = ldt.plusHours(ADDED_HOURS);
			toTime = dateFormat.format(dateFormat.parse(ldt.toString()));
			
			dates.put("fromTime", fromTime);
			dates.put("toTime", toTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dates;
	}
	
	
	public static boolean isMovieInCloseFuture(String movieDateTime) {
			boolean result = false;
			Calendar calendar = Calendar.getInstance();
			
			long millisNow = calendar.getTimeInMillis();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
			
			int timeDifferenceInMinutes = 0;
			try{
			   Date date = dateFormat.parse(movieDateTime);
			   calendar = Calendar.getInstance();
			   calendar.setTime(date);
			   long millisMovie = calendar.getTimeInMillis();

			   timeDifferenceInMinutes = (int) ((millisMovie - millisNow) / 60000);
			   if(timeDifferenceInMinutes > MIN_MINUTES && timeDifferenceInMinutes <= MAX_MINUTES) {
				   result = true;
				   return result; 
			   }
			}catch(ParseException e){
			   e.printStackTrace();
			 } 	
			return result;
		}*/

}
