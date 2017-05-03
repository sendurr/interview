import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

class transform{
    mttree root = new mttree();
    ArrayList<LinkedList<mttree>> list = new ArrayList<LinkedList<mttree>>(); 
    
    
    public transform(){
        root = null;
    }
    
    public mttree callarrayToMt(int[] a){
        root = arrayToMt(a,0,a.length-1);
        //System.out.println(root.right.data);
        return root;
    }

    public mttree arrayToMt(int[] a, int start,int end){
        if(start>end){
        	mttree node =null;
            return node;
        }
        mttree node = new mttree();
        int mid=start+((end-start)/2);
        node.data=a[mid];
        //System.out.println(node.data + "->" + mid);
        node.left = arrayToMt(a,start,mid-1);
        node.right = arrayToMt(a,mid+1,end);
        return node;
    }
    
    public void display(mttree root){
        if(root!=null){
            display(root.left);
            System.out.print(root.data+"->");
            display(root.right);
            //System.out.println();
        }
    }
    
    public void linkedlistDepth(int level, mttree root){
        if(root!=null){
        	if(level==list.size()){
        		LinkedList<mttree> sublist = new LinkedList<mttree>();
        		list.add(sublist);
        	}
        	LinkedList<mttree> temp = list.remove(level);
        	temp.add(root);
        	list.add(level, temp);
        	linkedlistDepth(level+1,root.left);
        	linkedlistDepth(level+1,root.right);
        	
        }
    	
    }
    
    public void displayList(){
    	for(LinkedList<mttree> sublist:list){
    		for(mttree node: sublist){
    			System.out.print(node.data+"->");
    		}
    		System.out.println();
    	}
    }
    
    public boolean checkBal(){
    	int result = helperBal(root);
    	if(result!=-2){
    		System.out.println(result);
    		return true;
    	}else{
    		return false;
    	}
    }
    
    public int helperBal(mttree root){
    	if(root==null){
    		return -1;
    	}
    	int left=helperBal(root.left);
    	if(left==-2 || helperBal(root.right)==-2){
    		return -2;
    	}
    	else if(left == helperBal(root.right)){
    		return (left+1);
    	}else{
    		return -2;
    	}
    }

    public boolean checkBST(mttree root){
    	if(root ==null){
    		return false;
    	}
    	if(root.right!=null){
    		if(checkBST(root.right)){
    			if(root.data<root.right.data){
    		    	if(root.left!=null){
    		    		if(checkBST(root.left)){
    		    			if(root.data>root.left.data){
    		    				return true;
    		    			}
    		    			return false;
    		    		}
    		    	}
    			}
    			return false;
    		}
    	}

    	return true;
    }

    public boolean checkBSTNew(mttree root){
    	int max,min;
    	if(root.left==null && root.right==null){
    		return true;
    	}else if(root.left!=null && root.right!=null){
    		if(checkBSTNew(root.left) && checkBSTNew(root.right)){
    			if(isSubtreeBst(root)){
    				return true;
    			}else{
    				return false;
    			}
    		}else{
    			return false;
    		}
    	}else if(root.left!=null){
    		if(checkBSTNew(root.left)){
    	    	if(root.data<root.left.data){
    	    		return false;
    	    	}
    	    	return true;
    		}else{
    			return false;
    		}
    	
		}else if(root.right!=null){
			if(checkBSTNew(root.right)){
		    	if(root.data>root.right.data){
		    		return false;
		    	}
		    	return true;
			}else{
				return false;
			}
		}
    	return true;
    	
    }
    
    public boolean isSubtreeBst(mttree node){
    	if(root.data<root.left.data){
    		return false;
    	}else if(root.data>root.right.data){
    		return false;
    	}
    	return true;
    }
    
    public int successor(mttree root){
    	if(root==null){
    		System.out.println("The tree is empty!");
    		return Integer.MAX_VALUE;
    	}
    	if(root.right==null){
    		System.out.println("No Successor!");
    		return Integer.MAX_VALUE;    		
    	}else{
    		return minNode(root.right);
    	}
    }
    
    public int minNode(mttree root){
    	if(root.left==null){
    		return root.data;
    	}else{
    		return  minNode(root.left);
    	}
    }

}

class mttree{
    mttree left;
    mttree right;
    int data;
}

class minimalree{
    public static void main(String args[]){
        int[] a={1,2,33,2,3,4,5,5};
        transform t= new transform();
        t.callarrayToMt(a);
        t.display(t.root);
        t.linkedlistDepth(0, t.root);
        t.displayList();
        System.out.println(t.checkBal());
        System.out.println(t.checkBST(t.root));
        System.out.println(t.successor(t.root));
        String s = new String();
        Random r = new Random();
        Scanner sr = new Scanner(System.in);
        /*curl -i -H "Content-Type: application/json" -X POST -d "{'first_name':Sendurr','last_name':'Selvaraj','email':'sendurr@hotmail.com','phone':'6506600957','urls':['https://www.linkedin.com/in/sendurr-selvaraj-92b4291a/','https://github.com/sendurr','https://play.google.com/store/apps/details?id=com.truckdeal.sendurr2208','http://www.magicandgift.com/'],'cover_letter'='https://play.google.com/store/apps/details?id=com.truckdeal.sendurr2208'}" https://app.close.io/hackwithus/
        		Send an HTTP POST request with JSON to  with the following string fields: ‘’, ‘’, ‘’, ‘’, and ‘’, as well as ‘urls’ which should be a a list with any URLs you’d like to share with us (e.g. resume, github, side projects, twitter, etc.). Be sure that you receive a 200 OK and paste the returned 'id' here. If you get a 403 then try again without sending any Cookie header.
        */
        System.out.println("Is it BST = " + t.checkBSTNew(t.root));
    
    }
}