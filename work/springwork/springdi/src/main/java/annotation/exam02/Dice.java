package annotation.exam02;
import java.util.Random;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class Dice extends Random implements Rand{

	public int getDiceValue(){
		return nextInt(6)+1;
	}
}

