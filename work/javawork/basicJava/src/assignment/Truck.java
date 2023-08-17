package assignment;

public class Truck extends Wheeler{

	public Truck(String carName, int velocity, int WheelNumber) {
		super(velocity, carName, WheelNumber);
	}

	public void speedUp(int speed) {
		setVelocity(getVelocity() + (speed * 5));
		if (getVelocity() > 100) {
			System.out.println(carName + "의 최고속도 위반으로 속도를 100으로 낮춥니다.");
			setVelocity(100);
		} else {
			System.out.println(carName + "의 현재 속도는 " + getVelocity() + " 입니다.");
		}
	}

	public void speedDown(int speed) {
		setVelocity(getVelocity() - (speed * 5));
		if (getVelocity() < 50) {
			System.out.println(carName + "의 최저속도 위반으로 속도를 50으로 올립니다.");
			setVelocity(50);
		} else {
			System.out.println(carName + "의 현재 속도는 " + getVelocity() + " 입니다.");
		}
	}

}
