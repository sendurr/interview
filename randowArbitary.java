import java.util.Random;

class randowArbitaryClass{

	public int customizedRandom(int[] a, int[] freq){
		int[] freqInterval = new int[a.length];
		int sum=0,i;
		for(i=0;i<freq.length;i++){
			sum = freq[i] + sum;
			freqInterval[i] = sum;
			//System.out.println(freqInterval[i]);
		}
		System.out.println(getRandom(1,freqInterval[freqInterval.length-1]));
		for(i=1;i<=freqInterval[freqInterval.length-1];i++){
			int index = getNumberIndex(i,0,freqInterval.length-1,freqInterval);
			System.out.println(index);
		}
		return -1;
	}

	public int getNumberIndex(int x, int start, int end, int[] freqInterval){
		int i, index=-1;
		for(i=0;i<freqInterval.length;i++){
			if(x>freqInterval[i]){
				return index;
			}else{
				index=i;
			}
		}
		return index;
	}
	
	/*public int getNumberIndex(int x, int start, int end, int[] freqInterval){
		int mid = ((end-start)/2) + start;
		if(x>freqInterval[mid]){
			return getNumberIndex(x,start,end,freqInterval);
		}
		return mid;
	}*/

	public int getRandom(int min, int max){
		Random stream1 = new Random();
		return stream1.nextInt(max-min+1)+min;
	}
}
public class randowArbitary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] a = {2, 5, 6, 9};
        int[] freq = {1, 3, 5, 1};
		randowArbitaryClass ran = new randowArbitaryClass();
		//System.out.println(ran.customizedRandom(a,freq));
		//System.out.println((int)(Math.random()*100));
		Random random = new Random(-6732303926L);
		for(int i = 0; i < 20; i++){
		    System.out.print(random.nextInt(10)+" ");
		}
		StringBuilder sub = new StringBuilder();


	}

}



// nextInt(10) -- (0--9) + 1  =  1 - 10
//nextInt(10) -- (0--9 + 1) + 10  =  10 - 19
// 1,4,9,10


//60 to 50 
//nextInt(60-50+1)+ 50