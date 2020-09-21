package memento.game;

import java.util.ArrayList;
import java.util.List;

public class Memento {
	int money;
	List<String> fruits;
	public int getMoeny() {
		return money;
	}
	public Memento(int money) {
		this.money = money;
		this.fruits = new ArrayList<String>();
	}
	void addFruit(String fruit) {
		fruits.add(fruit);
	}
}
