package LogicPractice;

class SuperKeyword {
	
	int a = 10;
	void m1()
	{
		System.out.println("This is parent method");
	}

}

class Child extends SuperKeyword{
	
	int b =20;
	void m2()
	{
		System.out.println("This is child method");
		super.m1();
		System.out.println(super.a);
	}
	
	
}


