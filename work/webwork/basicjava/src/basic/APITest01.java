package basic;

import java.util.Random;

//import java.util.*;
//import java.util.Random;

public class APITest01 {
	public static void main(String[] args) {
		// 문자열을 처리하기 위한 기능을 사용하기 위해서 STring 클래스를 JVM이 인식하는 작업공간에 할당
		//												  -----------------
		// 											JVM이 찾아서 사용할 수 있는 미리 약속된 공간(Heap)
		// [사용방법]
		// 클래스명 변수 = new 클래스명()
		// -----	 		---------
		// 할당되는			heap에 할당해서 사용하고 싶은 클래스명
		// 클래스명
		// 클래스명이
		// 데이터타입
		
		String str1 = new String();
		Object ob1 = new Object();
		StringBuffer sBuffer = new StringBuffer();
		Thread t = new Thread();
		// JVM이 기본으로 인식하는 패키지의 위치는 java,lang 패키지와 현재 작업 패키지이므로
		// 기본으로 인식하는 패키지 이외의 패키지는 JVM이 인식할 수 있도록 처리해야 한다. (import)
		// package
		// import
		// class
		Random rand = new Random();

	}

}
