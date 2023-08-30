package oop.intensification;

public abstract class Payment implements Payable{
	protected String shopName;
	protected String productName;
	protected long productPrice;

	public Payment(String shopName, String productName, long productPrice) {
		super();
		this.shopName = shopName;
		this.productName = productName;
		this.productPrice = productPrice;
	}

	@Override
	public void pay() throws PayException {
		// TODO Auto-generated method stub
	}
}
