package jp.sample;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * パスワード予測
 * 
 * @author kichi
 *
 */
public class Encrypt {
	public static void main(String[] args) {
	}

	/**
	 * 0-0a-zまでの4桁の場合の全予測
	 */
	private static void allExpectation() {
		String targetStr = "0123456789abcdefghijklmnopqrstuvwxyz"; // 1679616通り
		String[] target = targetStr.split("");
		for (String one : target) {
			for (String two : target) {
				for (String three : target) {
					for (String four : target) {
						System.out.println(one + two + three + four);
					}
				}
			}
		}
	}

	/**
	 * 誕生日から推測する
	 */
	private static void birthExpectation() {
		boolean flg = false;
		String inputedYourBirthDay = null;
		re: while (true) {
			System.out.println("誕生日を\"2018/01/01\"の形式で入力してください。");
			Scanner scan = new Scanner(System.in);
			String temp = scan.next();
			System.out.println(temp + "でよろしいでしょうか");
			again: while (true) {
				System.out.println("良い:y , 違う:n を入力してください。");
				Scanner scan2 = new Scanner(System.in);
				String check = scan2.next();
				if (check.equals("y")) {
					flg = true;
					break;
				} else if (check.equals("n")) {
					flg = false;
					System.out.println("再入力をお願いします");
					break;
				} else {
					System.out.println("入力値はyかnでお願いします");
					continue again;
				}
			}
			if (flg) {
				inputedYourBirthDay = temp;
				break;
			} else {
				continue re;
			}
		}
		String[] yourBirthArray = inputedYourBirthDay.split("/");
		String[] year = yourBirthArray[0].split("");
		String[] month = yourBirthArray[1].split("");
		String[] day = yourBirthArray[2].split("");
		String targetStr = "";
		for (String y : year) {
			targetStr += y;
		}
		for (String m : month) {
			targetStr += m;
		}
		for (String d : day) {
			targetStr += d;
		}
		String[] target = targetStr.split(""); // とても無駄な変換を行っている（replaceで一発ww）
		Object[] nonOverlap = convertDistinctArray(target); // まさかの場合の文字にも対応しとく
		for (Object one : nonOverlap) {
			for (Object two : nonOverlap) {
				for (Object three : nonOverlap) {
					for (Object four : nonOverlap) {
						System.out.println(one.toString() + two.toString() + three.toString() + four.toString());
					}
				}
			}
		}
	}

	/**
	 * 重複部分の削除
	 * 
	 * @param target
	 * @return
	 */
	private static Object[] convertDistinctArray(String[] target) {
		List<String> list = new ArrayList<String>();
		for (String t : target) {
			list.add(t);
		}
		return list.stream().distinct().collect(Collectors.toList()).toArray();
	}
}
