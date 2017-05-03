class stringWork1{

    public boolean initial(String s, String t){
    
    if(Math.abs(s.length()-t.length())>1){
        return false;
        }
        
    else if(s.length()<t.length()){
           return verify(s,t);
        }

    else if(s.length()>t.length()){
           return verify(t,s);
        }
    else if(s.length()==t.length()){
    	return verifyreplace(s,t);
    }
    return false;
    }
    
    public boolean verify(String s, String t){
        boolean found = false;
        int indexS=0;
        int indexT=0;
        
        while(indexS <s.length() && indexT <t.length()){
        	if(s.charAt(indexS)!=t.charAt(indexT)){
        		if(found){
        			return false;
        		}
        		found=true;
        		indexT++;
        	}else{
        		indexS++;
        		indexT++;
        	}

        }
        return true;
    }
   
    public boolean verifyreplace(String s, String t){
        boolean found = false;
        int indexS=0;
        int indexT=0;
        
        while(indexS <s.length() && indexT <t.length()){
        	if(s.charAt(indexS)!=t.charAt(indexT)){
        		if(found){
        			return false;
        		}
        	found=true;
        	}
        	indexT++;
        	indexS++;

        }
        return true;
    }
}

class oneaway{
    public static void main (String args[]){
    	stringWork1 cc = new stringWork1();
        System.out.println(cc.initial("pale","aale"));
    
    }
}