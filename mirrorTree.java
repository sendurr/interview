import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
class mirrorTreeClass implements Comparator<Integer>{
	
	public node3 root;
	
	public mirrorTreeClass(){
		root = new node3();
		root.left=null;
		root.right=null;
	}
	
	public void display(node3 node){
		if(node==null){
			return;
		}
		else{
			display(node.left);
			System.out.println(node.data+ " ");
			display(node.right);
		}
	}
	
	public boolean checkMirror(node3 a , node3 b){
		if(a==null && b== null){
			return true;
		}else{
			return checkMirrorHelper(a,b);
		}
	}

	public boolean checkMirrorHelper(node3 a , node3 b){
		if(a.data==b.data && a.left==null && b.left==null && a.right==null && b.right==null){
			return true;
		}else if(a.left!=null && b.left!=null && a.right!=null && b.right!=null){
			return (checkMirrorHelper(a.left,b.right) && checkMirrorHelper(a.right,b.left) && a.data==b.data);
		}else if(a.left!=null && b.right!=null && a.right==null && b.left==null){
			return (checkMirrorHelper(a.left,b.right) && a.data==b.data);
		}else if(b.left!=null && a.right!=null && b.right==null && a.left==null){
			return (checkMirrorHelper(a.right,b.left) && a.data==b.data);
		}else{
			return false;
		}
		
	}

	@Override
	public int compare(Integer o1, Integer o2) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
class node3{
	int data;
	node3 left;
	node3 right;
	public node3(){
		
	}
	public node3(int data){
		this.data=data;
		this.left=null;
		this.right=null;
	}
}
public class mirrorTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		mirrorTreeClass a = new mirrorTreeClass();
		mirrorTreeClass b = new mirrorTreeClass();
		a.root.data = 1;
		b.root.data = 1;

		node3 childa1 = new node3(2);
		a.root.left=childa1;
		node3 childa2 = new node3(3);
		a.root.right = childa2;
		
		/*node3 childb1 = new node3(3);
		b.root.left=childb1;
		node3 childb2 = new node3(2);
		b.root.right = childb2;*/

		a.display(a.root);
		System.out.println();
		b.display(b.root);
		System.out.println(a.checkMirror(a.root, b.root));
		ArrayList<Integer> temp = new ArrayList<Integer>();
		Collections.reverse(temp);
		Iterator<Integer> it = temp.iterator();



	}

}
