package leet.array;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author jkb
 */
public class Xym {
	/**
	 * ���ܣ�Java��ȡtxt�ļ������� ���裺1���Ȼ���ļ���� 2������ļ��������������һ���ֽ���������Ҫ��������������ж�ȡ
	 * 3����ȡ������������Ҫ��ȡ�����ֽ��� 4��һ��һ�е������readline()�� ��ע����Ҫ���ǵ����쳣���
	 * 4.�����ı����ݡ�
	 * @param filePath
	 */
	public static void readTxtFile(String filePath) {
		try {
			String encoding = "GBK";
			File file = new File(filePath);
			if (file.isFile() && file.exists()) { // �ж��ļ��Ƿ����
				InputStreamReader read = new InputStreamReader(
						new FileInputStream(file), encoding);// ���ǵ������ʽ
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				lineTxt = bufferedReader.readLine();
				int i = 2;
				//list1����ָ��Դ���ݵĵ�1��
				//list2����ָ��Դ���ݵĵ�2��
				//list3����ָ����ĺ����ݵ���ͬ����
				//list4����ָ����ĺ����ݵĲ�ͬ����
				List<Person> list1 = new ArrayList<Person>();
				List<Person> list2 = new ArrayList<Person>();
				List<Person> list3 = new ArrayList<Person>();
				List<Person> list4 = new ArrayList<Person>();
				while ((lineTxt = bufferedReader.readLine()) != null) {
					// System.out.println(lineTxt);
					String s1 = lineTxt;
					String[] strings = s1.split("\t");
					for (int j = 0; j < strings.length; j++) {
						String s2 = strings[j].substring(1,
								strings[j].length() - 1);
						String[] para = s2.split(",");
						Person person = new Person();
						person.setName(para[0]);
						person.setS(Double.parseDouble(para[1]));
						person.setC(Double.parseDouble(para[2]));
						if (i % 2 == 0) {
							list1.add(person);
						} else {
							list2.add(person);
						}
						i++;
					}
				}
//				System.out.println(list1);
//				System.out.println(list2);
				
				//��������list�е����ݣ�
				change(list1, list2, list3, list4);
				System.out.println("-----------------------------");
				System.out.println("���:");
				System.out.println("��ͬ����:");
				for (Iterator iterator = list3.iterator(); iterator.hasNext();) {
					Person person = (Person) iterator.next();
					System.out.println(person.toString());
				}
				System.out.println("��ͬ����:");
				for (Iterator iterator = list4.iterator(); iterator.hasNext();) {
					Person person = (Person) iterator.next();
					System.out.println(person.toString());
				}
				read.close();
			} else {
				System.out.println("�Ҳ���ָ�����ļ�");
			}
		} catch (Exception e) {
			System.out.println("��ȡ�ļ����ݳ���");
			e.printStackTrace();
		}

	}
	/**
	 * ��������(�������������ݡ�������)
	 * @param list1ָ��Դ���ݵĵ�1��
	 * @param list2ָ��Դ���ݵĵ�2��
	 * @param list3����ָ����ĺ����ݵ���ͬ����
	 * @param list4����ָ����ĺ����ݵĲ�ͬ����
	 */
	public static void change(List list1,List list2,List list3,List list4){
		list1.iterator();
		for (Iterator iterator = list1.iterator(); iterator.hasNext();) {
			Person p1 = (Person) iterator.next();
			for (Iterator iterator2 = list2.iterator(); iterator2.hasNext();) {
				Person p2 = (Person) iterator2.next();
				if (p1.getName().equals(p2.getName())) {
					p1.setS( 0.8*p1.getS() +0.2*p2.getS());
					p1.setC( 0.8*p1.getC() + 0.2*p2.getC());
					list3.add(p1);
					iterator.remove();
					iterator2.remove();
				}
			}
		}
		for (Iterator iterator = list1.iterator(); iterator.hasNext();) {
			Person p1 = (Person) iterator.next();
			list4.add(p1);
		}
		for (Iterator iterator = list2.iterator(); iterator.hasNext();) {
			Person p2 = (Person) iterator.next();
			list4.add(p2);
		}
	}
	public static void main(String argv[]) {
		String filePath = "D:\\SoftWare\\eclipse\\com.jiang.test\\JavaData\\src\\��Ȩ��Ͳ�������.txt";
		// "res/";
		readTxtFile(filePath);
	}

}

class Person {

	private String name;
	private double s;
	private double c;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getS() {
		return s;
	}

	public void setS(double s) {
		this.s = s;
	}

	public double getC() {
		return c;
	}

	public void setC(double c) {
		this.c = c;
	}

	@Override
	public String toString() {
		DecimalFormat df=new DecimalFormat("########.##");
		return name + "," + df.format(s) + "," + df.format(c);
	}
	

}
/*
 * ɾ���ַ������һ���ַ��ļ��ַ���
 * 
 * żȻ�����ģ���¼һ�£���������
 * 
 * �ַ�����string s = "1,2,3,4,5,"
 * 
 * Ŀ�꣺ɾ�����һ�� ","
 * 
 * ������ 1���õ�������Substring�����Ҳ����һֱ�õ�
 * 
 * 
 * s = s.Substring(0,s.Length - 1)
 * 
 * 
 * 2���� RTrim�������ԭ��ֻ֪������ɾ�����Ŀո�Ҳû����ϸ�����������÷����ŷ��ֿ���ֱ��trim��һЩ�ַ�
 * 
 * 
 * s = s.ToString().RTrim(',')
 * 
 * 3����TrimEnd,���������RTrim��࣬������������ݵ���һ���ַ����飬��RTrim�������κ���Ч���ַ���
 * 
 * 
 * s=s.TrimEnd(',') //���Ҫɾ��"5,"������Ҫ��ôд char[] MyChar = {'5',','}; s =
 * s.TrimEnd(MyChar); //s = "1,2,3,4"
 * 
 * ======================================================== Map<String,String>
 * paraMap=new HashMap<String,String>(); String
 * str="name=zhang,age=30,sex=male"; String[] para=str.split(","); for(int
 * i=0,len=para.length;i<len;i++){ String[] temp=para[i].split("=");
 * paraMap.put(temp[0], temp[1]); } Person p=new Person();
 * p.setName(paraMap.get("name"));
 */