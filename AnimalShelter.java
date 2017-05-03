import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Iterator;

class animal{
    String type="";
    dog d= new dog();
    cat c = new cat();
}

class dog {
    String name;
    String type;
    public  dog(){

    }
    public  dog(String name, String type){
        this.name=name;
        this.type=type;
    }
    public void details(String name, String type){
        this.name=name;
        this.type=type;
    }
    public void run(){
        System.out.println("The dog is running");
    }
}



class cat{
    String name;
    String type;
    
    public  cat(String name, String type){
        this.name=name;
        this.type=type;
    }
    public  cat(){

    }

    public void details(String name, String type){
        this.name=name;
        this.type=type;
    }
    public void jump(){
        System.out.println("The cat is jumping");
    }
}


class adoptAnimal{
    
    Queue<animal> q= new LinkedList<animal>();
    
    public void enqueDog(dog d){
        animal a = new animal();
        a.type="Dog";
        a.d=d;
        q.add(a);
    }

    public void enqueCat(cat c){
        animal a = new animal();
        a.type="Cat";
        a.c=c;
        q.add(a);
    }
    
    public animal dequeueAny(){
        return q.remove();
    }
    
    public animal dequeueDog(){
        boolean found=false;
        animal b = new animal();
        if(q.isEmpty()){
            System.out.println("Ther shelter is empty!");
        }
        Queue<animal> temp = new LinkedList<animal>();
        while(!q.isEmpty()){
            
            if(q.peek().type=="Dog" && !found){
                b=q.remove();
                found=true;
            }else{
                temp.add(q.remove());
            }
        }
        q=temp;
        return b;
        
    }

    public animal dequeueCat(){
        boolean found=false;
        animal b = new animal();
        if(q.isEmpty()){
            System.out.println("Ther shelter is empty!");
        }
        Queue<animal> temp = new LinkedList<animal>();
        while(!q.isEmpty()){
            
            if(q.peek().type=="Cat" && !found){
                b=q.remove();
                found=true;
            }else{
                temp.add(q.remove());
            }
        }
        q=temp;
        return b;
        
    }

    public void display(){
    
        Iterator<animal> t= q.iterator();
        while(t.hasNext()){
            animal ref = t.next();
            if(ref.type=="Cat"){
            	System.out.println(ref.c.name +"->"+ref.c.type);
            }else{
            	System.out.println(ref.d.name +"->"+ref.d.type);
            }
        }
    }
    
}

class AnimalShelter{
    public static void main(String args[]){
        adoptAnimal adopt = new adoptAnimal();
        adopt.enqueDog(new dog("siberia","Dog"));
        adopt.enqueDog(new dog("high","Dog"));
        adopt.enqueDog(new dog("five","Dog"));
        adopt.enqueCat(new cat("tom","Cat"));
        adopt.enqueCat(new cat("jerry","Cat"));
        adopt.enqueDog(new dog("husky","Dog")); 
        adopt.display();
        System.out.println();
        System.out.println(adopt.dequeueCat().c.name);
        System.out.println();
        adopt.display();
        System.out.println(adopt.dequeueDog().d.name);
        System.out.println();
        adopt.display();
        System.out.println();
        System.out.println(adopt.dequeueAny().d.name);
        System.out.println();
        System.out.println();
        adopt.display();
        LinkedList<String> q = new LinkedList<String>();


        
    
    }
}
