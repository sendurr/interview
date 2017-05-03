interface D{
	public int x=100;
	/*void output(){
		System.out.println("The value of x is " + x);
	}*/
}

abstract class E{
	public int x=100;
	void output(){
		System.out.println("The value of x is " + x);
	}
}
abstract class A implements D{
	A(){
		System.out.println("Construtor of A");
	}
	public void printMe(){
		System.out.println("Print class A");
	}
	
	abstract void printValue();
}
class B extends A{
	B(){
		System.out.println("Construtor of B");
	}
	
	public void printValue(){
		System.out.println("The value of x is " + x);
	}

	public void printMe(){
		System.out.println("Print class A");
	}
	
	public void printMe1(){
		super.printMe();
		System.out.println("Print class B1");
	}
}

class C extends A{
	C(){
		System.out.println("Construtor of C");
	}
	public void printMe(){
		System.out.println("Print class C");
	}
}
public class testinherit {

	public static void main(String[] args) {
		B b = new B();
		//C c = new C();
		//A a = new A();
		//b=a;
		//printNew(a);
		b.printMe1();
		b.printValue();
	}
	
	public static void printNew(A a){
		a.printMe();
	}

}
