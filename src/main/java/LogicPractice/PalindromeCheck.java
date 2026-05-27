package LogicPractice;

import java.util.Arrays;
import java.util.Scanner;

import com.sun.org.apache.xpath.internal.operations.Equals;

public class PalindromeCheck {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String text = sc.nextLine();
		
		// With new String
		/*
		String reversed = "";
		int i = text.length()-1;
		
		while(i>=0)
		{
			reversed = reversed + text.charAt(i);
			i--;
		}
		
		if(text.equals(reversed)) 
		{
			System.out.println("IS Palindrome");
		}
		else
		{
			System.out.println("Not Palindrome");
		}
		*/
		//Without new string (Using two pointers)
		
		int start = 0;
		int end = text.length()-1;
		boolean isPalindrome = true;
		
		while(start<end)
		{
			if(text.charAt(start)!= text.charAt(end))
			{
				isPalindrome = false;
				break;
			}
			start++;
			end--;	
			
		}
		
		if(isPalindrome == false)
		{
			System.out.println("Not Palindrome");
		}
		else
		{
			System.out.println("Is Palindrome");
		}
		
		

	}

}
