package api.util;

import java.util.ArrayList;

//배열을 ArrayList로 변환해서 return하는 method
//method name: changeArrayList
//variable: String[]
//return type: ArrayList<String>
public class ArrayListExam02 {

	public static void main(String[] args) {
		//2. 1.에서 구현한 changeArrayList method call
		//3. 호출 후 리턴된 ArrayList 결과 출력
		String[] a={"java","servlet", "jsp","spring"};
	 	ArrayList<String> t= changeArrayList(a);
		System.out.println(t);
		
	}
	//1. define changeArrayList method
	public static ArrayList<String> changeArrayList(String[] strArr){
		ArrayList<String> tempArrayList=new ArrayList<String>();
				for (String data:strArr)
				{
					tempArrayList.add(data);
				}
				return tempArrayList;
	}
}
