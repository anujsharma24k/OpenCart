package LogicPractice;

import java.util.HashSet;
import java.util.Set;

public class OccurenceOfElement {

	public static void main(String[] args) {
	
		String s = "welcome to the selenium world with java and testng";
		
		/*
		int count = 0;
		char Element = 'o';
		
		for(int i = 0; i<s.length();i++)
		{
			if(s.charAt(i)==Element)
			{
				count++;
			}
			
		}
		
		System.out.println("Total count of "+Element+" is "+count);
		*/
		Set<Character> set = new HashSet<>();
		
		for(int i = 0; i<s.length();i++)
		{
			if(s.charAt(i) != ' ')
			{
				set.add(s.charAt(i));
			}
			
		}
		
		System.out.println(set);
		
		Object element[] = set.toArray();
		
		int count = 0;
		
		for(int j = 0; j<element.length;j++)
		{
			for(int k = 0; k<s.length();k++)
			{
				if(element[j].equals( s.charAt(k)))
				{
					count++;
				}
			}
			
			System.out.println(element[j]+" count is "+count);
			count = 0;
			
		}

	}

}
