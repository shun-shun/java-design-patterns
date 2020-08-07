package factoryMethod;

public class Main {

	public static void main(String[] args) {
		Factory factory = new IDCardFactory();
		Product card1 = factory.create("ごんどう");
		Product card2 = factory.create("しゅん");
		Product card3 = factory.create("権藤俊");

		card1.use();
		card2.use();
		card3.use();
	}

}
