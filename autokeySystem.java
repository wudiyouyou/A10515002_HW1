
public class autokeySystem {

	/*
	 * 下面方法用来显示key的index
	 */
	public static void getArrayKey(String[] arraykey) {
		for (int i = 0; i < arraykey.length; i++) {
			System.out.print(arraykey[i] + " ");
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numberter = new int[16];
		int[] number = new int[16];
		String key = "KMT";
		String[] arraykey = new String[16];
		for (int i = 0; i < key.length(); i++) {
			arraykey[i] = String.valueOf(key.charAt(i));
			// System.out.print(arraykey[i]);
		}

		String str1 = "sentfrommyiphone";
		String str = str1.toUpperCase();
		String[] array = new String[16];
		for (int i = 0; i < str1.length(); i++) {
			array[i] = String.valueOf(str.charAt(i));
		}

		for (int i = 0; i < array.length - 3; i++) {
			arraykey[i + 3] = String.valueOf(str.charAt(i));
			// System.out.print(arraykey[i]);

		}

		String[] alphabet = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R",
				"S", "T", "U", "V", "W", "X", "Y", "Z", "A", "B", "C", "D", "E", "F" };

		for (int i = 0; i < alphabet.length - 6; i++) {
			for (int j = 0; j < arraykey.length; j++) {
				while (arraykey[j].equals(alphabet[i])) {
					number[j] = i;
					break;
				}
			}
		}
		// 上面是通过比照找到key的字母位置
		for (int i = 0; i < alphabet.length - 6; i++) {
			// System.out.print(number1 + " ");
			for (int j = 0; j < array.length; j++) {
				while (array[j].equals(alphabet[i])) {
					numberter[j] = i ^ number[j];
					break;
				}
			}
		}

		// System.out.print(10 ^ 18);
		// 通过比照找到明文字母中的位置，并通过^操作得到新数值存储在int数组中。
		System.out.print("location:");
		for (int i = 0; i < numberter.length; i++) {
			System.out.print(numberter[i] + " ");
		}
		System.out.println();
		System.out.println("plain:" + str1);
		System.out.print("cipher:");
		for (int i = 0; i < numberter.length; i++) {
			System.out.print(alphabet[numberter[i]]);
		}
	}

}
