class exc1 extends Exception{}
class exc0 extends exc1{}


public class exceptques {

	public static void main(String[] args) {
		try{
			throw new exc0();
		//}catch(exc1 e1){
			//System.out.println("EXC1 caught error");
		}catch(Exception e){
			System.out.println("Exception caught error");
		}

	}

}
