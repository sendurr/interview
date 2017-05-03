import java.util.LinkedList;
import java.util.TreeSet;

class route{
    leaf root = new leaf();
    
    public route(){
        root=null;
        
    }
    
    public boolean dfs(leaf start){
        if(start==null){
            System.out.println("The tree is empty!");
            return false;
        }
        
        System.out.println(start.data);
        start.visit=true;
        /*for(leaf l:nodes){
            l.visit=false;
        }*/
        for(leaf l:start.nodes){
            if(!l.visit){
                dfs(l);
            }
        }
        return true;
    }

    public void bfs(leaf start){
        if(start==null){
            System.out.println("The tree is empty!");
            return;
        }
        for(leaf l:start.nodes){
            l.visit=false;
        }
        
        LinkedList<leaf> q = new LinkedList<leaf>();
        start.visit=true;
        q.add(start);
        while(!q.isEmpty()){
            leaf node = q.remove();
            System.out.println(node.data);
            for(leaf l:start.nodes){
                if(!l.visit){
                    l.visit=true;
                    q.add(l);
                }
            }
        }
    }
    
    public boolean routeFoundDFS(leaf start, leaf end){
    
        if(start==end){
            return true;
        }
        start.visit=true;
        for(leaf l:start.nodes){
            l.visit=false;
        }
        for(leaf l:start.nodes){
            if(!l.visit){
                if(l==end){
                    return true;
                }
                dfs(l);
            }
        }
        return false;
    }

    public boolean routeFoundBFS(leaf start, leaf end){
        if(start==end){
            //System.out.println("The tree is empty!");
            return true;
        }
        for(leaf l:start.nodes){
            l.visit=false;
        }
        
        LinkedList<leaf> q = new LinkedList<leaf>();
        start.visit=true;
        q.add(start);
        while(!q.isEmpty()){
            leaf node = q.remove();
            System.out.println(node.data);
            for(leaf l:start.nodes){
                if(!l.visit){
                    if(l==end){
                        return true;
                    }
                    l.visit=true;
                    q.add(l);
                }
            }
        }
        return false;
    }

}


class leaf{
    int data;
    leaf[] nodes;
    boolean visit;

}

class routeBetweennodes{
    public static void main(String args[]){

    
    }
}