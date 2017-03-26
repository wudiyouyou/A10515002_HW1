
public class rowTransposition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "sentfrommyiphone";
		String str = str1.toUpperCase();
		String[] array = new String[16];
		String[] array1 = new String[8];
		String[] array2 = new String[8];
		for (int i = 0; i < str.length(); i++) {
			array[i] = String.valueOf(str.charAt(i));
		}
		for (int i = 0; i < array.length / 2; i++) {
			array1[i] = array[i];
			// System.out.print(array1[i]);
		}
		for (int i = 8; i < array.length; i++) {
			array2[i - 8] = array[i];
			// System.out.print(array2[i - 8]);

		}

		int[] number = { 5, 2, 8, 3, 4, 6, 7, 1 };
		System.out.println("plaintext:" + str1);
		System.out.print("cipher:");
		for (int i = 1; i < number.length + 1; i++) {
			for (int j = 0; j < number.length; j++) {
				while (i == number[j]) {
					System.out.print(array1[j] + array2[j]);
					break;
				}
			}
		}
	}
}
