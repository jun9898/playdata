package assignment.date0818;

public class Alcohol extends Drink {
	
	double alcper;

	public Alcohol(String name, int price, int count, double alcper) {
		super(name, price, count);
		this.alcper = alcper;
	}

	public static void printTitle() {
		System.out.println("상품명(도수[%])\t"+"단가\t수량\t금액");
	}
	
	public void printData() {
		System.out.println(name + "(" +  alcper +")"+ "\t" + price + "\t" + count + "\t" + getTotalPrice());
	}

}
