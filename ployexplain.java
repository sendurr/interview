class shape{
	void draw(){
		System.out.println("I am drawing a shape");
	}
	void draw1(){
		System.out.println("I am drawing a shape original");
	}
}

class triangle extends shape{
	void draw(){
		System.out.println("I am drawing a triangle");
	}
	void draw2(){
		System.out.println("I am drawing a triangle original");
	}
}

class circle extends shape{
	void draw(){
		System.out.println("I am drawing a circle");
	}
}

public class ployexplain {

	public static void main(String[] args) {
		shape s = new shape();
		s.draw();
		triangle t = new triangle();
		s=t;
		s.draw();
		s.draw1();
		t.draw2();


		

		shape c = new circle();
		c.draw();
		
	}

}
