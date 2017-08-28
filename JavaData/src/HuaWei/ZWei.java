package HuaWei;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import javax.swing.text.ChangedCharSetException;

public class ZWei {
	/** ������������������ʵ����ĿҪ��Ĺ��� **/
	/** ��Ȼ����Ҳ���Բ��������ģ����������ȫ�����Լ����뷨�� ^-^ **/
	static int findCircleNum(int[][] M) {
		return DeepTraGraph(M);
	}

	// ������ȱ���
	static int DeepTraGraph(int[][] g) {
		int count = 0;
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i <=  g[0].length; i++) {
			list.add(i);
		}
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Integer integer = (Integer) iterator.next();
			DeepTraOne(g, integer , list);
			list.remove(integer);
			count++;
		}
		return count;
	}

	// ����
	static void DeepTraOne(int[][] g, Integer n,List<Integer> list) {// �ӵ�n���ڵ㿪ʼ����
		// ���Ӵ����ڵ�Ĳ���
		for (int i = n+1; i < g.length; i++) {
			if (g[n][i] == 1) {
				list.remove((Integer)i);
				DeepTraOne(g, i,list); // �ݹ���б���
			}
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int res;

		int rows = 0;
		int cols = 0;
		rows = Integer.parseInt(in.nextLine().trim());
		cols = Integer.parseInt(in.nextLine().trim());

		int[][] _M = new int[rows][cols];
		for (int _M_i = 0; _M_i < rows; _M_i++) {
			String row_x = String.valueOf(in.nextLine().trim());
			String[] row_y = row_x.split(",");
			for (int _M_j = 0; _M_j < cols; _M_j++) {
				_M[_M_i][_M_j] = Integer.parseInt(row_y[_M_j]);

			}
		}

		if (in.hasNextLine()) {
			in.nextLine();
		}

		res = findCircleNum(_M);
		System.out.println(String.valueOf(res));

	}

}