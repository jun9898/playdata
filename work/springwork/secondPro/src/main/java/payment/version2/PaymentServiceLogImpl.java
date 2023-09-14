package payment.version2;

public class PaymentServiceLogImpl implements PaymentService{

	PGObj pgobj;
	
	public PaymentServiceLogImpl(PGObj obj) {
		// TODO Auto-generated constructor stub
		this.pgobj = obj;
	}
	
	public PaymentServiceLogImpl() {
		
	}

	@Override
	public void servicePay() {
		System.out.println("================");
		// TODO Auto-generated method stub
		pgobj.pay();
		System.out.println("================");
		
	}

	@Override
	public void serviceCancel() {
		System.out.println("================");
		// TODO Auto-generated method stub
		pgobj.cancel();
		System.out.println("================");
	}






	

}
