package HuaWei;


/**
 * �¼���ʦ��2017.8.16 ��Ϊ����
 * @author load
 *
 */
import java.util.Scanner;
public class FindMatch {
	public static void main(String[] args) {
		Scanner  scanner = new Scanner(System.in);
		//System.out.println(findMatch(scanner.nextLine(),scanner.nextLine()));
		System.out.println(findMatch(scanner.next(), scanner.next()));
	}
	public static int findMatch(String str1,String str2){
		//1.�����߽����,���Ȳ��ȣ����߷���ֵ��
		if (str1.length()!= str2.length()) {
			return -1;
		}
		try {
			int i = Integer.parseInt(str1);
			int j = Integer.parseInt(str2);
		} catch (NumberFormatException e) {
			return -1;
		}
		//2.��Ҫҵ�����
		char[] c1= str1.toCharArray();
		char[] c2 = str2.toCharArray();
		int maxCount = 0;
		int nowCount = 0;
		for (int i = 0; i < c1.length; i++) {
			if(c1[i]==c2[i]){
				nowCount++;
				maxCount = Math.max(maxCount, nowCount);
			}else {
				nowCount = 0;
			}
		}
		return maxCount < 2 ? 1:maxCount;
	}

}