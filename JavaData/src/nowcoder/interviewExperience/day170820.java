package nowcoder.interviewExperience;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class day170820 {

	@FunctionalInterface
	interface Converter<F, T> {
	    T convert(F from);
	}
	public static void main(String[] args) {
//��ϰJava��lambda����ʽ��
		List<String> names = Arrays.asList("peter", "anna", "mike", "xenia"); 
		//1��һ��д�����ⲿ�����ͬ���µ��۵�ʹ��
		Comparator mycomparetor = new Mycomparetor();
		Collections.sort(names, mycomparetor);
		System.out.println(names);
		//�ڶ���д���������ڲ��ࡣ
		Collections.sort(names, new Comparator<String>() {
			public int compare(String o1, String o2) {
				return o2.compareTo(o1);
			};
		});
		System.out.println(names);
//		��Java 8 �����û��Ҫʹ�����ִ�ͳ����������ķ�ʽ�ˣ�Java 8�ṩ�˸������﷨��lambda����ʽ��
		Collections.sort(names, (String a, String b) -> {
		    return b.compareTo(a);
		});
		System.out.println(names);
//		�����Ǳ�׼д����
		Collections.sort(names, (String a,String b)->b.compareTo(a));
		Collections.sort(names, (b,a)-> b.compareTo(a));

//ʲô��lampda����ʽ��
		
		Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
		Integer converted = converter.convert("123");
		System.out.println(converted);    // 123
//		1.��ѧ�Ķ���һ��Ҫ�ܽᣬ�ܽ���һ����ѧϰ�Ĺ��̡�ĥ�����󿳲񹤡�
//		lambda����ʽ������ʽ�ӿ�@FunctionInterface,ֻ����һ���������Ľӿڡ�ÿһ��lambda����ʽ��Ӧһ������ʽ�ӿڡ�
		//����ʽ�ӿڣ����Բ�ֹһ�������������ж������������ֻ��һ������������Ϊjava8������Ĭ�Ϻ���
	}
//	����Java����
//	1������һ������������е����������ͷ����������ָ�룬ָ��ǰ0Ԫ�غͷ���Ԫ�أ��������ɡ�
//	2����������һ�α����жϻ�����
//	3�������ַ���A��B�����ٲ������԰��ַ���aת�����ַ���b�������ַ���ת������
//	4��������𣬴�����Ϊʲô�죬���ݿ�ײ�b������b�Ӻ�b������
//	5��jdk7��jdk8������
//	6����ô����  jvm����

	public static void wangyi1(int[] nums){
		for (int i = 0, j = nums.length - 1; i < j; ) {
			while(nums[i]==0)i++;
			while(nums[j]!=0)j--;
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
			i++;
			j--;
		}
	}
	

}
class Mycomparetor implements Comparator<String>{

	@Override
	public int compare(String str1, String str2) {
//		return 0;
		return str1.compareTo(str2);
	}
	
}