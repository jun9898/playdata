package oop.polymorphism;

public class Video extends Content {

	private String genre;
	
	public Video(String title, String genre) {
		super(title);
		this.genre = genre;
	}
	
	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public void totalPrice() {
		if (genre.equals("new")) {
			setPrice(2000);
		} else if (genre.equals("comic")) {
			setPrice(1500);
		} else if (genre.equals("child")) {
			setPrice(1000);
		}

	}

}
