package leet.sort;
import java.security.AlgorithmConstraints;
import javax.swing.text.StyleContext.SmallAttributeSet;
import javax.xml.transform.Templates;
public class Sort {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//10:06  -- 11:07直接手写两个排序的代码了，还有优化，挺好的。
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
			flag = false;  //这里别忘了添加。
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
		//1.从第二个元素开始插入到之前的有序数组中
		//有序子数组的个数是从1开始一个一个递增的。
		//如果新插入的数比有序数组最大的大，放在有序数组的
		for(int i = 0;i<a.length-1;i++){
			int j = i;//有序子数组中最大数据的位置。
			int temp = a[i+1];//记录将要被插入的值。
			//在有序集中找需要插入的位置
			while(a[j] > temp && j>=0){
				a[j+1] = a[i];
				j--;
			}
			a[j + 1]=temp;
		}
	}
	public static void inserSort3(int[] a){
		//插入排序，1.记录需要插入的元素，2.已经有序的数组(对比找到应该插入的位置即可)，3从第一个元素有序的情况。
		for(int i = 0;i<a.length-1;i++){
			int j = i;
			int temp = a[i+1];
			while(j > -1 && a[j] >= temp){//注意的地方：这里的j下标要先判断。还有等于号的情况。
				a[j+1] = a[j];//向后移动位置。
				j--;
			}//跳出的时候就是找到了
			a[j+1] = temp;
		}
	}

	//这几大排序算法，一定要烂熟于心。从1数据的排序图，2基本的思想，3文字清楚的描述，4手撸代码，5到时间复杂度，稳定性。
	public static void inserSort(int[] a){
		int i,j,temp;
		int n = a.length;
		for(i =0 ;i < n-1;i++){//1.要排序的个数
			temp = a[i+1];//2，第一个元素可以看成是已经排列的有序数集合。
			j= i;
			while(j>-1 && temp<=a[j]){
				a[j+1] = a[j];
				j--;
			}
			a[j+1]=temp;
		}
	}
	//插入排序之希尔排序。
	public static void shellSort(int[] a,int[] d){
		for (int m = 0 ; m<d.length;m++){//共d.length次循环
			int span = d[m];//本次循环的增量值
			for (int k = 0;k<span;k++){//共span个小组。
				for(int i =k;i< a.length-span;i+= span){//为每一个小组内部采用增量为span的直接插入排序
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
	//稳定版本：就是上一步的時候把後面沒有排序的元素向後移動。
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
	//归并排序
}
