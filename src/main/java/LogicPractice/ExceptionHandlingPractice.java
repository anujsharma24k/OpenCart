package LogicPractice;

import java.util.Scanner;

public class ExceptionHandlingPractice {

	public static void main(String[] args) {
		
		int arr[] = new int[5];
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter index where value to be added: ");
		int index = sc.nextInt();
		System.out.println("Enter value to the provided index: ");
		try {
			
		arr[index] = sc.nextInt();
		
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			System.out.println("This is finally block...");
		}
		
		try {
			System.out.println("This is the value "+arr[index]+" of index "+ index);
		}catch(ArrayIndexOutOfBoundsException e) 
		{
			System.out.println(e.getMessage());
		}
		

	}

}
