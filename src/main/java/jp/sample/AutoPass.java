package jp.sample;

/**
 * ランダムなパスワード
 * 
 * @author kichi
 *
 */
public class AutoPass {
	public static void main(String[] args) {
		String key = "0123456789abcdefghijklmnopqrstuvwxyz";
		int length = 8;
		createPass(key, length);
	}

	/**
	 * 指定された文字列と桁数よりランダムなパスを出力する
	 * 
	 * @param key
	 * @param length
	 */
	private static void createPass(String key, int length) {
		String target[] = key.split("");
		String result = "";
		for (int i = 0; i < length; i++) {
			int val = (int) Math.floor(Math.random() * target.length);
			result += target[val];
		}
		System.out.println(result);

	}

}
