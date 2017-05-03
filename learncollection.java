import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.Iterator;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;


public class learncollection {

	public static void main(String[] args) {
		HashSet<emp> hs = new HashSet<emp>();
		hs.add(new emp("Sendurr",123));
		hs.add(new emp("Sendurr2",1231));
		hs.add(new emp("Sendurr3",1232));
		hs.add(new emp("Sendurr4",1233));
		for (emp i:hs){
			System.out.println("Name = "+ i.getName());
		}
		emp t = new emp("Sendurr4",1233);
		System.out.println("Does set contains key? "+hs.contains(t));
		System.out.println("REmoving key? "+hs.remove(t));
		System.out.println("Does set contains key? "+hs.contains(t));
		
		TreeSet<String> tr = new TreeSet<String>();
		List<String> str = new ArrayList<String>();
		str.add("One");
		str.add("two");
		str.add("b");
		str.add("1");
		str.add("1");
		Iterator<String> i = str.iterator();
		while(i.hasNext()){
			//System.out.println(i.next());
			System.out.println(tr.add(i.next()));
		}
		System.out.println(tr);
		
		Date dt = new Date();
		SimpleDateFormat df = new SimpleDateFormat("DD.MM.YYYY");
		System.out.println("The current date is " + df.format(dt));
		try{
			Date dt1 = df.parse("01.02.2017");
			SimpleDateFormat df1 = new SimpleDateFormat("MM.DD.YYYY");
			System.out.println("The current date is " + df1.format(dt1));
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Invalid date!");}
		
		Scanner yt = new Scanner(System.in);
		System.out.println(yt.nextInt());
		System.out.println(yt.nextInt());
		System.out.println(yt.next());
	}

}

class emp{
	private String name;
	private int id;
	
	emp(String name , int id){
		this.name=name;
		this.id=id;
	}
	
	public String getName(){
		return this.name;
	}
	
	public int getId(){
		return this.id;
	}
	
	public int hashCode(){
		return this.getId();
	}
	
	public boolean equals(Object obj){
		emp e =null;
		if(obj instanceof emp){
			e=(emp) obj;
			if(e.name.equals(this.name) && (e.id == this.id)){
				return true;
			}
			else{
				return false;
			}
		}else{
			return false;
		}
	}
}
