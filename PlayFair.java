
import java.nio.CharBuffer;

/* 
 * PlayFair 
 */
public class PlayFair {
	public static char[] encode(char[] plain, char[] key, char replace) {
		// 构造解密矩阵
		char[][] matrix = constructMatrix(key);
		// 为缓冲区分配空间
		CharBuffer xplain = CharBuffer.allocate(plain.length * 2);
		// 重新生成明文
		int len = 0;
		int i = 0;
		for (i = 0; i < plain.length - 1; i++) {
			xplain.append(plain[i]);
			if (i != plain.length - 1) {
				if (plain[i] == plain[i + 1]) {
					xplain.append(replace);
				} else {
					xplain.append(plain[i + 1]);
					i++;
				}
			} else {
				xplain.append(replace);
			}
			len += 2;
		}
		// 剩余最后一个字符
		if (i == plain.length - 1) {
			xplain.append(plain[i]);
			xplain.append(replace);
			len += 2;
		}
		char[] xxplain = new char[len];
		xplain.position(0);
		xplain.get(xxplain);
		System.out.println("plaintext_a: " + new String(xxplain));
		char[] cipher = getCipher(xxplain, matrix);
		return cipher;
	}

	/**
	 * 根据密文和密钥解密密文并返回生成的明文
	 * 
	 * @param cipher
	 * @param key
	 * @return
	 */

	private static char[] getCipher(char[] plain, char[][] matrix) {
		char[] cipher = new char[plain.length];
		int index = 0;
		for (int i = 0; i < plain.length - 1; i += 2) {
			int row1, row2, col1, col2;
			String[] pos1, pos2;
			pos1 = getPosition(matrix, plain[i]);
			pos2 = getPosition(matrix, plain[i + 1]);
			if (pos1 == null || pos2 == null) {
				throw new RuntimeException("明文中包含无效字符");
			}
			row1 = Integer.parseInt(pos1[0]);
			col1 = Integer.parseInt(pos1[1]);
			row2 = Integer.parseInt(pos2[0]);
			col2 = Integer.parseInt(pos2[1]);
			if (row1 == row2) {
				// 同一行的情况
				if (col1 == matrix[0].length - 1) {
					cipher[index++] = matrix[row1][0];
					cipher[index++] = matrix[row1][col2 + 1];
				} else if (col2 == matrix[0].length - 1) {
					cipher[index++] = matrix[row1][col1 + 1];
					cipher[index++] = matrix[row1][0];
				} else {
					cipher[index++] = matrix[row1][col1 + 1];
					cipher[index++] = matrix[row1][col2 + 1];
				}
			} else if (col1 == col2) {
				// 同一列的情况
				if (row1 == matrix.length - 1) {
					cipher[index++] = matrix[0][col1];
					cipher[index++] = matrix[row2 + 1][col1];
				} else if (col2 == matrix.length - 1) {
					cipher[index++] = matrix[row1 + 1][col1];
					cipher[index++] = matrix[0][col1];
				} else {
					cipher[index++] = matrix[row1 + 1][col1];
					cipher[index++] = matrix[row2 + 1][col2];
				}
			} else {
				cipher[index++] = matrix[row1][col2];
				cipher[index++] = matrix[row2][col1];
			}
		}
		return cipher;
	}

	/**
	 * 返回字符在矩阵中的位置
	 * 
	 * @param matrix
	 * @param ch
	 * @return
	 */
	private static String[] getPosition(char[][] matrix, char ch) {
		String[] pos = new String[] { null, null };
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if ((matrix[i][j] == ch) || (matrix[i][j] == 'j' && ch == 'i') || (matrix[i][j] == 'i' && ch == 'j')) {
					pos[0] = i + "";
					pos[1] = j + "";
					return pos;
				}
			}
		}
		return null;
	}

	/**
	 * 用密钥构造矩阵
	 * 
	 * @param cyber
	 * @param key
	 * @return
	 */
	private static char[][] constructMatrix(char[] key) {
		char[][] matrix = new char[5][5];
		CharBuffer buf = CharBuffer.allocate(25);
		buf.append(key[0]);
		// 移除密钥中重复的字符
		for (int i = 1; i < key.length; i++) {
			if (!contains(buf.array(), key[i])) {
				buf.append(key[i]);
			}
		}
		// 将字母表中剩余的字符加入
		for (int i = 0; i < 26; i++) {
			char ch = (char) ('a' + i);
			if (!contains(buf.array(), ch)) {
				buf.append(ch);
			}
		}
		int index = 0;
		buf.position(0);
		System.out.println("matrix：");
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (index != buf.length()) {
					matrix[i][j] = buf.get(index++);
					System.out.print(matrix[i][j] + "\t");
				}
			}
			System.out.println();
		}
		buf.clear();
		return matrix;
	}

	/**
	 * 判断是否包含字符（这里将i和j视为同一个字符）
	 * 
	 * @param buf
	 * @param c
	 * @return
	 */
	private static boolean contains(char[] buf, char c) {
		for (int i = 0; i < buf.length; i++) {
			if (buf[i] == c || (c == 'j' && buf[i] == 'i') || (c == 'i' && buf[i] == 'j'))
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String plain = "sentfrommyiphone"; // 明文,去掉空格
		String key = "DPP"; // 密钥，去掉空格
		char replace = 'x'; // 填充字符
		System.out.println("plaintext: " + plain + " \nkey: " + key + "\nchar: " + replace);
		char[] cipher = PlayFair.encode(plain.toLowerCase().toCharArray(), key.toLowerCase().toCharArray(), replace);
		System.out.println("==========================================");
		System.out.println("cipher: " + new String(cipher).toUpperCase());
	}

}
