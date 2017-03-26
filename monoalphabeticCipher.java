
public class monoalphabeticCipher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// String[][] table = new String[2][26];
		String[] lcletters = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
				"s", "t", "u", "v", "w", "x", "y", "z" };
		String[] hcletters = { "Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P", "A", "S", "D", "F", "G", "H", "J", "K",
				"L", "Z", "X", "C", "V", "B", "N", "M" };
		String str = "sentfrommyiphone";
		String[] array = new String[16];
		for (int i = 0; i < str.length(); i++) {
			array[i] = String.valueOf(str.charAt(i));
		}
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < lcletters.length; j++) {
				if (array[i].equals(lcletters[j])) {
					array[i] = hcletters[j];
					break;
				}

			}
		}
		System.out.println("plaintext:" + str);
		System.out.print("Ciphertext:");
		for (String str1 : array) {
			System.out.print(str1);
		}
	}

}
