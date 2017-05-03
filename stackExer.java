import java.util.Arrays;
import java.util.Hashtable;

public class stackExer {

	public static void main(String[] args) {
		String s ="gods  ";
		s=s.toLowerCase();
		char[] c= s.toCharArray();
		int n=9;
		prepare p = new prepare();
		while(n>=2){
			p.push(n%2);
			n=n/2;
		}
		p.push(n);

		p.print();
		
		s.replaceAll("//s+", "%20");
		s=s.trim();
		System.out.println(s.replaceAll("\\s+", "%20"));
		int count1[] = convert(c);
		/*for(int i = 0;i<count.length;i++){
			System.out.print(Character.toChars(i+97));
			 System.out.println( " -> " + count[i]);
			
		}*/
		s ="god";
		s=s.toLowerCase();
		c= s.toCharArray();
		int count2[] = convert(c);
		
		if(Math.abs((sum(count1) - sum(count2))) == 1){
			System.out.println("They are good");
		}else{
			System.out.println("Ther are false");
		}
		
		
		
		
		
	}
	
	public static int[] convert(char[] c){
		int count[] = new int[26];
		int pointer;
		for(char cc :c){
			pointer = Character.getNumericValue(cc) - Character.getNumericValue('a');
			if(pointer>=0 && pointer<26){
				count[pointer] = count[pointer] + 1;
			}
		}
		return count;
	}
	public static int sum(int[] count){
		int total = 0;
		for(int a: count){
			total = total  +a;
		}
		return total;
	}

}

 class prepare{
	
	stack top=new stack();
	
	prepare(){
		top=null;
	}
	
	void push(int c){
		stack new_node = new stack();
		new_node.c=c;
		new_node.next=top;
		top=new_node;
	}
	
	void pop(){
		top=top.next;
	}

	void print(){
		while(top!=null){
			System.out.print(top.c);
			top=top.next;
		}
	}

	void toHashTable(){
		while(top!=null){
			System.out.print(top.c);
			top=top.next;
		}
	}
	
}

class stack {
	stack next;
	int c;
}