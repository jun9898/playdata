package exam02;

public class SamsungTV implements TV{
	public void powerOn() {
		System.out.println("SamsungTV---on.");
	}

	public void powerOff() {
		System.out.println("SamsungTV---off.");
	}

	public void volumeUp() {
		System.out.println("SamsungTV---up.");
	}

	public void volumeDown() {
		System.out.println("SamsungTV---down.");
	}
}
