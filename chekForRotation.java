class rotationMine{

    public boolean rotate(String s, String t){
        if(s.length()!=t.length()){
            return false;
        }
        else{
            if((s+s).indexOf(t)!=-1){
                return true;
            }else{
                return false;
            }
        }      
    }
}
class chekForRotation{

    public static void main(String args[]){
    
    	rotationMine r= new rotationMine();
        System.out.println(r.rotate("wateeerbottle","bottlewater"));
        
    }
}