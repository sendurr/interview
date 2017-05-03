class mine implements Runnable {

	private String thname;
	private long time;
	
	mine(String name, long time){
		this.thname = name;
		this.time=time;
	}
	
	public void run(){
		System.out.println("Running Thread - " + thname);
		Thread t = new Thread();
		System.out.println("Running sub Thread of " + thname);
		t.start();
		try {
			t.sleep(time);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		try {
			t.join(1000);
			System.out.println("Sub Thread of "+thname+" completed");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class workonthread {

	public static void main(String[] args) {
		Thread t = new Thread(new mine("1",100));
		Thread t1 = new Thread(new mine("2",10));
		t.start();
		t1.start();
		try {
			t.join();
			System.out.println("Thread 1 completed");
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		try {
			t1.join();
			System.out.println("Thread 2 completed");
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		

	}

}
