package payment.version1;

public class Main {
	public static void main(String[] args) {
		// 서비스단의 메소드를 호출
		PGObj obj = new Toss();
		PaymentService pay = new PaymentServiceImpl(obj);
		pay.servicePay();
		pay.serviceCancel();
	}
}
