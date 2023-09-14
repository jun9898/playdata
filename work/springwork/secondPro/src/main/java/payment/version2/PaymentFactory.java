package payment.version2;

public class PaymentFactory {
	
	public PGObj getPGObj() {
		return new Toss();
	}
	
	public PaymentService getPaymentService() {
		PaymentService service = new PaymentServiceLogImpl(getPGObj());
		return service;
	}
	
	
}
