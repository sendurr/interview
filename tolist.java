import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Enumeration;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Hashtable;



public class tolist {

	private static String yet = "testing";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sample[] ={"One","her","his","mine","Three"};
		String sample1[] ={"One","her","his","Mine","Three"};
		List<String> result = Arrays.asList(sample);
		System.out.println(result);
		
		int arr[] = {1,2,3,4,5,6};
		int resultarr[] = Arrays.copyOf(arr, 9);
		System.out.println("The original size is " + arr.length);
		System.out.println("The copied size is " + resultarr.length);

		int rangearr[] = Arrays.copyOfRange(arr, 0, arr.length);
		
		for(int i:rangearr){
			System.out.println(i +" ");
		}
		
		System.out.println("Checking if the array is equal : " +
				Arrays.deepEquals(sample, sample1)
				);
		String names[] = new String[10];
		Arrays.fill(names,"Sendurr");
		
		for(String k:names){
			System.out.print(k+" ");
		}
		
		Arrays.sort(arr);
		for(int i:arr){
			System.out.println(i +" ");
		}
		
		tolist b = new tolist();
		System.out.println(tolist.yet);
		System.out.println(b.yet);
		b.yet = "changed";
		System.out.println(tolist.yet);
		System.out.println(b.yet);
		
		MySingleton.MySingleton1();
		MySingleton.MySingleton1();
		//MySingleton c = MySingleton.getInstance();
		//c.testSingleton();
		
		//Integer a = new Integer(1);
		//System.out.println(a.floatValue());
        //System.out.println("Integer Max Value: "+Integer.MAX_VALUE);
        //System.out.println("Integer Min Value: "+Double.MIN_VALUE);
		
		//ProcessBuilder pb = new ProcessBuilder();
		//System.out.println(pb.environment());

        /*try{
            for(int i=5;i>0;i--){
                System.out.println(10/i);
            }
        } catch(Exception ex){
            //System.out.println("Exception Message: "+ex.getMessage());
            ex.printStackTrace();
        }
        
        List<samthread> list = new ArrayList<samthread>();
        for(int i=0;i<5;i++){
        	samthread s = new samthread(i);
        	list.add(s);
        	s.start();
        }
        for (samthread j:list){
    		try {
    			j.join();			
    		}catch(Exception e){
    			
    		}
        }*/
		
		simpleGenric<String> p = new simpleGenric<String>("This is mine");
		p.gettype();
		//List<String> str = new ArrayList<String>();
		Vector<String> str = new Vector<String>();
		str.add("One");
		str.add("Two");
		str.add("Three");
		str.add("Four");
		Collections.sort(str);
		System.out.println("The size of the vector is : " + str.size());
		//Iterator<String> bb = str.iterator();
		Enumeration<String> bb = str.elements();
		while(bb.hasMoreElements()){
			System.out.println(bb.nextElement());
		}
		LinkedList<String> ll = new LinkedList<String>();
		ll.add("Sendurr");
		ll.add("Sachin");
		//System.out.println(ll.getFirst());
		ll.addFirst("Dad");
		//System.out.println(ll.getFirst());
		ll.offerLast("Mom");
		//System.out.println(ll.getLast());
		System.out.println(ll);
		ListIterator<String> j = ll.listIterator(); 
		System.out.println("Printing in reverse!");
		while(j.hasPrevious()){
			System.out.println(j.previous());
		}
		Hashtable<String, String> ht = new Hashtable<String,String>();
		ht.put("1", "One");
		ht.put("1", "One");
		System.out.println(ht);
		
		String pj ="add sendurr";
		String[] pjArray = pj.split("\\W+");
		System.out.println(pjArray[1]);

		
	}

}

class simpleGenric<T>{
	private T objectReff = null;
	
	simpleGenric(T parm){
		this.objectReff = parm;
	}
	
	public T getObjRef(){
		return this.objectReff;
	}
	
	public void gettype(){
		System.out.println("The type is : " + getObjRef().getClass().getName());
	}
}


class samthread extends Thread{
	int time;
	public samthread(int i){
		this.time=100*i;
	}
	public void run(){
		System.out.println("Thread "+getName()+ " started...");
		try {
			Thread.sleep(this.time);
			System.out.println("Thread "+getName()+ " ended...");			
		}catch(Exception e){
			
		}

	}
}

class MySingleton{
    
    private static MySingleton instance;
     
    static{
        instance = new MySingleton();
    }
     
    private MySingleton(){
        System.out.println("Creating MySingleton object...");
    }

    public static void MySingleton1(){
        System.out.println("Creating MySingleton object1...");
    }
     
    public static MySingleton getInstance(){
        return instance;
    }
     
    public void testSingleton(){
        System.out.println("Hey.... Instance got created...");
    }
}

