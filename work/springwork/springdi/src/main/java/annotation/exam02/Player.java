package annotation.exam02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class Player implements PlayerInterface{

	@Autowired
	Rand d;
	int totalValue=0;
	
	public Player() {
		
	}

	public Player(Rand rand) {
		this.d = rand;
		System.out.println("Player °´Ã¼ »ý¼º");
	}
	

	public void play(){
		totalValue=0;
		for (int i = 0; i < 3; i++) {
			totalValue+=d.getDiceValue();
		}
	}

	public int getTotalValue(){
		return totalValue;
	}
}