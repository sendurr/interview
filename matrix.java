class rotateMatrix{

    public int[][] rotate(int[][] a, int n){
    int[][] b = new int[n][n];
    int i,j,ref;
    
    for(i=0;i<n;i++){
        for(j=0;j<n;j++){
            ref=j+(n-1);
            if(ref>(n-1)){
                    ref = Math.abs(j-(n-1));
                }
                b[ref][i]=a[i][j];
            }
        }
    return b;
    }
    
    public void display(int[][] a, int n){
        int i, j;
        for(i=0;i<n;i++){
            for(j=0;j<n;j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }
    
    public int[][] checkZero(int[][] a, int n){
    int i,j;
    boolean found=false;
    for(i=0;i<n;i++){
        for(j=0;j<n;j++){
                if(a[i][j]==0){
                	//System.out.println(i+  " " + j);
                    if(!found){
                    		a=replaceZero(a,i,j,n);
                    		found=true;
                    	}
                    found=true;
                }
            }
        }
    return a;
    }



    public int[][] replaceZero(int[][] a, int ii, int jj,int n){
        int i,j;
    	for(i=0;i<n;i++){
                a[i][jj]=0;
            }
        for(j=0;j<n;j++){
                a[ii][j]=0;
            }
        return a;
    }
    
}

class matrix{
    public static void main(String args[]){
        int count=0;
        int i,j;
        int n=4;
        int[][] a=new int[n][n];
        for(i=0;i<n;i++){
            for(j=0;j<n;j++){
                count++;
                a[i][j]=count;
            }
        }
        rotateMatrix cc = new rotateMatrix();
        cc.display(a,n);
        int[][] b= cc.rotate(a,n);
        System.out.println();
        cc.display(b,n);        
        System.out.println();
        a[2][1]=0;
        a=cc.checkZero(a,n);
        cc.display(a,n);        
    
    
    }
}