import java.util.Arrays;
import java.util.Collections;

class permClass{
    public boolean checkperm(String s , String t){
    
    if(s.length()!=t.length()){
        return false;
        }
    
    
    char[] c= s.toCharArray();
    Arrays.sort(c);
    String ss = new String(c);
    c=t.toCharArray();
    Arrays.sort(c);
    String tt = new String(c);
    char d='a';
    //System.out.println((char)(int)d);
    if(ss.compareToIgnoreCase(tt)!=0){
        return false;
        }        
    return true;
    }
}
class twostringperm{
    public static void main(String args[]){
    
        permClass p = new permClass();
        System.out.println(p.checkperm("dog","goD"));
    
    }
}