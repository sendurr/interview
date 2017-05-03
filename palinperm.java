class stringWork{

    public boolean check(String s){
    
        s = s.toLowerCase();
        int[] table = stringToArray(s);
        boolean found=false;
        for(int i: table){
            if(i%2!=0){
                if(found){
                    return false;
                }
                found=true;
            }
        }
        return true;
    }
    
    public int[] stringToArray(String s){
        int[] table= new int[26];
        for(char c: s.toCharArray()){
        int asci = (int)c;
        if(asci>=97 && asci<=122){
            table[asci-97]++;
            }
        }
        return table;
    }

}

class palinperm{
    public static void main(String args[]){
        stringWork cc = new stringWork();
        System.out.println(cc.check("mama"));
    
    
    }
}