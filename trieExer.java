import java.util.HashMap;
import java.util.Set;
class dictionary{

    Trie root;
    public dictionary(){
    	root  =new Trie();
        root.data="";
        root.isLeaf=true;
    }
    
    public void buildDictionary(String s){
        root = buildChild(this.root,s);
    }
    
    public Trie buildChild(Trie head,String s){
        int i;
        if(s.length()==0){
            head.isLeaf=true;
        }
        else{
            head.isLeaf=false;
        }
        for(i=0;i<s.length();i++){
            Trie child = new Trie();
            child.data = head.data+s.charAt(i);
            child=buildChild(child,s.substring(0,i)+s.substring(i+1));
            head.hmp.put(""+s.charAt(i),child);
            
        }
        return head;        
    }

    public void display(){
    	display(this.root);
    }
    
    public void display(Trie head){
        if(!head.isLeaf){
        	Set<String> childs = head.hmp.keySet(); 
            for(String child:childs){
                System.out.println(head.hmp.get(child).data);
                display(head.hmp.get(child));
            }
        }
    }

    public boolean search(String s, int index){
    	return search(s,index,this.root);
    }
    
    public boolean search(String s, int index, Trie head){
    	if(head.isLeaf){
    		System.out.println("String not found!");
    		return false;
    	}
    	if(head.hmp.containsKey(""+s.charAt(index))){
    		System.out.println(head.hmp.get(""+s.charAt(index)).data);
    		if(index+1==s.length()){
    			return true;
    		}
    		return search(s,index+1,head.hmp.get(""+s.charAt(index)));
    	}else{
    		System.out.println("String not found!");
    		return false;    		
    	}
    	
    }


}

class Trie{
    String data;
    HashMap<String, Trie> hmp = new HashMap<String, Trie>();
    boolean isLeaf;

}

class trieExer{

    public static void main(String args[]){
    	dictionary dict = new dictionary();
    	dict.buildDictionary("eobamgl");
    	dict.display();
    	System.out.println(dict.search("run", 0));
    
    }
}
