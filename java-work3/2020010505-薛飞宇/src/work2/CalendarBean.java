package work2;
import java.util.Calendar;


public class CalendarBean {
	int year;
	int month;
	Calendar calendar;
	
	public CalendarBean() {
		calendar = Calendar.getInstance();
		year = calendar.get(Calendar.YEAR);
		month = calendar.get(Calendar.MONTH) + 1;
	};
	boolean isLeapYear() {
		return (((year%4==0) && (year%100!=0)) || (year%400==0)) ? true : false;
	}
	int getDay() {
		int day = 0;
		if(month==1||month==3||month==5||month==7||month==8||month==10||month==12) {
			day = 31;
		}else if(month==4||month==6||month==9||month==11){
			day = 30;
		}else {
			if(isLeapYear()) {
				day = 29;
			}else {
				day = 28;
			}
		}
		return day;
	}
	String [] getCalendar() {
		//6rows 7colums
		String [] content = new String[42];
		calendar.set(year, month-1, 1);
		int weekDay = calendar.get(Calendar.DAY_OF_WEEK)%7;
		int day = getDay();
		for(int i=0;i<weekDay;i++) {
			content[i] = " ";
		}
		int n = 1;
		for(int i=weekDay;i<weekDay+day;i++) {
			content[i] = String.valueOf(n);
			n++;
		}
		for(int i=weekDay+day;i<content.length;i++) {
			content[i] = " ";
		}
		return content;
	}
	void previousMonth() {
		if(month==1) {
			calendar.roll(Calendar.YEAR , false);
		}
		calendar.roll(Calendar.MONTH , false);
		year = calendar.get(Calendar.YEAR);
		month = calendar.get(Calendar.MONTH) + 1;
	}
	
	void nextMonth() {
		if(month==12) {
			calendar.roll(Calendar.YEAR, true);
		}
		calendar.roll(Calendar.MONTH , true);
		year = calendar.get(Calendar.YEAR);
		month = calendar.get(Calendar.MONTH) + 1;
	}
}
