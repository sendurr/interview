import java.util.Arrays;
import java.util.ArrayList;
class gameXORClass{
	ArrayList<Integer> result = new ArrayList<Integer>(); 
	public int getXORofArray(int[] a){
		int i,j;
		for(i=0;i<a.length;i++){
			for(j=i;j<a.length;j++){
				//System.out.print(a[j]+ " ");
				result.add(getXORSubArray(Arrays.copyOfRange(a, i, j+1)));
			}
			//System.out.println();
		}
		int xor = (int)result.get(0);
		for(i=1;i<result.size();i++){
			xor = xor^(int)result.get(i);
		}
		return xor;
	}
	
	public int getXORSubArray(int[] a){
		int xor = a[0];
		int i;
		for(i=1;i<a.length;i++){
			xor = xor^a[i];
		}
		return xor;
	}
}
public class gameXOR {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a={1,2,3};
		gameXORClass xor = new gameXORClass();
		System.out.println(xor.getXORofArray(a));

	}

}
