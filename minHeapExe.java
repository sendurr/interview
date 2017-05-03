class minHeap{

    leaf1 root = new leaf1();
    
    public minHeap(){
        //root=null;
    }

    public void buildMinHeap(int[] a){
        this.root = buildMinHeapHelper(a,0);
    
    }
    
    public leaf1 buildMinHeapHelper(int[] a, int index){
    	leaf1 node = new leaf1();
    	if(index>=a.length){
            node =null;
            return node;
        }else{
        	System.out.println(a[index]);
        	node.data=a[index];
            node.left= buildMinHeapHelper(a,(2*index)+1);
            node.right= buildMinHeapHelper(a,(2*index)+2);
            return node;
        }
    
    }
    
    
    public int getMax(){
    	if(root==null){
    		System.out.println("Tree empty!");
    		return Integer.MIN_VALUE;
    	}else{
    		return getMax(this.root);
    	}
    
    }
    
    public int getMax(leaf1 root){
    	if(root.left==null && root.right==null){
    		return root.data;
    	}else if(root.right==null){
    		return getMax(root.left);
    	}else{
    		if(getDepth(root.left)>getDepth(root.right)){
    			return getMax(root.left);
    		}else{
    			return getMax(root.right);
    		}
    	}
    
    }
    
    public void display(){
        display(this.root);
    }
    
    public void display(leaf1 root){
        if(root==null){
            return;
        }
        else{
            System.out.print(root.data+ "->");
            display(root.left);
            display(root.right);
        }
    }
    
    public int getDepth(leaf1 root){
    	if(root==null){
    		return 0;
    	}else{
    		return Math.max(getDepth(root.left), getDepth(root.right))+1;
    	}
    }
}

class leaf1{
    int data;
    leaf1 right;
    leaf1 left;
}

class minHeapExe{

    public static void main(String args[]){
        minHeap heap = new minHeap();
        int[] a={1,2,3,4,5,6,7,8,9,10,14};
        heap.buildMinHeap(a);
        heap.display();
        System.out.println();
        System.out.println("Max= "+heap.getMax());
    
    }
}