package prototype;

import prototype.framework.Manager;
import prototype.framework.Product;

public class Main {

	public static void main(String[] args) {
		// 準備
		Manager manager = new Manager();
		UnderlinePen pen = new UnderlinePen('~');
		MessageBox mbox = new MessageBox('*');
		MessageBox sbox = new MessageBox('/');
		manager.register("strong message", pen);
		manager.register("warning box", mbox);
		manager.register("slash box", sbox);

		// 生成
		Product p1 = manager.createString("strong message");
		p1.use("Hello, world.");
		Product p2 = manager.createString("warning box");
		p2.use("Hello, world.");
		Product p3 = manager.createString("slash box");
		p3.use("Hello, world.");
	}

}
