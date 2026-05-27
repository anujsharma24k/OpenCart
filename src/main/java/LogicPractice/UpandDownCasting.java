package LogicPractice;

class Parent{
	int p = 10;
	void p1()
	{
		System.out.println("This is parent method..");
	}
}

class Child1 extends Parent{
	int c = 20;
	void c1()
	{
		System.out.println("This is child method...");
	}
}

public class UpandDownCasting {

	public static void main(String[] args) {
		/*
		int x =10;
		float y = x;
		System.out.println(y);
		
		int z = (int)y;
		System.out.println(z);
		*/
		/*
		Parent p = new Parent();
		System.out.println(p.p);
		p.p1();
		System.out.println(p.c);
		p.c1();
		*/
		/*
		Child1 c = new Child1();
		System.out.println(c.p);
		c.p1();
		System.out.println(c.c);
		c.c1();
         */
		/*
		Parent p = new Child1();
		System.out.println(p.p);
		p.p1();
		System.out.println(p.c);
		p.c1();
		*/
		Parent p = new Child1();
		Child1 c = (Child1) p;
		System.out.println(c.p);
		c.p1();
		System.out.println(c.c);
		c.c1();

	}

}
