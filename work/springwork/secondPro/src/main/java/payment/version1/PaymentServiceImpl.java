package payment.version1;

public class PaymentServiceImpl implements PaymentService{
	// 내부에서 사용하는 클래스를 직접 코드로 정의
	// OCP 원칙이 지켜지지 못함
	// 클래스 내부에서 사용하는 다른 라이브러리의 클래스를 의존 모듈이라고 한다.
//	PGObj pgobj = new NHN();
	PGObj pgobj;
	
	public PaymentServiceImpl(PGObj obj) {
		// TODO Auto-generated constructor stub
		this.pgobj = obj;
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
