package exam02;

public class LgTV implements TV{
	@Override
	public void powerOn() {
		// TODO Auto-generated method stub
		System.out.println("LgTV---on");
	}

	@Override
	public void powerOff() {
		// TODO Auto-generated method stub
		System.out.println("LgTV---off.");
	}

	@Override
	public void volumeDown() {
		// TODO Auto-generated method stub
		System.out.println("LgTV---down.");
	}

	@Override
	public void volumeUp() {
		// TODO Auto-generated method stub
		System.out.println("LgTV---up.");
	}
}
