package payment.version2;

public class Main {
	public static void main(String[] args) {
		PaymentFactory factory = new PaymentFactory();
		PaymentService service = factory.getPaymentService();
		service.servicePay();
	}
}
