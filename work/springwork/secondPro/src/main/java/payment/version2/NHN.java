package payment.version2;

public class NHN implements PGObj {

	@Override
	public void pay() {
		// TODO Auto-generated method stub
		System.out.println("NHN을 이용해서 지불하기");
	}

	@Override
	public void cancel() {
		// TODO Auto-generated method stub
		System.out.println("NHN을 이용해서 지불 취소하기");
	}
	

}
