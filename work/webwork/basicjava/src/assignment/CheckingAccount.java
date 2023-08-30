package assignment;

class Account1 {

	private String addId;
	private long balance;
	private String ownerName;

	public Account1() {
	}

	public Account1(String addId, long balance, String ownerName) {
		super();
		this.addId = addId;
		this.balance = balance;
		this.ownerName = ownerName;
	}
	
	public String getAddId() {
		return addId;
	}

	public void setAddId(String addId) {
		this.addId = addId;
	}

	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public void diposit(long amount) {
		balance += amount;
	}
	
	public void withdraw(long amount) {
		balance -= amount;
	}
	
	

	
}

public class CheckingAccount extends Account1{
	private String cardNo;

	public CheckingAccount() {
	}

	public CheckingAccount(String accId, String ownerName, long balance, String cardNo) {
		super(accId,balance,ownerName);
		this.cardNo = cardNo;
	}
	
	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public void pay(long amount, String cardNo) {
		if (cardNo.equals(getCardNo()) && getBalance() >= amount) {
			long Result = getBalance() - amount;
			setBalance(Result);
		} else {
			System.out.println("지불이 불가능합니다.");
		}
		
	}

	

}
