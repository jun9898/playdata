package payment.version2;

public class PaymentServiceImpl implements PaymentService{

	PGObj pgobj;
	
	public PaymentServiceImpl(PGObj obj) {
		// TODO Auto-generated constructor stub
		this.pgobj = obj;
	}
	
	public PaymentServiceImpl() {
		
	}

	@Override
	public void servicePay() {
		// TODO Auto-generated method stub
		pgobj.pay();
		
	}

	@Override
	public void serviceCancel() {
		// TODO Auto-generated method stub
		pgobj.cancel();
	}
}
