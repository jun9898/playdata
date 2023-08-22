package api.util;

import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

//날짜시간에 관련된 작업
public class CalendarTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar cal=new GregorianCalendar();
		Calendar cal2=Calendar.getInstance();
		System.out.println(cal);
		System.out.println(cal2);
		Date d = new Date();
		System.out.println(d);
		System.out.println("----------------How to use Calendar----------------");
		System.out.print(cal.get(Calendar.YEAR)+"년 ");
		System.out.print((cal.get(Calendar.MONTH)+1)+"월 ");//month는 0부터 index
		System.out.print(cal.get(Calendar.DATE)+"일 ");
		System.out.print(cal.get(Calendar.HOUR)+"시 ");
		System.out.print(cal.get(Calendar.MINUTE)+"분 ");
		System.out.println(cal.get(Calendar.SECOND)+"초");
		cal2.set(2023, 10, 30);
		System.out.println(cal2);
		//설정된 날짜시간객체의 값을 millisecond로 변환
		System.out.println(cal.getTimeInMillis());
		
		//Dday - 오늘부터 10월 30일까지의 Dday 계산
		Calendar dDay=new GregorianCalendar();
		Calendar today=new GregorianCalendar();
		dDay.set(2023, 10-1, 30);
		long dDayD=dDay.getTimeInMillis()-today.getTimeInMillis();
		System.out.println("D-day: "+(dDayD/1000/24/60/60));
	}

}
