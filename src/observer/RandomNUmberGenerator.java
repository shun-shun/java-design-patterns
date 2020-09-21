package observer;

import java.util.Random;

public class RandomNUmberGenerator extends NumberGenerator {
	private Random random = new Random();
	private int number;
	@Override
	public int getNumber() {
		return number;
	}

	@Override
	public void execute() {
		for (int i = 0; i < 20; i++) {
			number = random.nextInt(50);
			notifyObservers();
		}
	}

}
