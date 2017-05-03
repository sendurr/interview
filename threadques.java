class MyThread extends Thread{
	MyThread(){
		System.out.println("Thread constuctor");
	}
	
	public void run(){
		System.out.println("start thread function 1");
	}

	public void run(String S){
		System.out.println("start thread function with string");
	}
	
}
public class threadques {

	public static void main(String[] args) {
		Thread t = new MyThread(){
			public void run(){
				System.out.println("Thread main function");
			}
		};
		t.start();
		
		java.util.Calendar.getInstance();
	}
}
