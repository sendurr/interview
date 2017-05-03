import java.util.ArrayList;

class stringFactory{

    public ArrayList<String> permute(String s){
        ArrayList<String> res = new ArrayList<String>();
        if(s.length()==1){
            res.add(s);
            return res;
        }else if(s.length()> 1){
            int lastIndex = s.length()-1;
            String last = s.substring(lastIndex);
            String rest = s.substring(0,lastIndex);
            res = merge(permute(rest),last);
            //res.addAll(merge(permute(rest),last));
        }
    
    return res;
    }
    
    public ArrayList<String> merge(ArrayList<String> half, String c){
            ArrayList<String> res = new ArrayList<String>();
            int i;
            res.addAll(half);
            res.add(c);
            for(String s: half){
                for(i=0;i<=s.length();i++){
                    String complete = new StringBuffer(s).insert(i, c).toString();
                    res.add(complete);
                }
            }
        return res;
    }
}
class stringPerm{

    public static void main(String args[]){
        stringFactory fac = new stringFactory();
        ArrayList<String> permuted = fac.permute("fun");
        for(String s: permuted){
            System.out.println(s);
        }
        
    
    }
}