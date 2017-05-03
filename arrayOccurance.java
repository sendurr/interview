class arrayOccuranceClass{
	int first=-1, last=-1;
	public void getElementOcurre(int[] a, int x){
		int i;
		for(i=0;i<a.length;i++){
			if(a[i]==x){
				if(first ==-1){
					first=i;
				}
			last=i;
			}
			if(a[i]!=x && last!=-1){
				continue;
			}
		}
		if(last!=-1){
			System.out.println("The first occurance is at " + first);
			System.out.println("The last occurance is at " + last);
		}else{
			System.out.println("Element not found");
		}
	}

	public int getElementOcurreFirst(int[] a, int x, int start , int end, int first){
		int mid = start + ((end-start)/2);
		int i;
		if(start>end){
			return first;
		}else if(a[mid]==x){
			first=mid;
			i=mid-1;
			while(i>=0 && a[i]==x){
				first=i;
				i--;
			}
			return first;
		}else if(a[mid]>x){
			return getElementOcurreFirst(a,x,start,mid-1,first);
		}else if(a[mid]<x ){
			return getElementOcurreFirst(a,x,mid+1,end,first);
		}
		return first;
	}

	public int getElementOcurreLast(int[] a, int x, int start , int end, int first){
		int mid = start + ((end-start)/2);
		int i;
		if(start>end){
			return first;
		}else if(a[mid]==x){
			first=mid;
			i=mid+1;
			while(i<a.length && a[i]==x){
				first=i;
				i++;
			}
			return first;
		}else if(a[mid]>x){
			return getElementOcurreLast(a,x,start,mid-1,first);
		}else if(a[mid]<x ){
			return getElementOcurreLast(a,x,mid+1,end,first);
		}
		return first;
	}
	
	public void getElementOcurreHelper(int[] a, int start, int end, int x){
		int mid = start + ((start-end)/2);
		if(a[mid] == x){
			first=mid;
			last=mid;
		}else if (x<a[mid]){
			getElementOcurreHelper(a,start,mid+1,x);
		}else if (x<a[mid]){
			getElementOcurreHelper(a,start,mid+1,x);
		}
	}
}
public class arrayOccurance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a={1, 3, 5, 5, 5, 5 ,7, 123, 125};
		arrayOccuranceClass ac=  new arrayOccuranceClass();
		ac.getElementOcurre(a,54);
		System.out.println(ac.getElementOcurreFirst(a, 7, 0, a.length-1,-1));
		System.out.println(ac.getElementOcurreLast(a, 7, 0, a.length-1,-1));

	}

}
