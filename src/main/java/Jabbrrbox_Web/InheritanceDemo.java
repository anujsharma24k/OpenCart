package Jabbrrbox_Web;



class A{
	
	public void demoPrint() {
		
		System.out.println("This is parent method");
	}
}


class B extends A{
	
	public void demoPrint() {
		
		System.out.println("This is child method");
	}
}

public class InheritanceDemo {
	

	public static void main(String[] args) {
		
		B parent = new B();
		parent.demoPrint();
		

	}

}
