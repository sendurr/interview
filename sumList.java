import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


class LinkedListOperations{
    
    LinkedListNode head = new LinkedListNode();
    
    public LinkedListOperations(){
        head=null;
    }

    public void add(int data){
        LinkedListNode node = new LinkedListNode();
        node.data=data;
        node.next=head;
        head=node;
    }
    
    public void delete(){
        if(head==null){
            System.out.println("The list is empty!");
        }else{
            head=head.next;
        }
    }


    public void display(){
        if(head==null){
            System.out.println("The list is empty!");
        }else{
            LinkedListNode node = head;
            while(node!=null){
                System.out.print(node.data+"->");
                node=node.next;
            }
        }
    }

    public void sum(LinkedListOperations l1,LinkedListOperations l2){
    	int carry = 0;
    	LinkedListNode currentNode = new LinkedListNode();
    	LinkedListNode node1 = l1.head;
    	LinkedListNode node2 = l2.head;
    	if(node1==null && node2==null){
    		System.out.println("Both the linkedlist is empty!");
    	}

    	while(node1!=null && node2!=null){
            LinkedListNode node = new LinkedListNode();
            node.data=node1.data+node2.data+carry;
            if(node.data>=10){
            	node.data=node.data%10;
            	carry=1;
            }else{
            	carry=0;
            }
            if(head==null){
            //	System.out.println("1");
            	currentNode=node;
            	head=currentNode;
            }else{
            	//System.out.println("2");
            	currentNode.next=node;
            	currentNode=node;
            }
            node1=node1.next;
            node2=node2.next;
            
    	}
    	if(node1==null){
    		while(node2!=null){
                LinkedListNode node = new LinkedListNode();
                node.data=+node2.data+carry;
                if(node.data>=10){
                	node.data=node.data%10;
                	carry=1;
                }else{
                	carry=0;
                }
                if(head==null){
                	currentNode=node;
                	head=currentNode;
                }else{
                	currentNode.next=node;
                	currentNode=node;
                }
                node2=node2.next;
    		}    		
    	}
    	else if(node2==null){
    		while(node1!=null){
                LinkedListNode node = new LinkedListNode();
                node.data=+node1.data+carry;
                if(node.data>=10){
                	node.data=node.data%10;
                	carry=1;
                }else{
                	carry=0;
                }
                if(head==null){
                	currentNode=node;
                	head=currentNode;
                }else{
                	currentNode.next=node;
                	currentNode=node;
                }
                node1=node1.next;
    		}    		
    	}
    	if(carry==1){
            LinkedListNode node = new LinkedListNode();
            node.data=carry;
            carry=0;
            head.next=null;
    	}
    }
}

class LinkedListNode{

    LinkedListNode next;
    int data;

}
class sumList{

    public static void main(String args[]){
        LinkedListOperations l1 = new LinkedListOperations();
        l1.add(6);
        l1.add(1);
        l1.add(7);
        l1.display();
        System.out.println();
        LinkedListOperations l2 = new LinkedListOperations();
        l2.add(9);
        l2.add(9);
        l2.add(5);
        l2.add(5);
        l2.display();
        System.out.println();
        LinkedListOperations l3 = new LinkedListOperations();
        l3.sum(l1,l2);
        l3.display();
        Stack<String> k = new Stack<String>();
        Queue<String> q  = new LinkedList<String>();
        

    }
}

