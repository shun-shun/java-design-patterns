package templateMethod;

public class Main {

	public static void main(String[] args) {
		// 'H'を持ったCharDisplayのインスタンスを１個作る
		AbstractDisplay d1 = new CharDisplay('H');
		// "Hello, world."を持ったStringDisplayのインスタンスを１個作る
		AbstractDisplay d2 = new StringDisplay("Hello, world.");
		// "こんにちは。"を持ったStringDisplayのインスタンスを１個作る
		AbstractDisplay d3 = new StringDisplay("こんにちは。");
		// d1,d2,d3とも全て同じAbstractDisplayのサブクラスのインスタンスだから
		d1.display();
		// 継承したdisplayメソッドを呼び出すことができる
		d2.display();
		// 実際の動作は個々のクラスCharDisplayやStringDisplayで定まる
		d3.display();
	}

}
