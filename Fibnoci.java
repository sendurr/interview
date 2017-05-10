import java.util.HashMap;
class fibClass{
	
	private HashMap<Integer,Integer> hashFib = new HashMap<Integer,Integer>(); 
	public void genFibHeleper(int n){
		int i=1;
		while(i<=n){
			System.out.print(genFib(i)+",");
			i++;
		}
		
	}
	public int genFib(int n){
		if(n==1){
			return 0;
		}else if(n==2){
			return 1;
		}else{ 
			int value1 , value2;
			if(hashFib.containsKey(n-1)){
				value1 = hashFib.get(n-1);
				hashFib.put(n-1, value1);
			}else{
				value1 = genFib(n-1);
			}
			if(hashFib.containsKey(n-2)){
				value2 = hashFib.get(n-2);
				hashFib.put(n-1, value2);
			}else{
				value2 = genFib(n-2);
			}
			return genFib(n-1) + genFib(n-2);
		}
		
	} 
	
}
public class Fibnoci {

	public static void main(String[] args) {
		fibClass fib = new fibClass();
		fib.genFibHeleper(15);

	}

}
