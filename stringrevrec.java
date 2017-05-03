import java.util.Collections;
import java.util.Stack;

class stringClass{

    public String stringrev(String s){
        if(s=="" || s==null){
            System.out.print("String is empty.");
            return s;
        }else{
            //char[] input = s.toCharArray();
            return stringrevHelper(s,0);
        }
    }
    
    public String stringrevHelper(String s,int index){
        if(index == s.length()-1){
            return ("" + s.charAt(index));

        }else{
            return (stringrevHelper(s,index+1)+s.charAt(index));
        }
    }
}

class stringrevrec{
    public static void main (String args[]){
        String b = new String("maM");
        System.out.println(new stringClass().stringrev(b));
        StringBuilder cc = new StringBuilder(b);
        StringBuilder bb = cc.reverse();
        System.out.println("using stringbuilder " + bb);
        int n = Integer.parseInt("1234");
        //n= Integer.reverse(n);
        //Integer.to
        System.out.println("" + n);
        //Collections.re
        if(b.compareToIgnoreCase(cc.toString())==0){
        	System.out.println("They are equal!");
        }
        System.out.println((int)'a');
        System.out.println(Integer.toString(65));
        cc.append((char)65);
        System.out.println((char)65);
        System.out.println(cc);
    }
}