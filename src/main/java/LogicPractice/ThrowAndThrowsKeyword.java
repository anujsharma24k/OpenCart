package LogicPractice;

import java.io.FileInputStream;

class A1{
	
	void a1() throws InterruptedException
	{
		System.out.println("Before Sleep");
		Thread.sleep(5000);
		System.out.println("After Sleep");
	}
	
	void a2()
	{
		int x = 0;
		System.out.println("Before devision");
		if(x==0) {
		throw new ArithmeticException("This is custom exception");
		}
		else
		{
			System.out.println(100/x);
		}
		
	}
	
}

public class ThrowAndThrowsKeyword {

	public static void main(String[] args) {
		A1 a = new A1();
		try {
			a.a1();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		a.a2();
	}

}
