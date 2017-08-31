package HuaWei;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

import javax.swing.text.ChangedCharSetException;

public class ZWei {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long s = in.nextLong();
		long n = in.nextLong();
		long m = in.nextLong();
		long result = 1;
		result = (long) ((Math.pow(Math.pow(s, n), m)) % 1000000007);
		System.out.println(result);
	}
}
