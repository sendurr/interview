class sample implements Runnable{
	private Thread t;
	private String ThreadName;
	
	sample(String n){
		this.ThreadName=n;
	}
	
	public void run(){
		while(true){
			System.out.print(ThreadName);
		}
	}
	
	public void start(){
		if(t==null){
			t=new Thread(this,ThreadName);
			t.start();
		}
	}
}

public class threadcomplex {

	public static void main(String[] args) {
		sample a = new sample("A");
		sample b = new sample("B");
		
		a.start();
		b.start();

	}

}
