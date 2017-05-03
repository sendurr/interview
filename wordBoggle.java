import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Set;

class game{
	dictBoogle root = new dictBoogle();
	//LinkedList<visit> queue = new LinkedList<visit>();
	public void checkBooge(char[][] boggle){
		int i,j,row,column;
		row=boggle.length;
		column=boggle.length;
		for(i=0;i<row;i++){
			for(j=0;j<column;j++){
				visit current = new visit(i,j);
				//queue.clear();
				LinkedList<visit> queue = new LinkedList<visit>();
				queue.add(current);
				boolean[][] track = new boolean[row][column];
				//root.child.put(boggle[i][j], generateTri(boggle,i,j,track));
				root.child.put(boggle[i][j], generateTri(boggle,i,j,queue,track));
			}
		}
	}
	
	public dictBoogle generateTri(char[][] boggle, int i,int j, LinkedList<visit> queuePrev,boolean[][] track1){
	//public dictBoogle generateTri(char[][] boggle, int i,int j,boolean[][] track1){
		int row, column, leftIndex, rightIndex, topIndex, bottomIndex;
		boolean[][] track = track1;
		LinkedList<visit> queue = new LinkedList<visit>();
		queue.addAll(queuePrev);
		row=boggle.length;
		column=boggle.length;
		dictBoogle currentChild = new dictBoogle();
		currentChild.a=boggle[i][j];
		/*LinkedList<visit> subtrack = new LinkedList<visit>();
		subtrack.addAll(track);*/
		track[i][j] = true;
		rightIndex = j+1;
		leftIndex = j-1;
		bottomIndex = i+1;
		topIndex = i-1;
		if(rightIndex<column){
			if(!track[i][rightIndex]){
				//currentChild.child.put(boggle[i][rightIndex], generateTri(boggle,i,rightIndex,track));
				currentChild.child.put(boggle[i][rightIndex], generateTri(boggle,i,rightIndex,queue,track));
			}
		}
		if(bottomIndex<row){
			if(!track[bottomIndex][j]){
				//currentChild.child.put(boggle[bottomIndex][j], generateTri(boggle,bottomIndex,j,track));
				currentChild.child.put(boggle[bottomIndex][j], generateTri(boggle,bottomIndex,j,queue,track));
			}
		}
		if(leftIndex>0){
			if(!track[i][leftIndex]){
				//currentChild.child.put(boggle[i][leftIndex], generateTri(boggle,i,leftIndex,track));
				currentChild.child.put(boggle[i][leftIndex], generateTri(boggle,i,leftIndex,queue,track));
			}
		}
		if(topIndex>0){
			if(!track[topIndex][j]){
				//currentChild.child.put(boggle[topIndex][j], generateTri(boggle,topIndex,j,track));
				currentChild.child.put(boggle[topIndex][j], generateTri(boggle,topIndex,j,queue,track));
			}
		}
		if(rightIndex<column && bottomIndex<row){
			if(!track[bottomIndex][rightIndex]){
				//currentChild.child.put(boggle[bottomIndex][rightIndex], generateTri(boggle,bottomIndex,rightIndex,track));
				currentChild.child.put(boggle[bottomIndex][rightIndex], generateTri(boggle,bottomIndex,rightIndex,queue,track));
			}
		}
		if(rightIndex<column && topIndex>0){
			if(!track[topIndex][rightIndex]){
				//currentChild.child.put(boggle[topIndex][rightIndex], generateTri(boggle,topIndex,rightIndex,track));
				currentChild.child.put(boggle[topIndex][rightIndex], generateTri(boggle,topIndex,rightIndex,queue,track));
				
			}
		}
		if(leftIndex>0 && topIndex>0){
			if(!track[topIndex][leftIndex]){
				//currentChild.child.put(boggle[topIndex][leftIndex], generateTri(boggle,topIndex,leftIndex,track));
				currentChild.child.put(boggle[topIndex][leftIndex], generateTri(boggle,topIndex,leftIndex,queue,track));
			}
		}
		if(leftIndex>0 && bottomIndex<row){
			if(!track[bottomIndex][leftIndex]){
				//currentChild.child.put(boggle[bottomIndex][leftIndex], generateTri(boggle,bottomIndex,leftIndex,track));
				currentChild.child.put(boggle[bottomIndex][leftIndex], generateTri(boggle,bottomIndex,leftIndex,queue,track));
			}
		}
		return currentChild;
	}
	
	public void display(dictBoogle root){
		Set<Character> set = root.child.keySet();
		for(Character c: set){
			StringBuilder chain = new StringBuilder();
			displayHelper(root.child.get(c), chain);
			System.out.println();;
		}
	}

	public void displayHelper(dictBoogle root, StringBuilder chain){
		Set<Character> set = root.child.keySet();
		for(Character c: set){
			chain.append(root.a);
			System.out.println(chain.toString());
			displayHelper(root.child.get(c),chain);
		}
	}
}

class dictBoogle{
	Character a;
	Hashtable<Character, dictBoogle> child = new Hashtable<Character, dictBoogle>();
}

class visit{
	int i;
	int j;
	public visit(){
		
	}
	public visit(int i, int j){
		this.i = i;
		this.j = j;
	}
}

public class wordBoggle {
	public static void main(String args[]){
		char[][] boggle  = {{'G','I','Z'},
                			{'U','E','K'},
                			{'Q','S','E'}};
		game word = new game();
		word.checkBooge(boggle);
		word.display(word.root);
	}

}
