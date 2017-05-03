class comparestring{

    public String convert(String s){
    if (s.length()==0 || s==null){
        return null;
        }
    char prev=s.charAt(0);
    int count=0,i;
    String result = "";
    result = result + prev;
    for(i=0; i<s.length();i++){
        if(prev==s.charAt(i)){
            count++;
            }
        else{
			prev=s.charAt(i);
            result = result + count;
            result = result + s.charAt(i);
            count=1;
        	}
    	}
    result = result + count;
    if(result.length()<s.length()){
        return result;
    	}
    //s.replaceAll("\\d+", "a");

    return s;
    }
}

class StringComp{
    public static void main(String args[]){
        comparestring cc = new comparestring();
        System.out.println(cc.convert("abccccccccccca"));
    
    
    }
}