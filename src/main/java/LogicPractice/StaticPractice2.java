package LogicPractice;

public class StaticPractice2 {
	
	void m4()
	{
		StaticPractice ssp = new StaticPractice();
	    System.out.println(ssp.b);
	    System.out.println(StaticPractice.a);
	    StaticPractice.m1();
	}
	
	
	
	
public static void main(String[] args) {
		
		StaticPractice sp = new StaticPractice();
		System.out.println(StaticPractice.a);
		StaticPractice.m1();
		System.out.println(sp.a);
		sp.m1();
		System.out.println(sp.b);
		sp.m2();
		sp.m3();
		StaticPractice2 c = new StaticPractice2();
		c.m4();
		
	}

}
