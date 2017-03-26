
public class productCipher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "sentfrommyiphone";
		String s = str.toUpperCase();
		String[] array = new String[16];
		String[] array1 = new String[16];
		for (int i = 0; i < str.length(); i++) {
			array[i] = String.valueOf(s.charAt(i));
		}
		{

			array1[0] = array[14];
			array1[1] = array[10];
			array1[2] = array[1];
			array1[3] = array[9];
			array1[4] = array[15];
			array1[5] = array[2];
			array1[6] = array[6];
			array1[7] = array[13];
			array1[8] = array[3];
			array1[9] = array[12];
			array1[10] = array[8];
			array1[11] = array[5];
			array1[12] = array[0];
			array1[13] = array[4];
			array1[14] = array[7];
			array1[15] = array[12];
		}
		System.out.println("plaintext:" + str);
		System.out.print("cipher:");
		for (int i = 0; i < array1.length; i++) {
			System.out.print(array1[i]);
		}
	}

}
