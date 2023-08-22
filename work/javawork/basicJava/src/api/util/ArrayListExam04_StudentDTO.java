package api.util;

import java.util.ArrayList;
import java.util.Iterator;

//ArrayListExam03 -> BoardExam처럼 변환
//Student class 만들어서 작업
public class ArrayListExam04_StudentDTO {
	public static void main(String[] args) {

		Student obj1 = new Student("1", "장동건", "100", "99", "88");
		Student obj2 = new Student("2", "이민호", "89", "100", "100");
		Student obj3 = new Student("3", "김범룡", "95", "89", "100");
		
		ArrayList<Student> arrTest = new ArrayList<>();
		arrTest.add(obj1);
		arrTest.add(obj2);
		arrTest.add(obj3);
		
		display(arrTest);
	}
	public static void display(ArrayList<Student> arr) {
		System.out.println("번호\t성명\t국어\t수학\t영어");
		for ( Student student : arr) {
			System.out.println(student);
		}
	}
}
class Student {
	String num = "";
	String name = "";
	String score1 = "";
	String score2 = "";
	String score3 = "";
	public Student(String num, String name, String score1, String score2, String score3) {
		super();
		this.num = num;
		this.name = name;
		this.score1 = score1;
		this.score2 = score2;
		this.score3 = score3;
	}
	@Override
	public String toString() {
		return num + "\t" + name + "\t" +  score1 + "\t" + score2 + "\t" + score3 ;
	}
}
