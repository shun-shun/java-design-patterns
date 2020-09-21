package chain_of_responsibility;

public class OddSupport extends Support {

	public OddSupport(String name) {
		super(name);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@Override
	protected boolean resolve(Trouble trouble) {
		return trouble.getNumber() % 2 == 1;
	}

}
