package LogicPractice;

import java.util.Scanner;

public class ArraySearchPractice {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		int arr[] = {5,8,1,3,9};
		boolean isMatched = false;
		
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]==num)
			{
				isMatched = true;
				break;
			}
		}
		
		if(isMatched == true)
		{
			System.out.println("Matched");
		}
		else
		{
			System.out.println("Not Matched");
		}

	}

}
