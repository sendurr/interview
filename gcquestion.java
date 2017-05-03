class Demo{
	public void finalize(){
		System.out.println("called GC for demo");
	}	
}

class Test{
	private Demo d;
	
	void start(){
		d= new Demo();
		this.takedemo(d);
	}
	
	void takedemo(Demo demo){
		demo=null;
		//System.gc();
		//Runtime.getRuntime().gc();
		demo=new Demo();
	}
	
	public void finalize(){
		System.out.println("called GC for test");
	}
}

public class gcquestion {

	public static void main(String[] args) {
		Test t = new Test();
		t.start();

	}

}
