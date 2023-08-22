package api.util;

import java.util.HashSet;
import java.util.Iterator;

// 합집합과 교집합

public class HashSetTest02 {

	public static void main(String[] args) {
		
		HashSet<String> set1 = new HashSet<>();
		set1.add("java");
		set1.add("oracle");
		set1.add("servlet");
		set1.add("jdbc");
		set1.add("jsp");
		set1.add("spring");
		print(set1);
		// 합집합 - set을 생성할때 매개변수로 또다른 Set을 넘기기
		HashSet<String> set2 = new HashSet<>(set1);
		set2.add("hadoop");
		set2.add("spark");
		set2.add("flume");
		print(set2);
		
		HashSet<String> set3 = new HashSet<>();
		set3.add("java");
		set3.add("servlet");
		set3.add("python");
		set3.add("python");
		print(set3);
		System.out.println("set1과 set3의 교집합 - set3에 교집합이 새로 할당");
//		set3.retainAll(set1); - 교집합을 표현하기 위한 메소드
		print(set3);
		System.out.println("set2와 set3의 합집합");
		set2.addAll(set3); // - 합집합이 된다.
		print(set2);

	}

	
	public static void print(HashSet<String> set) {
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			String data = it.next();
			System.out.println(data);
		}
		System.out.println("=====================");
	}
}
