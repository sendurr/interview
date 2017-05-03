import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

class find{
	
	List<Integer> sam=null;
	
	find(List<Integer> sam){
		this.sam = sam;
	}
	
	public boolean loop(){
		int center = sam.size()/2;
		int left =center;
		int right = center;
		int leftSum , rightSum;
		while(left>0 || right <sam.size()){
			leftSum = getSum(sam.subList(0, left));
			rightSum = getSum(sam.subList(right+1, sam.size()));
			System.out.println("Left = " + leftSum);
			System.out.println("Right = " + rightSum);
			if(leftSum == rightSum){
				return true;
			}
		}

		
		return false;
	}
	
	public int getSum(List<Integer> sub){
		int sum = 0;
		Iterator<Integer> t = (sub.iterator());
		while(t.hasNext()){
			sum+= (int)t.next();
		}
		return sum;
		
	}
}

public class midnum {

	public static void main(String[] args) {
		List<Integer> sam = new ArrayList<Integer>();
		sam.add(1);
		sam.add(2);
		sam.add(1);
		sam.add(1);
		sam.add(2);
		find f = new find(sam);
		//System.out.println(f.loop());
		
		Integer x;
		System.out.println(x.toBinaryString(100));
		Integer.MIN_VALUE
	}

}
