
public class tiptop {
	
	static final Integer i1 = 1;
	final Integer i2=2;
	Integer i3 = 3;

	public static void main(String[] args) {
		final Integer i4=4;
		Integer i5 = 5;
		
		int a=2;
		double b= 34.5;
		float c = 23.7f;
		long d = 34;

		System.out.println((a+d)*(c+b));
		Object.class.getTypeName();
		class inner{
			final Integer i6=6;
			Integer i7 = 7;
			
			inner(){
				System.out.println(i6+i7);
			 }
		}
	}

}
