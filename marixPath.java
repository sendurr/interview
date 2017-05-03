//import java.util.HashMap;
//import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
//import java.util.Stack;
class marixPathClass{
	class cell{
		int i;
		int j;
		public cell(int i , int j){
			this.i=i;
			this.j=j;
		}
		public cell(){

		}
		
		public boolean equals(Object obj){
			cell temp = null;
			if(obj instanceof cell){
				temp=(cell)obj;
			}
			if((temp.j==this.j) && (temp.i==this.i)){
				return true;
			}else{
				return false;
			}
		}
	}
	int startI=-1, startJ=-1;
	ArrayList<cell> visit = new ArrayList<cell>();
	//LinkedList<cell> path = new LinkedList<cell>(); 
	Queue<cell> path = new LinkedList<cell>(); 
	public boolean isPathExist(int[][] a){
		getStart(a);
		if(startJ==-1 || startJ==-1){
			System.out.println("Start not found");
			return false;
		}
		//System.out.println(startI + " "+  startJ);
		cell start = new cell(startI, startJ);
		path.add(start);
		return getPathHelper(start,a);
	}
	
	public void getStart(int[][] a){
		int i , j, row, column;
		row=a.length;
		column=a[0].length;
		for(i=0;i<row;i++){
			for(j=0;j<column;j++){
				if(a[i][j]==1){
					startI=i;
					startJ=j;
				}
			}
		}
	}

	public boolean getPathHelper(cell block,int[][] a){
		int row, column, leftIndex, rightIndex, topIndex, BottomIndex;
		row=a.length;
		column=a[0].length;
		while(!path.isEmpty()){
			cell currentBlock = path.poll();
			if(a[currentBlock.i][currentBlock.j]==2){
				return true;
			}
			leftIndex = currentBlock.j-1;
			rightIndex = currentBlock.j+1;
			topIndex = currentBlock.i-1;
			BottomIndex = currentBlock.i+1;
			if(leftIndex>=0){
				if(a[currentBlock.i][leftIndex]==2 || a[currentBlock.i][leftIndex]==3){
					cell nextBlock = new cell(currentBlock.i,leftIndex);
					if(!visit.contains(nextBlock)){
						visit.add(nextBlock);
						path.add(nextBlock);
					}
				}
			}
			if(rightIndex<column){
				if(a[currentBlock.i][rightIndex]==2 || a[currentBlock.i][rightIndex]==3){
					cell nextBlock = new cell(currentBlock.i,rightIndex);	
					if(!visit.contains(nextBlock)){
						visit.add(nextBlock);
						path.add(nextBlock);
					}
				}
			}
			if(topIndex>=0){
				if(a[topIndex][currentBlock.j]==2 || a[topIndex][currentBlock.j]==3){
					cell nextBlock = new cell(topIndex,currentBlock.j);
					if(!visit.contains(nextBlock)){
						visit.add(nextBlock);
						path.add(nextBlock);
					}
				}				
			}
			if(BottomIndex<row){
				if(a[BottomIndex][currentBlock.j]==2 || a[BottomIndex][currentBlock.j]==3){
					cell nextBlock = new cell(BottomIndex,currentBlock.j);
					if(!visit.contains(nextBlock)){
						visit.add(nextBlock);
						path.add(nextBlock);
					}
					
				}	
			}
		}
		return false;
	}
}
public class marixPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] a= {{ 0 , 3 , 2 },
                { 3 , 3 , 0 },
                { 1 , 3 , 0 }};
		marixPathClass aa = new marixPathClass();
		System.out.println(aa.isPathExist(a));
	}

}
