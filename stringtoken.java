import java.util.StringTokenizer;

public class stringtoken {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input ="This is my    name";
		StringBuffer op= new StringBuffer();
		StringTokenizer str = new StringTokenizer(input);
		int count = str.countTokens();
		String[] p =new String[count];
		int i=0;
		while(str.hasMoreTokens()){
			//op.append(str.nextToken());
			//op.append(" ");
			p[i] = (str.nextToken()) + " ";
			i++;
		}
		//System.out.println(op.toString());
	
		i=count-1;
		while(i>=0){
			System.out.print(p[i]);
			i--;
		}
	}

}
