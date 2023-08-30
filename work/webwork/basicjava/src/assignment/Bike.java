package assignment;

public class Bike extends Wheeler{

	public Bike(String carName, int velocity, int WheelNumber) {
		super(velocity, carName, WheelNumber);
	}

	public void speedUp(int speed) {
		setVelocity(getVelocity() + speed);
		if (getVelocity() > 40) {
			System.out.println(carName + "의 최고속도 위반으로 속도를 100으로 낮춥니다.");
			setVelocity(40);
		} else {
			System.out.println(carName + "의 현재 속도는 " + getVelocity() + " 입니다.");
		}
	}

	public void speedDown(int speed) {
		setVelocity(getVelocity() - speed);
		if (getVelocity() < 10) {
			System.out.println(carName + "의 최저속도 위반으로 속도를 10으로 올립니다.");
			setVelocity(10);
		} else {
			System.out.println(carName + "의 현재 속도는 " + getVelocity() + " 입니다.");
		}
	}
}
