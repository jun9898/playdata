package api.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

//Set: 집합(순서 X, 중복 X)
public class HashSetTest01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list=new ArrayList<String>();
		list.add("java");
		list.add("oracle");
		list.add("hmtl");
		list.add("css");
		list.add("javascript");
		list.add("javascript");
		for(String data: list) {
			System.out.println(data);
		}
		System.out.println("-------------------------");
		
		//1. HashSet 생성
		HashSet<String> set = new HashSet<>();
		
		//2. HashSet에 data 추가
		set.add("Java");
		set.add("Servlet");
		set.add("JSP");
		set.add("Spring");
		set.add("Spring");
		
		
		//3. set에 저장된 요소의 개수
		System.out.println(set.size());
		System.out.println(set.contains("Spring"));
		System.out.println("-------------------------");
		for(String data: set) {
			System.out.println(data);
		}

		//순서가 있는 자료구조가 아니므로 표준인터페이스(추출 전용 인터페이스인 Iterator)로 변환하고 처리한다.
		//1.	HashSet을 Iterator로 변환하기
		
		
		
	}

}
