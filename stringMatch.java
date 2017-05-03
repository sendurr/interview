
public class stringMatch {

	public static void main(String args[]){
		System.out.println(matches("w.rld", "Hello world!") );
	}
	
	public static boolean matches(String s, String ref){
	    int i;
	    if(ref.length()< s.length()){
	        return false;
	    }
	    int index; 
	    index = ref.indexOf(s.charAt(0));
	    StringBuilder sub = new StringBuilder(ref.substring(index,(index+s.length())));// s= w.rld, sub = world
	    if(sub.toString().equals(s)){
	        return true;
	    }else{
	        for(i=0;i<s.length();i++){
	            if(s.charAt(i)!=sub.toString().charAt(i) && s.charAt(i)!='.'){
	                return false;
	            }
	        }
		    return true;
	    }
	}
}
