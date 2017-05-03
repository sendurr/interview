

class stringRotateClass{
    public boolean checkString(String a, String b){
        if(checkStringClock(a,b)){
            return true;
        }else{
            return checkStringAntiClock(a,b);
        }
    
    }
    public boolean checkStringClock(String a, String b){
    	StringBuilder a1 = new StringBuilder( a.substring(0,a.length()-2));
        StringBuilder a2 = new StringBuilder(a.substring(a.length()-2));
        //a2.reverse();
        //System.out.println(a1);
        //System.out.println(a2);
        a2.append(a1);
        return b.equals(a2.toString());
    }
    public boolean checkStringAntiClock(String a, String b){
    	StringBuilder a1 = new StringBuilder(a.substring(2));
    	StringBuilder a2 = new StringBuilder(a.substring(0,2));
        //a2.reverse();
        a1.append(a2);
        return b.equals(a1.toString());
    }
}
class stringRotate{
    public static void main(String args[]){
        stringRotateClass ss = new stringRotateClass();
        System.out.println(ss.checkString("amazon","onamaz"));
    }
}