package HuaWei;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

import javax.swing.text.ChangedCharSetException;

public class cjm {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		//当一个系统来处理就好。
		
		while(in.hasNext()){
			//当不知道数值的位数的时候，考虑用list来处理。
			List<Integer> list = new ArrayList<Integer>();
			long i = in.nextLong();
			long j = Math.max(Math.max(in.nextLong(), in.nextLong()),in.nextLong());
			//找到其中比那个刚刚好的数值，然后就替换就可以了。
			int result =0;
			while(i > 0){
				 list.add((int) (i % 10));
				 if(j>(int) (i % 10))result = (int) (i % 10);
                 i = i / 10;
			}
			long last = 0l;
			int m = 0;
			for (Iterator iterator = list.iterator(); iterator.hasNext();) {
				Integer integer = (Integer) iterator.next();
				if(integer.intValue() == result){
					integer = (int) j;
				}
				last += (long) (integer*Math.pow(10, m++));
			}
			System.out.println(last);
			//用索引遍历可以修改list中的值，挺好的。
//			for (int k = 0; k < list.size(); k++) {
//				Integer integer = (Integer) list.get(k);
//				if (integer.intValue() ==result) {
//					list.set(k, (int)j);
//					integer =(int)j;
//				}
//				last += (long) (integer*Math.pow(10, m++));
//			}
	//		System.out.println(last);
		}
	}
}
