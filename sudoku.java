import java.util.ArrayList;
class sudokuClass{
	
	ArrayList<Integer> num = new ArrayList<Integer>();
	public boolean validSudoku(int[][] a){
		int i,j;
		for(i=0;i<9;i++){
			num.clear();
			for(j=0;j<9;j++){
				if(a[i][j]!=0){
					if(num.contains(a[i][j])){
						return false;
					}else{
						num.add(a[i][j]);
					}
				}
			}
		}

		for(i=0;i<9;i++){
			num.clear();
			for(j=0;j<9;j++){
				if(a[j][i]!=0){
					if(num.contains(a[j][i])){
						return false;
					}else{
						num.add(a[j][i]);
					}
				}
			}
		}
		
		for(i=0;i<9;i+=3){
			for(j=0;j<9;j+=3){
				//System.out.println("("+i+","+j+")");
				if(!checkBlock(i,j,a)){
					return false;
				}
				//System.out.println();
			}
			//System.out.println();
		}
		return true;
	}
	
	public boolean checkBlock(int starti, int startj, int[][] a){
		int i,j;
		num.clear();
		for(i=starti;i<starti+3;i++){
			for(j=startj;j<startj+3;j++){
				//System.out.print("("+i+","+j+")");
				if(a[i][j]!=0){
					if(num.contains(a[i][j])){
						System.out.println("Block false");
						return false;
					}else{
						num.add(a[i][j]);
					}
				}
			}
			//System.out.println();
		}
		return true;
	}
}
public class sudoku {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] a = {{3,0,6,5,0,8,4,0,0},
				     {5,0,0,0,0,0,0,0,0},
				     {0,8,7,0,0,0,0,3,1},
				     {0,0,3,0,1,0,0,8,0},
				     {9,0,0,8,6,3,0,0,5},
				     {0,5,0,0,9,0,6,0,0},
				     {1,3,0,0,0,0,2,5,0},
				     {0,0,0,0,0,0,0,7,4},
				     {0,0,5,2,0,6,3,0,0}};
		sudokuClass sudo = new sudokuClass();
		System.out.println(sudo.validSudoku(a));
	}

}
