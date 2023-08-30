package assignment;

public class Account {
	
	private String accNo;
	private int balance;
	
	public void setAccNo(String accNo) {
		this.accNo = accNo;
        System.out.println(getAccNo() + " 계좌가 개설되었습니다.");
	}

	public String getAccNo() {
		return accNo;
	}

	public int getBalance() {
		return balance;
	}
	
	public void save(int money) {
		balance += money;
        System.out.println(getAccNo() + " 계좌에 " + money + "만원이 입급되었습니다.");
	}

	public void deposit(int money) {
		balance -= money;
        System.out.println(getAccNo() + " 계좌에 " + money + "만원이 출금되었습니다.");
	}
	
	
	// 생성자
	
	//

}
