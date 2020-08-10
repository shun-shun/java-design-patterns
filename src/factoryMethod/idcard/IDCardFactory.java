package factoryMethod.idcard;

import java.util.ArrayList;
import java.util.List;

import factoryMethod.framework.Factory;
import factoryMethod.framework.Product;

public class IDCardFactory extends Factory {

	private List<String> owners = new ArrayList<String>();

	protected Product createProduct(String owner) {
		return new IDCard(owner);
	}

	protected void registerProduct(Product p) {
		owners.add(((IDCard)p).getOwner());
	}

	public List<String> getOwners() {
		return owners;
	}

}
