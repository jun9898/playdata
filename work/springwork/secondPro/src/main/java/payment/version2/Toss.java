package payment.version2;

public class Toss implements PGObj {

	@Override
	public void pay() {
		// TODO Auto-generated method stub
		System.out.println("toss을 이용해서 지불하기");
	}

	@Override
	public void cancel() { 
		// TODO Auto-generated method stub
		System.out.println("toss을 이용해서 지불 취소하기");
	}
	

}
