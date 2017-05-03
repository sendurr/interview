import java.util.Arrays;

class classTriplets{

    public void finsTriplets(int[] a){
    
        int i,j,k;
        int n=a.length;
        if(n<3){
            System.out.println("Array length is <3, no triplets found!");
            return;
        }
        
        for(i=0;i<n-2;i++){
            for(j=i+1;j<n-1;j++){
                for(k=j+1;k<n;k++){
                	//System.out.println(a[i]+","+a[j]+","+a[k]);
                	if(a[i]+a[j]+a[k] == 0){
                		System.out.println(a[i]+","+a[j]+","+a[k] + " -> True");
                    }
                }
            }
        }
    }
}

class Triplets{

    public static void main(String args[]){
        classTriplets trip = new classTriplets();
        int[] a={1, -2, 1, 0, 5};
        trip.finsTriplets(a);
        Arrays.sort(a);
        for(int aa: a){
        	System.out.print(aa+" ");
        }
    
    }
}