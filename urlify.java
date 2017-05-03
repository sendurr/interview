class characters{

    public String replace(String s){
    
        s=s.trim();
        String ss = s.replaceAll("\\s+","%20");
        return ss;
    }

}

class urlify{
    public static void main(String args[]){
    	characters cc = new characters();
        System.out.println(cc.replace("Mr John  Smith  "));
    
    
    }
}