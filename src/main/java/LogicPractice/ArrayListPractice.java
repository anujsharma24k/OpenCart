package LogicPractice;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListPractice {

	public static void main(String[] args) {
		
		ArrayList<Object> al = new ArrayList<>();
		
		al.add(100);
		al.add(200.5);
		al.add("Java");
		al.add('V');
		al.add(true);
		
		System.out.println(al);
		
		al.addFirst("Selenium");
		
		System.out.println(al);
		
		al.add(4, "Practice");
		
		System.out.println(al);
		
		ArrayList<Object> al2 = new ArrayList<>();
		al2.add(100);
		al2.add(200.5);
		al2.add("Java");
		
		al.addAll(al2);
		
		System.out.println(al);
		
		System.out.println(al.containsAll(al2));
		
		//al.removeAll(al2);
		
		al.reversed();
		
		System.out.println(al.reversed());
		
		al.set(0, "Anuj");
		
		System.out.println(al);

	}

}
