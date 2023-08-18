package oop.basic;

public class TestMovie { 
	public static void main(String[] args) { 
		Movie myMovie = new Movie("겨울왕국2", "애니메이션");
		myMovie.play();
		System.out.println("--------------------");

		Movie yourMovie = new Movie("아바타","SF");
		yourMovie.play();
	}

}