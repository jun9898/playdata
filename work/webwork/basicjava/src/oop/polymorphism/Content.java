package oop.polymorphism;

public abstract class Content {

	private String title;
	private int price;

	public Content(String title) {
		super();
		this.title = title;
	}
	
//	추상 메소드
	public abstract void totalPrice();

	public void show() {
		System.out.println(title + " content의 가격은"
				+ price + "");
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
