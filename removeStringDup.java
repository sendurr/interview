import java.util.HashMap;
import java.util.Set;
import java.util.Map.Entry;

class stringClass1{
    
    HashMap<String, Integer> hm = new HashMap<String, Integer>();
    
    public void unigString(String s){
        int i=0;
        while(i<s.length()){
            if(!hm.containsKey(s.charAt(i))){
                hm.put(""+s.charAt(i),0);
                i++;
            }
        }
        
        System.out.println("Printing unique chars");
        Set<Entry<String, Integer>> ss = hm.entrySet();
        for(Entry<String, Integer> set: ss){
            System.out.print(set.getKey());
        }
        System.out.println();
        System.out.println("Printing unique chars");
        Set<String> ss1 = hm.keySet();
        for(String set: ss1){
            System.out.print(set);
        }
    }
}

class removeStringDup{
    public static void main(String args[]){
    	stringClass1 ss = new stringClass1();
        ss.unigString("mama");
    }
}