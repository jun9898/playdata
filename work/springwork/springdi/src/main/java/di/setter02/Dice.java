package di.setter02;
import java.util.Random;
public class Dice extends Random implements Rand{
	
	public int getDiceValue(){
		return nextInt(6)+1;
	}
}

