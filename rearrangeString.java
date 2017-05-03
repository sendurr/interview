import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Comparator;
import java.util.Map.Entry;



class rearrangeStringClass{
	HashMap<Character, Integer> freq = new HashMap<Character, Integer>();
	PriorityQueue<Entry<Character, Integer>> pq = new PriorityQueue<Entry<Character, Integer>>(new Comparator<Entry<Character, Integer>>(){
		public int compare(Entry<Character, Integer> c1, Entry<Character, Integer> c2){
			if(c1.getValue()<c2.getValue()){
				return 1;
			}else{
				return -1;
			}
		}
	});
	public String checkforrearrgstr(String s){
		if(s=="" || s==null){
			return "String is empty";
		}
		setFreqCount(s);
		int i;
		StringBuilder result = new StringBuilder(); 
		/*for(i=0;i<s.length();i++){
			pq.add(s.charAt(i));
		}*/
		Set<Entry<Character, Integer>> set = freq.entrySet();
		for(Entry<Character, Integer> c: set){
			pq.add(c);
		}
		System.out.println(pq);
		if(s.length()%2  == 0){
			if(pq.peek().getValue() > (s.length()/2)){
				return "false";
			}
		}else{
			if(pq.peek().getValue() > (s.length()/2)+1){
				return "false";
			}
		}
		Entry<Character, Integer> prevElement = pq.poll();
		result.append(prevElement.getKey());
		prevElement.setValue(prevElement.getValue()-1);

		while(!pq.isEmpty()){
			Entry<Character, Integer> currentElement = pq.poll();
			result.append(currentElement.getKey());
			currentElement.setValue(currentElement.getValue()-1);
			if(prevElement.getValue()>0){
				pq.add(prevElement);
			}
			prevElement = currentElement;
		}
		return result.toString();
	}
	
	public void setFreqCount(String s){
		char[] charc = s.toCharArray();
		for(char a: charc){
			if(!freq.containsKey(a)){
				freq.put(a, 1);
			}else{
				freq.replace(a, freq.get(a)+1);
			}
		}
	}
}
public class rearrangeString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		rearrangeStringClass str = new rearrangeStringClass();
		System.out.print(str.checkforrearrgstr("bbbabaaacd"));
	}

}
