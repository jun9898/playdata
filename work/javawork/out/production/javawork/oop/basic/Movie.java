package oop.basic;

public class Movie {

	private String title;
	private String genre;

	// 기본생성자와 매개변수 2개 생성자 정의하고 생성자를 이용하는 코드로 수정해서 제출
	public Movie() {
	}
	
	public Movie(String title, String genre) {
		this.title = title;
		this.genre = genre;
		
	}
	
	public void play() {
		System.out.println(title + "(" + genre + ")" + " "
				+ "상영중입니다.");
	}
}
