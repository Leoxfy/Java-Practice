package work2;
import java.util.Calendar;
public class CalendarBean {
	int year = 0;
	int month = 0;
	Calendar calendar;
	
	CalendarBean() {
		calendar = Calendar.getInstance();
		year = calendar.get(Calendar.YEAR);
		month = calendar.get(Calendar.MONTH) + 1;
	}
	void setYear(int y) {
		year = y;
	}
	void setMonth(int m) {
		month = m;
	}
	void setTime(int y,int m) {
		year = y;
		month = m;
	}
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
		String [] a = new String[42];
		calendar.set(year, month-1, 1);
		//¼ÆËãÖ¸¶¨ÔÂµÄ1ºÅµÄÐÇÆÚ
		int weekDay = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		//¼ÆËãÖ¸¶¨ÔÂµÄÌìÊý
		int day = getDay();
		//¸ø×Ö·û´®Êý×é¸³Öµ
		for(int i=0;i<weekDay;i++) {
			a[i] = " ";
		}
		int n =1;
		for(int i=weekDay;i<weekDay+day;i++) {
			a[i] = String.valueOf(n);
			n++;
		}
		for(int i=weekDay+day;i<a.length;i++) {
			a[i] = " ";
		}
		return a;
	}
	
	void printCalendar() {
		//´òÓ¡µÚÒ»ÐÐÄêÔÂÐÅÏ¢
		System.out.println(year + "Äê" + month + "ÔÂ");
		//»ñÈ¡ÈÕÀú×Ö·û´®Êý×é
		String [] a = getCalendar();
		//´òÓ¡ÐÇÆÚÐÅÏ¢
		char [] str = "ÈÕÒ»¶þÈýËÄÎåÁù".toCharArray();
		for(char c:str) {
			System.out.printf("%3c", c);
		}
		for(int i=0;i<a.length;i++) {
			if(i%7==0) {
				System.out.println();
			}
			System.out.printf("%4s", a[i]);
		}
		System.out.println();
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
