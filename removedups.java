import java.util.HashSet;

class building{
    
    node1 head =new node1();
    HashSet<String> hs = new HashSet<String>();
    
    public building(){
        head=null;
    }
    
    public void add(String data){
        node1 current =new node1();
        current.data=data;
        current.next=head;
        head=current;
    }
    
    public void delete(){
        if(head==null){
            System.out.println("List is Empty");
        }else{
        	head=head.next;
        }
    }
    
    public void display(){
        if(head==null){
            System.out.println("List is Empty");
        }else{
        	node1 pointer = head;
	        while(pointer!=null){
	            System.out.print(pointer.data+"->");
	            pointer=pointer.next;
	        }
        }
        System.out.println();
        
    }
    
    public void removeDupList(){
        if(head==null){
            System.out.println("List is Empty");
        }else{
        	node1 pointer = head;
	        while(pointer!=null){
	        	node1 previous = pointer;
	        	node1 ref = pointer.next;
	        	while(ref!=null){
	        		if(ref.data.equals(pointer.data)){
	        			previous.next=ref.next;
	        		}
	        		ref=ref.next;
	        	    previous=pointer;
	        	}
	        	pointer=pointer.next;
	        }
        }
        System.out.println();
    }
    
    public void removeDup(){
        if(head==null){
            System.out.println("List is Empty");
        }else{
        	node1 pointer = head;
	        while(pointer!=null){
	        	if(!hs.contains(pointer.data)){
	        		hs.add(pointer.data);
	        	}
	        	pointer=pointer.next;
	        }
        }
        System.out.println();
    }

    public void displayHashSet(){
        if(hs.size()==0){
            System.out.println("HashSet is Empty");
        }else{
        	for(String set:hs){
        		System.out.print(set+"->");
        	}
        }
        System.out.println();
    }
    
    public String getKthElement(int k){
    	node2 start = new node2();
    	start.node = head;
    	start=loopThru(start,k);
    	if(start.foundDdata=="" || start.foundDdata==null){
    		return "Incorect Kth position";
    	}
    	return start.foundDdata;
    }
    
    public node2 loopThru(node2 pointer, int k){
    	if(pointer.node==null){
    		pointer.length=-1;
    		return pointer;
    	}
    	node2 current = new node2();
    	current.node=pointer.node.next;
    	current=loopThru(current,k);
    	pointer.length=current.length+1;
    	System.out.println(pointer.length+"->"+pointer.node.data);
    	if(pointer.length==k){
    		pointer.foundDdata=	current.node.data;
    	}
    	if(pointer.length>k){
    		pointer.foundDdata=	current.foundDdata;
    	}
    	return pointer;
    }
    
    public void deleteMiddle(){
    	node1 node = head;
    	if(node.next==null){
    		System.out.println("This is the last node!");
    	}
    	node.data=node.next.data;
    	node.next=node.next.next;
    	head=node;
    }
    
    public void sort(String s){
    	node1 node = head;
    	node1 sortedHead = null;
    	node1 sortedTail = sortedHead;
    	while(node!=null){
    		if(node.data.compareTo(s)<0){
    			node1 freshsnode = new node1();
    			freshsnode.data = node.data;
    			freshsnode.next=sortedHead;
    			sortedHead=freshsnode;
    		}
    		else if(node.data.compareTo(s)>=0){
    			/*if(sortedTail==null){
    				//System.out.println(node.data);
    				sortedTail.data=node.data;
    				sortedTail.next=null;
    			}else{*/
    				node1 freshsnode = new node1();
    				freshsnode.data=node.data;
    				freshsnode.next=null;
    				if(sortedTail!=null){
        				sortedTail.next=freshsnode;
    				}
					sortedTail=freshsnode;
    			//}
    		}
    		node=node.next;
    	}
    	head=sortedHead;
    }
    
}

class node1{
    node1 next;
    String data;
}

class node2{
    node1 node;
    String foundDdata;
    int length;
}

class removedups{

    public static void main(String args[]){
        building b= new building();
        b.displayHashSet();
        b.display();
        b.add("One");
        b.add("To");
        b.add("five");
        b.add("three");
        b.add("three");
        b.add("three");
        b.display();
        b.delete();
        b.removeDupList();
        b.display();
        b.add("three");
        b.add("eight");
        b.add("hundred");
        b.add("thoudsand");
        b.add("zero");
        b.add("seven");
        b.display();
        b.removeDup();
        b.displayHashSet();
        int k=13;
        System.out.println("The "+k+"th element of the list is "+b.getKthElement(k));
        b.deleteMiddle();
        b.display();
        b.sort("five");
        b.display();
        
    
    }
}