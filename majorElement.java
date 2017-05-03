import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.Collections;

class majority{
    HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
    int majorKey, majorCount=0;
    public void major(int[] a){
        for(int i: a){
            if(hm.containsKey(i)){
                hm.replace(i,hm.get(i)+1);
            }else{
                hm.put(i,1);
            }
            if(majorCount<hm.get(i)){
            	majorCount = hm.get(i);
            	majorKey = i;
            }
        }
        
        Set<Integer> set = hm.keySet();
        for(Integer key: set){
            System.out.println(key + " = " + hm.get(key));
        }
        System.out.println("Max number , " + majorKey + " = " + majorCount);
    }
}

class majorElement{

    public static void main(String args[]){
        int[] a= {3,4,2,4,4,2,4,4};
        majority mm = new majority();
        mm.major(a);
        Scanner ip = new Scanner(System.in);

    
    }
}