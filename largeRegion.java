class largeRegionClass{
	
	int maxRegion,currentRegion=0;
	boolean[][] visit;
	public largeRegionClass(int row, int column){
		visit = new boolean[row][column];
		maxRegion=0;
	}
	
	public int getLargestRegion(int[][] a, int row, int column){
		//System.out.println(a.length);
		int i,j;

		for(i=0;i<row;i++){
			for(j=0;j<column;j++){
				if(!visit[i][j] && a[i][j]==1){
					currentRegion=0;
					trackNewRegion(a,i,j,row,column);
					if(currentRegion>maxRegion){
						maxRegion = currentRegion;
					}
				}
			}
		}
		return maxRegion;
	}
	
	public void trackNewRegion(int[][] a, int i , int j, int row, int column){
		currentRegion++;
		visit[i][j] = true;
		int rightIndex, leftIndex, bottomIndex, topIndex;
		rightIndex = j+1;
		leftIndex = j-1;
		bottomIndex = i+1;
		topIndex = i-1;
		if(rightIndex<column){
			if(!visit[i][rightIndex] && a[i][rightIndex]==1){
				trackNewRegion(a,i,rightIndex,row,column);
			}
		}
		if(bottomIndex<row){
			if(!visit[bottomIndex][j] && a[bottomIndex][j]==1){
				trackNewRegion(a,bottomIndex,j,row,column);
			}
		}
		if(leftIndex>0){
			if(!visit[i][leftIndex] && a[i][leftIndex]==1){
				trackNewRegion(a,i,leftIndex,row,column);
			}
		}
		if(topIndex>0){
			if(!visit[topIndex][j] && a[topIndex][j]==1){
				trackNewRegion(a,topIndex,j,row,column);
			}
		}
		if(rightIndex<column && bottomIndex<row){
			if(!visit[bottomIndex][rightIndex] && a[bottomIndex][rightIndex]==1){
				trackNewRegion(a,bottomIndex,rightIndex,row,column);
			}
		}
		if(rightIndex<column && topIndex>0){
			if(!visit[topIndex][rightIndex] && a[topIndex][rightIndex]==1){
				trackNewRegion(a,topIndex,rightIndex,row,column);
			}
		}
		if(leftIndex>0 && topIndex>0){
			if(!visit[topIndex][leftIndex] && a[topIndex][leftIndex]==1){
				trackNewRegion(a,topIndex,leftIndex,row,column);
			}
		}
		if(leftIndex>0 && bottomIndex<row){
			if(!visit[bottomIndex][leftIndex] && a[bottomIndex][leftIndex]==1){
				trackNewRegion(a,bottomIndex,leftIndex,row,column);
			}
		}

	}
	
}
public class largeRegion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[][]={{0,0,1,1,0},{1,0,1,1,0},{0,1,0,0,0},{0,0,0,0,1}};
		largeRegionClass region = new largeRegionClass(4,5);
		System.out.println(region.getLargestRegion(a,4,5));
	}

}
