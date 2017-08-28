package leet.sort;
import java.security.AlgorithmConstraints;
import javax.swing.text.StyleContext.SmallAttributeSet;
import javax.xml.transform.Templates;
public class Sort {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//10:06  -- 11:07ֱ����д��������Ĵ����ˣ������Ż���ͦ�õġ�
		int[] a = {64,5,7,889,6,24};
		inserSort3(a);
		for(int i : a)
		System.out.print(i+" ");
		bobSort(a);
		for(int i : a)
		System.out.print(i+" ");
	}
	public static void bobSort(int[] a){
		for(int i= 0;i<a.length-1;i++){
			for (int j= 0;j<a.length-i-1;j++){
				if(a[j] > a[j+1]){
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
	}
	public static void bobSort1(int[] a){
		boolean flag = false;
		for (int i = 0;i<a.length-1;i++){
			flag = false;  //������������ӡ�
			for (int j = 0;j<a.length-1-i;j++){
				if(a[j]>a[j+1]){
					flag = true;
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
			if(flag) return;
		}
	}
	public static void inserSort1(int[] a){
		//1.�ӵڶ���Ԫ�ؿ�ʼ���뵽֮ǰ������������
		//����������ĸ����Ǵ�1��ʼһ��һ�������ġ�
		//����²�������������������Ĵ󣬷������������
		for(int i = 0;i<a.length-1;i++){
			int j = i;//������������������ݵ�λ�á�
			int temp = a[i+1];//��¼��Ҫ�������ֵ��
			//������������Ҫ�����λ��
			while(a[j] > temp && j>=0){
				a[j+1] = a[i];
				j--;
			}
			a[j + 1]=temp;
		}
	}
	public static void inserSort3(int[] a){
		//��������1.��¼��Ҫ�����Ԫ�أ�2.�Ѿ����������(�Ա��ҵ�Ӧ�ò����λ�ü���)��3�ӵ�һ��Ԫ������������
		for(int i = 0;i<a.length-1;i++){
			int j = i;
			int temp = a[i+1];
			while(j > -1 && a[j] >= temp){//ע��ĵط��������j�±�Ҫ���жϡ����е��ںŵ������
				a[j+1] = a[j];//����ƶ�λ�á�
				j--;
			}//������ʱ������ҵ���
			a[j+1] = temp;
		}
	}

	//�⼸�������㷨��һ��Ҫ�������ġ���1���ݵ�����ͼ��2������˼�룬3���������������4��ߣ���룬5��ʱ�临�Ӷȣ��ȶ��ԡ�
	public static void inserSort(int[] a){
		int i,j,temp;
		int n = a.length;
		for(i =0 ;i < n-1;i++){//1.Ҫ����ĸ���
			temp = a[i+1];//2����һ��Ԫ�ؿ��Կ������Ѿ����е����������ϡ�
			j= i;
			while(j>-1 && temp<=a[j]){
				a[j+1] = a[j];
				j--;
			}
			a[j+1]=temp;
		}
	}
	//��������֮ϣ������
	public static void shellSort(int[] a,int[] d){
		for (int m = 0 ; m<d.length;m++){//��d.length��ѭ��
			int span = d[m];//����ѭ��������ֵ
			for (int k = 0;k<span;k++){//��span��С�顣
				for(int i =k;i< a.length-span;i+= span){//Ϊÿһ��С���ڲ���������Ϊspan��ֱ�Ӳ�������
					int temp = a[i+span];
					int j = i;
					while(j>-1&&temp<=a[j]){
						a[j+span] = a[j];
						j-=span;
					}
					a[j+span] =temp;
				}
			}
		}
	}
//	6 2 9 4 5 7 3
//	3 2 4 5 6 7 9
	public static void quickSort(int[] a,int low ,int high){
		int i = low ,j = high;
		int temp = a[low];
		while(i<j){
			while(i<j && a[j]>temp)
				j--;
			if(i<j){
				a[i] = a[j];
				i++;
			}
			while(i<j){
				while(i<j && a[i]<temp)
					i++;
				if(i<j){
					a[j] = a[i];
					j--;
				}
			}
		}
		a[i] = temp;
		
		if(low<i)quickSort(a, low, i-1);
		if(high>j)quickSort(a, j+1, high);
	}
//	64 5 7 89 6 24 
//	5 64 7 89 6 24
	public static void selectSort(int[] a){
		for(int i =0;i<a.length-1;i++){
			int small = i;
			for(int j = i+1;j<a.length;j++){
				small = a[j]<a[small] ? small : j; 
			}
			if(small != i){
				int temp = a[i];
				a[i] = a[small];
				a[small] = temp;
			}
		}
	}
	//�ȶ��汾��������һ���ĕr�������]�������Ԫ�������Ƅӡ�
	public static void selectSortStable(int[] a){
		for(int i =0;i<a.length-1;i++){
			int small = i;
			for(int j = i+1;j<a.length;j++){
				small = a[j]<a[small] ? small : j; 
			}
			if(small != i){
				int temp = a[i];
				a[i] = a[small];
				a[small] = temp;
			}
		}
	}
	//�鲢����
}