package LogicPractice;

public class StaticPractice {
	
	static int a = 10;
	int b = 20;
	
	static void m1() 
	{
	  System.out.println("This is static method...");
	}
	
	void m2() 
	{
	  System.out.println("This is non-static method...");
	}
	
	void m3()
	{
		System.out.println(a);
		System.out.println(b);
		m1();
		m2();
	}


}
