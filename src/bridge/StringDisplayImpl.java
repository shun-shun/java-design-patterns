package bridge;

public class StringDisplayImpl extends DisplayImpl {

	private String string;
	private int width;
	public StringDisplayImpl(String string) {
		this.string = string;
		this.width = string.getBytes().length;
	}

	@Override
	protected void rawOpen() {
		printLine();
	}

	@Override
	protected void rawPrint() {
		//前後に"|"をつけて表示。
		System.out.println("|" + string + "|");
	}

	@Override
	protected void rawClose() {
		printLine();
	}

	private void printLine() {
		System.out.print("+");
		for (int i = 0; i < width; i++) {
			System.out.print("-");
		}
		System.out.println("+");
	}


}
