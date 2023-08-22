import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StudentManagerTest {

	public static void main(String[] args) {
		// 학생 데이터 초기화
		StudentManager studentManager = new StudentManager();
		initializeStudentList(studentManager);
		initializeStudentGrade(studentManager);
		Student student = null;

		// 학생이름으로 학생 찾기
		System.out.println("getStudent() Test --------------");
		String name = "하대치";
		student = studentManager.getStudent(name);
		if (student != null) {
			System.out.println(student.getName() + ", " + student.getGrade());
		} else {
			System.out.println("Sorry, we have nothing for you");
		} 
		
		// 등급으로 학생 목록 검색하기
		System.out.println("search() Test --------------");
		String grade = "B"; // 'B' 등급으로 조회
		ArrayList studentList = studentManager.search(grade);
		Iterator iter = studentList.iterator();
		while (iter.hasNext()) {
			student = (Student) iter.next();
			System.out.println(student.getName() + ", " + student.getGrade());
		} 
	}

	// 임시 데이터 구성
	private static void initializeStudentList(StudentManager studentManager) {
		studentManager.addStudent(new Student("김범우", 65, 80, 84));
		studentManager.addStudent(new Student("염상진", 84, 69, 94));
		studentManager.addStudent(new Student("염상구", 96, 43, 90));
		studentManager.addStudent(new Student("하대치", 84, 60, 96));
		studentManager.addStudent(new Student("소화",   83, 73, 90));
		studentManager.addStudent(new Student("이지숙", 56, 85, 66));
		studentManager.addStudent(new Student("조한규", 75, 80, 64));
		studentManager.addStudent(new Student("심재모", 89, 75, 95));
		studentManager.addStudent(new Student("강동기", 86, 70, 85));
		studentManager.addStudent(new Student("안창민", 56, 74, 70));
	}

	private static void initializeStudentGrade(StudentManager studentManager) {
		List studentList = studentManager.getStudentList();
		
		Iterator iterator = studentList.iterator();
		while (iterator.hasNext()) {
			Student student = (Student) iterator.next(); 
			student.calcGrade();  //학생들의 점수 등급을 계산한다.
		}
	}
}
