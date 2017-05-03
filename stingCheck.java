import java.util.ArrayList;
import java.util.List;

class check{

    public boolean isUnique(String s){
    boolean[] table = new boolean[128];
    if(s.length()>128){
        return false;
        }
    for(int i=0;i<s.length();i++){
        int point = s.charAt(i);
        if(table[point]){
            return false;
            }
        else{
            table[point]=true;
            }
        }
    return true;
    }

}

class stingCheck{
    public static void main(String args[]){
        check c = new check();
        String s="sendur";
        System.out.println("Is string "+ s + " unique? " + c.isUnique(s));
        
    }
}
