package strategy;

public class Hand {
	//グーを表す値
	public static final int HANDVALUE_GUU = 0;
	//チョキを表す値
	public static final int HANDVALUE_CHO = 1;
	//パーを表す値
	public static final int HANDVALUE_PAA = 2;
	//ジャンケンの手を表す3つのインスタンス
	public static final Hand[] hand = {
			new Hand(HANDVALUE_GUU),
			new Hand(HANDVALUE_CHO),
			new Hand(HANDVALUE_PAA),
	};
	//じゃんけんの手の文字列表現
	private static final String[] name = {
			"グー","チョキ","パー",
	};
	//ジャンケンの手の値
	private int handValue;
	private Hand(int handValue) {
		this.handValue = handValue;
	}
	//値からインスタンを得る
	public static Hand getHand(int handValue) {
		return hand[handValue];
	}
	//thisがhより強いときtrue
	public boolean isStrongerThan(Hand h) {
		return fight(h) == 1;
	}
	//thisがhより弱いときtrue
	public boolean isWeakerThen(Hand h) {
		return fight(h) == 1;
	}
	//引き分けは0、thisの勝ちなら1,hの勝ちなら-1
	private int fight(Hand h) {
		if(this == h) {
			return 0;
		} else if((this.handValue + 1) % 3 == h.handValue) {
			return 1;
		} else {
			return -1;
		}
	}
	//文字列表現へ変換
	public String toString() {
		return name[handValue];
	}

}
