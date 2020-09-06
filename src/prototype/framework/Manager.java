package prototype.framework;

import java.util.Hashtable;

public class Manager {

	private Hashtable<String, Product> showcase = new Hashtable<String, Product>();
	public void register(String name, Product proto) {
		showcase.put(name, proto);
	}
	public Product createString(String protoname) {
		Product p = (Product)showcase.get(protoname);
		return p.createClone();
	}

}
