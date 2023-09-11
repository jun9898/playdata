package basic;

import java.util.Iterator;

class A extends Thread{
	A(String name){
		super(name);
	}
	public void run() {
		for (int i = 0; i <=20; i++) {
			System.out.println(i+"("+getName()+")");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
public class Test2 {
	public static void main(String[] args) {
		A obj = new A("test");
		obj.start();
		
		A obj2 = new A("test2");
		obj2.start();

	}

}
