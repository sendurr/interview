import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//ArrayList<Integer> input = new ArrayList<Integer>();
		//TreeSet<Integer> input = new TreeSet<Integer>(); 
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
		Scanner ip = new Scanner(System.in);
		//int n = ip.nextInt();
		int temp=0;
		int[] a={5,15,1,3};
		int n = a.length;
		while(temp<n){
			minHeap.add(a[temp]);
			maxHeap.add(minHeap.poll());
			if((temp+1)%2!=0){
				minHeap.add(maxHeap.poll());
				System.out.println(minHeap.peek());
			}else{
				//maxHeap.add(a[temp]);
				int median = (minHeap.peek() + maxHeap.peek())/2;
				System.out.println(median);
			}
		    temp++;
		}
	}
}