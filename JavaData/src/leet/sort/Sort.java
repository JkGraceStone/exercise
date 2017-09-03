package leet.sort;
import java.security.AlgorithmConstraints;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

import javax.swing.text.StyleContext.SmallAttributeSet;
import javax.xml.transform.Templates;
public class Sort {
	//程序主要参考，严蔚敏，数据结构。朱战立，数据结构，java语言描述第二版，清华大学出版社。
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
	//稳定版本：就是上一步的時候把後面沒有排序的元素向後【移動】。
	public static void selectSortStable(int[] a){
		for(int i =0;i<a.length-1;i++){
			int small = i;
			int j = 0;
			for(j = i+1;j<a.length;j++){
				small = a[j]<a[small] ? small : j; 
			}
			if(small != i){
				int temp = a[small];
				for (j = small; j > i; j--) {
					a[j] = a[j-1];//移动元素。
				}
				a[i] = a[small];
				a[small] = temp;
			}
		}
	}
	//归并排序--二路归并。
	//其实有思路，然后去做很简单。关键是先把思路完全熟悉了。这样去写，然后知道其中应该注意的地方，信手拈来。在其他地方可以当一个小技巧，随便使用。
	//所有的都应该做成util的样子。
	public static void merge(int[] a , int[] swap ,int k){
		int m= 0,l1 =0,u1,l2,u2;
		int i,j;
		while(l1+k <= a.length - 1){
			l2 = l1+k;//第二个有序子数组的下界low 
			u1 = l2 -1;//第一个有序子数组的上界up 
			u2 = (l2 + k -1 <= a.length -1)? l2+k-1 : a.length -1;//1第二个有序子数组的上界low 
			//2从两个子数组找小的元素，插入到我们的新数组中，直到某一个子数组已经找完，那么另外一个没有找完的子数组剩下的元素就比已经找完的这个要大。把剩下的全部遍历完就可以了。
			for(i = l1,j = l2;i<=u1&&j<=u2;m++){
				if(a[i]<=a[j]){//稳定
					swap[m] = a[i++];
				}else{
					swap[m] = a[j++];
				}
			}
			while(i<=u1) swap[m++] = a[i++];//如果上一个for循环，是j>u2跳出的会执行这段代码（说明子数组2已经归并完成），将子数组1中剩余的元素放入到数组swap中。
			while(j<=u2) swap[m++] = a[j++];//如果上一个for循环，是1>u1跳出的会执行这段代码（说明子数组1已经归并完成），将子数组2中剩余的元素放入到数组swap中。
			
			l1 = u2 +1;//3第三个有序数组的上界限。非常经典。
		}
		//4将原始数组中，只够一组的数据元素，顺序的放到数组swap中。
		for(i = l1;i<a.length;i++,m++) swap[m] = a[i];
	}
	public static void mergeSort(int[] a){
		int[] swap = new int[a.length];
		int k = 1;
		while(k<a.length){
			merge(a, swap, k);
			//将元素从零时数组swap中放回到数组a中。
			for (int i = 0; i < a.length; i++)
				a[i] = swap[i];
			//调整每个子数组的长度。
			k *= 2;
		}
	}
//	
	/**
	 * 堆排序实现：经典。
	 */
	public static void heapSort(int[] a){
		//1.把最大堆的堆顶元素和当前最大堆的最后一个元素交换
		//2.最大堆元素个数减1
		//3.调整根节点，使之继续满足最大堆的定义。
		int temp;
		initCreateHeap(a);
		for (int i = a.length - 1; i > 0; i--) {
			temp = a[0];
			a[0] = a[i];
			a[i] = temp;
			createHeap(a, i,0);//这里i全部是堆的元素个数。
		}
	}
	public static void initCreateHeap(int[] a){
		//左右孩子都是符合最大堆的约定。
		//原始状态第一个可能不符合最大堆定义的是第一个非叶子节点。从这个位置出发，依次创建最大堆。
		for(int i = (a.length-1)/2;i >= 0;i--){
			createHeap(a,a.length, i);
		}
	}
	public static void createHeap(int[] a,int n , int h){
		int i = h ,j = 2*h + 1;
		int flag = 0;
		int temp = a[h];
		//找出左右孩子中较大者，重复向下筛选。
		while(j<n && flag != 1){
			if(h < n-1 && a[j] < a[j+1]) j++;//找到左右孩子中较大者。
			if(temp > a[j]){
				flag = 1;//如果比左右孩子中最大者都大，那么就标记结束筛选条件，跳出循环。
			}else {
				a[i] = a[j];//这里就是a[i],不能是a[h]。把子树中的最大者放到i位置。因为这样处理之后，如果直接把temp放入a[j],可能子树就不符合最大堆了。所以还要找到合适的位置放入才行。
				i = j;
				j = 2*i +1;//让子树执行同样的操作，循环。
			}
		}
		a[i] = temp;//把等待放入的元素，放入到它应该放入的位置中。
	}
	
	/**
	 * 基数排序
	 * 桶排序。
	 * 9.3号2017
	 */
	//到此八大排序全部搞定了。插希选堆，快速归推。
	public static void radixSort(int[] a,int m,int d){
		//1创建链式队列数组对象
		Queue[] myQueue = new Queue[d];
		for(int i = 0;i<d;i++){
			Queue<Integer> temp = new LinkedList<Integer>();
			myQueue[i] = temp;
		}
		//2进行m次排序
		int power = 1;
		int l = 0;
		for (int i = 0;i<a.length;i++){
			if(i==0) power = 1;
			else power*=d;
			//3依次将n个元素，按第k位的大小放入到相应的队列中。
			for(int j = 0;j<a.length;j++){
				int k=a[j]/power - (a[j]/(power*d))*d;
				myQueue[k].offer(a[j]);
			}
			
			//4顺序回收队列中的数据元素到数据a中
			for(int j = 0;j<d;j++){
				while(myQueue[j].isEmpty()){
					a[l++] = (int) myQueue[j].poll();
				}
			}
		}
	}
}
