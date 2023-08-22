package api.util;

import java.util.ArrayList;
import java.util.List;

//ArrayList의 기타 method
public class ArrayListTest02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list=new ArrayList<String>();
		list.add("java");
		list.add("oracle");
		list.add("hmtl");
		list.add("css");
		list.add("javascript");
		display(list);
		
		list.set(4, "javascript & jQuery");
		list.add("jsp & servlet");
		display(list);
		
		list.add(2, "JDBC");
		display(list);
		
		//List의 요소 지우기
		list.remove(2);
		list.remove("jsp & servlet");
		display(list);
		System.out.println(list.contains("JDBC"));
		System.out.println(list.contains("css"));
		System.out.println(list.isEmpty());
		
		
		ArrayList<String> list2 = new ArrayList<String>();
		list2.add("스프링");
		list2.add("Mybatis");
		list2.add("JPA");
		list.addAll(list2);
		display(list2);
		display(list);
	}
	//ArrayList의 요소를 출력하는 method
	public static void display(List<String> list) {
		System.out.println("---------------------------------");
		for(String data: list) {
			System.out.println(data);
		}
	}

}
