package api.util;

import java.util.ArrayList;

/*
 * 번호	성 명		국어	수학	영어
 * 1	장동건	100	99	88
 * 2	이민호	89	100	100
 * 3	김범룡	95	89	100
 * 	->	제목은 sysout출력
 * 	->	내용만 ArrayList
 */


public class ArrayListExam03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<String>> datasList = new ArrayList<ArrayList<String>>();
		
		ArrayList<String> datas1= new ArrayList<>();
		datas1.add("1");
		datas1.add("장동건");
		datas1.add("100");
		datas1.add("99");
		datas1.add("88");
		ArrayList<String> datas2= new ArrayList<>();
		datas2.add("2");
		datas2.add("이민호");
		datas2.add("89");
		datas2.add("100");
		datas2.add("100");
		ArrayList<String> datas3= new ArrayList<>();
		datas3.add("3");
		datas3.add("김범룡");
		datas3.add("95");
		datas3.add("89");
		datas3.add("100");
//		String[] d1={"1", "장동건", "100", "99", "88"};
//		String[] d2= {"2", "이민호", "89", "100", "100"};
//		String[] d3= {"3", "김범룡", "95", "89", "100"};
//		datasList.add(changeArrayList(d1));
//		datasList.add(changeArrayList(d2));
//		datasList.add(changeArrayList(d3));
		datasList.add(datas1);
		datasList.add(datas2);
		datasList.add(datas3);
		display(datasList);
	}
	//배열 값 출력
	public static void display(ArrayList<ArrayList<String>> datasList) {
		//for문 중첩 사용
		System.out.println("번호\t성명\t국어\t수학\t영어");
		for(ArrayList<String> datas:datasList) {
			for(String data: datas) {
				System.out.print(data+"\t");
			}
			System.out.println();
		}
	}
	public static ArrayList<String> changeArrayList(String[] strArr){
		ArrayList<String> tempArrayList=new ArrayList<String>();
				for (String data:strArr)
				{
					tempArrayList.add(data);
				}
				return tempArrayList;
	}
}
