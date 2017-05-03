import java.util.Hashtable;
class Binary{

    public int countOfBinary(int[] a){
        int max=0;
        boolean found=false;
        Hashtable<Integer,Integer> ht = new Hashtable<Integer,Integer>();
        for(int i: a){
        	if(!found && i==1){
        		found =true;
        		ht.put(i, 1);
        		max=1;
        	}
        	else if(i==1){
                if(ht.containsKey(i)){
                    ht.replace(i, ht.get(i)+1);
                    max=ht.get(i);
                }
            }else{
                ht.clear();
                found=false;
            }
        }
        return max;
    }
}

class conseBinary{

    public static void main(String args[]){
    	Binary binary = new Binary();
        int[] a={0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1};
        System.out.println(binary.countOfBinary(a));
    
    }
}