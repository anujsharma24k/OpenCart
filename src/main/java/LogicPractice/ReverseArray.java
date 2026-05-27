package LogicPractice;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseArray {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Array Values: ");
		int arr[] = new int[5];
		for(int i = 0; i<arr.length; i++)
		{
			arr[i]= sc.nextInt();
		}
		System.out.println(Arrays.toString(arr));
		
		int start = 0;
		int end = arr.length-1;
		int temp = 0;
		
		while(start<end)
		{
			/*temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
			*/
			
			arr[start] = arr[start]+arr[end];
			arr[end] = arr[start]-arr[end];
			arr[start] = arr[start]-arr[end];
			start++;
			end--;
		}
		
		System.out.println(Arrays.toString(arr));
		

	}

}
