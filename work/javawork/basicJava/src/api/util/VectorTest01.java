package api.util;

import java.util.Vector;

//Vector 활용
public class VectorTest01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//1.	Vector 생성
		Vector<Integer> v=new Vector<Integer>();//int[] myarr = new int[5];
		System.out.println(v);
		
		//2.	Vector에 data 저장
		v.add(10);//myarr[0] = 10;
//		v.add("java");
		System.out.println(v);
		
		//3.	vector에 저장된 요소의 개수 - 저장된 요소의 개수와 용량을 함께 확인
		//		-> Vector(java의 collection)는 array와 다르게 용량이 자동 증가
		System.out.println("현재 Vector에 저장된 요소의 개수-> "+v.size());//myarr.length()
		System.out.println("현재 Vector의 용량-> "+v.capacity());
		for (int i = 1; i<=10;i++) {
			v.add(i);//Vector에 1부터 10까지 저장
		}
/*		System.out.println("현재 Vector에 저장된 요소의 개수-> "+v.size());//myarr.length()
		System.out.println("현재 Vector의 용량-> "+v.capacity());
		for (int i = 1; i<=10;i++) {
			v.add(i);//Vector에 1부터 10까지 저장
		}
		System.out.println("현재 Vector에 저장된 요소의 개수-> "+v.size());//myarr.length()
		System.out.println("현재 Vector의 용량-> "+v.capacity());
		for (int i = 1; i<=20;i++) {
			v.add(i);//Vector에 1부터 10까지 저장
		}
		System.out.println("현재 Vector에 저장된 요소의 개수-> "+v.size());//myarr.length()
		System.out.println("현재 Vector의 용량-> "+v.capacity());
		for (int i = 1; i<=40;i++) {
			v.add(i);//Vector에 1부터 10까지 저장
		}
		System.out.println("현재 Vector에 저장된 요소의 개수-> "+v.size());//myarr.length()
		System.out.println("현재 Vector의 용량-> "+v.capacity());
*/
		
		//4.	Vector에 저장된 요소 꺼내기
		//		index를 활용
		System.out.println("1번 요소에 저장된 값-> "+v.get(1));//sysout(myarr[1]);
		
		//5.	Vector에 저장된 모든 요소 꺼내기
		int size=v.size();//호출을 줄이기 위한 성능 향상
		for(int i=0;i<size;i++) {
			int data=v.get(i);
			System.out.println(i+"번째 요소-> "+data);
		}
		v.set(10,100);
		System.out.println("-------------------------------");
		for(int data2:v) {
			System.out.println(data2);
		}
    }
}