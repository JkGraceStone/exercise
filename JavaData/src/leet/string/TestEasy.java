package leet.string;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;

public class TestEasy {
	public boolean judgeCircle(String moves) {
        //1【思路】.把string拆分为字节数组，然后统计方向。
        char[] movesChar = moves.toCharArray();
        int udCount = 0;
        int lrCount = 0;
        for(char c :movesChar){
        	if(c=='U'){
        		udCount++;
        	}else if (c=='D') {
				udCount--;
			}else if (c=='R') {
				lrCount++;
			}else if (c=='L') {
				lrCount--;
			}else {
				return false;
			}
        }
        return lrCount==0&&udCount==0 ? true:false;
	}
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int count = 0;
		String lineString = scanner.nextLine();
		char c = scanner.nextLine().charAt(0);
		char[] chars = lineString.toCharArray();
		
		Character.toLowerCase(c);
		System.out.print(c);
		for (int i = 0; i < chars.length; i++) {
			if(Character.toLowerCase(chars[i])==Character.toLowerCase(c)){
				count++;
			}
					
		}
		System.out.println(count);
	/*	TreeSet<Integer> set = new TreeSet<Integer>();
		for (Iterator iterator = set.iterator(); iterator.hasNext();) {
			Integer integer = (Integer) iterator.next();
			
		}*/
	}
	
}
