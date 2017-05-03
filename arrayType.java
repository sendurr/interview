import java.util.HashMap;
class arrayTpeClass{
	HashMap<Integer,String> dic = new HashMap<Integer,String>();
	public arrayTpeClass(){
		this.dic.put(1,"Descending");
		this.dic.put(2,"Ascending");
		this.dic.put(0,"Invalid");
		this.dic.put(13,"Descending Rotated");
		this.dic.put(23,"Ascending Rotated");
	}
	public String getArrayType(int[] a){
		//desc = 1, asc = 2, rot = 3 , 0 = invalid , decRot = 13, asrot=23
		if(a.length==0){
			return "Array is empty";
		}else if (a.length==1){
			return "array has single element";
		}else if (a.length==2){
			if(a[0]>a[1]){
				return "descending";
			}else{
				return "ascending";
			}
		}else{
			return this.dic.get(getArrayTypeHelper(a,0, a.length-1));
		}
		
		//return this.dic.get(getArrayTypeHelper(a,0, a.length-1));
	}
	
	public int getArrayTypeHelper(int[] a, int start,int end){
		if ((end-start+1)==2){
			if(a[start]>a[end]){
				return 1;
			}else{
				return 2;
			}
		}else if ((end-start+1)==3){
			if(a[start]>a[start+1] && a[start+1] >a[end]){
				return 1;
			}else if (a[start]<a[1+start] && a[1+start]<a[end]){
				return 2;
			}else{
				return 0;
			}
		}else{
			int mid = ((start+end)/2)+start;
			int right = getArrayTypeHelper(a, mid+1,end);
			int left = getArrayTypeHelper(a, start,mid-1);
			if(left ==0 || right ==0){
				return 0;
			}else if(right == left && left== 1){
				if(a[mid-1]>a[mid] && a[mid]>a[mid+1]){
					return 1;
				}else{
					return 0;
				}
			}else if(right == left && left == 2){
				if(a[mid-1] < a[mid] && a[mid] < a[mid+1]){
					return 1;
				}else{
					return 0;
				}
			}else if(right == 1 && left == 2){
				if(a[mid]>a[mid+1]){
					return 13;
				}else if(a[mid-1]<a[mid]){
					return 23;
				}else{
					return 0;
				}
			}
		}
		return 0;
	}
}
public class arrayType {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a={2,1,5,4,3};
		arrayTpeClass ss = new arrayTpeClass();
		System.out.println(ss.getArrayType(a));
	}

}
