package flyweight;

import java.util.Hashtable;

public class BigCharFactory {

	private Hashtable pool = new Hashtable();

	private static BigCharFactory singleton = new BigCharFactory();

	private BigCharFactory() {

	}

	public static BigCharFactory getInstance() {
		return singleton;
	}

	public synchronized BigChar getBigChar(char charname) {
		BigChar bc = (BigChar)pool.get("" + charname);
		if(bc == null) {
			bc = new BigChar(charname);
			pool.put("" + charname, bc);
		}
		return bc;
	}


}
