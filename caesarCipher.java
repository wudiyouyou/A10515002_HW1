
import java.io.IOException;

public class caesarCipher {

	public static void main(String[] args) throws IOException {
		String[] alphabet = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R",
				"S", "T", "U", "V", "W", "X", "Y", "Z", "A", "B", "C" };
		String str1 = "sentfrommyiphone";
		String str = str1.toUpperCase();
		String[] array = new String[16];
		for (int i = 0; i < str.length(); i++) {
			array[i] = String.valueOf(str.charAt(i));
		}
		for (int i1 = 0; i1 < array.length; i1++) {
			for (int i2 = 0; i2 < alphabet.length - 3; i2++) {
				if (array[i1].equals(alphabet[i2])) {
					array[i1] = alphabet[i2 + 3];
					break;
				}
			}
		}
		System.out.println("Plaintext:" + str1);
		System.out.print("Ciphertext:");
		for (int i3 = 0; i3 < array.length; i3++) {
			System.out.print(array[i3]);
		}
	}

}
