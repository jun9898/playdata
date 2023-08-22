package api.lang;
//Wrapper classes는 기본형 data를 참조형으로 변환할 수 있는 class
//-> JDK 5.0 이후: Wrapper class의 autoboxing, unboxing에 대한 개념
public class WrapperTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//5.0 이전
		int i=10;//얘를 참조형으로 바꿔야 한다면
		
		//기본형을 참조형으로 변환
		Integer in=new Integer(i);//Deprecated
		test(in);
		
		//5.0 이후
		int j =10;
		Integer in2=j;
		test(j);//5.0 이후 JDK에서는 compiler가 자동으로 변환해준다.
				//참조형 타입의 변수를 요구사는 method에 기본형을 전달해도
				//자동으로 Integer in = new Integer(j)와 같은 코드를 실행해준다.
				//이를 autoBoxing이라 한다.
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Long    .MAX_VALUE);
		System.out.println(Long.MAX_VALUE);
		
		
	}
	public static void test(Object obj) {
		//5.0 이전
		//Object -> Integer 변환
		Integer in=(Integer)obj;
		//Integer -> int 변환
		int myOldVal=in.intValue();
		System.out.println("ver 5.0 이전: "+myOldVal);
		
		//5.0 이후
		int val=(Integer)obj;//int형 변수에 참조형변수를 전달하는 경우.
							//compiler가 자동으로 객체로 포장된 값을 기본형으로 변환해서 전달.
							//이를 autoUnboxing이라 한다.
		System.out.println("ver 5.0 이후: "+val);
		System.out.println("ver 5.0 이후: "+obj);
	}

}
