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
		//��һ��ϵͳ�������ͺá�
		
		while(in.hasNext()){
			//����֪����ֵ��λ����ʱ�򣬿�����list��������
			List<Integer> list = new ArrayList<Integer>();
			long i = in.nextLong();
			long j = Math.max(Math.max(in.nextLong(), in.nextLong()),in.nextLong());
			//�ҵ����б��Ǹ��ոպõ���ֵ��Ȼ����滻�Ϳ����ˡ�
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
			//���������������޸�list�е�ֵ��ͦ�õġ�
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