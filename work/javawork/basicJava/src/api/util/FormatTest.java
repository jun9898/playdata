package api.util;

import java.text.DecimalFormat;
import java.text.ParseException;
//날짜와 숫자의 출력 format 변경할 수 있도록 제공되는 class
//지정한 pattern에 맞게 출력
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FormatTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
		Calendar cal = Calendar.getInstance();
		String data=sdf.format(cal.getTime());
		System.out.println("format을 적용한 날짜데이터-> "+data);
		
		DecimalFormat df=new DecimalFormat("#,###");
		System.out.println(df.format(123456789));
		
		DecimalFormat df2=new DecimalFormat("#,###.##");
		System.out.println(df2.format(123456789.8219));
		
		String decimaldta="123456.785";
			try {
//				double data2 = df2.parse(decimaldta);//이럴 때 해줄 수 있는 조치: casting
				double data2 = (double)df2.parse(decimaldta);//상위 타입을 return하기에 하위 타입으로 작성해도 된다.
															
				System.out.println(df2.format(df2.parse(decimaldta)));//auto unboxing까지 담겨있는 내용
			}catch(ParseException e){
				
			}
		
	}

}
