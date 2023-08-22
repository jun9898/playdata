package api.util;

// 1. 100,98,88,77,100을 HashSet에 저장하기

import java.util.HashSet;
import java.util.Iterator;

public class HashSetExam {

	public static void main(String[] args) {
		HashSet<Integer> set1 = new HashSet<>();
		set1.add(100);
		set1.add(98);
		set1.add(88);
		set1.add(77);
		set1.add(100);
		int[] cha = changeArr(set1);
		for (int i : cha) {
			System.out.println(i);
		}

		print(set1);
	}
//	2. HashSet -> 배열로 변환해서 리턴하기
	public static int[] changeArr(HashSet<Integer> set) {
		int[] result = new int[set.size()];
		int count = 0;
		for (int i : set) {
			result[count] = i;
			count += 1;
		}
		return result;
	}

//	3. HashSet 에 저장된 데이터를 출력하기
	public static void print(HashSet<Integer> set) {
		Iterator<Integer> it = set.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}

		
	}
	
}
