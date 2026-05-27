package LogicPractice;

public class ReverseString {

	public static void main(String[] args) {
		
		String s = "level";
		
		int start = 0;
		int end = s.length()-1;
		String rev = "";
		
		
		while(start<=end)
		{
			 rev =rev + s.charAt(end);
			 end--;
		}
		
		if(s.equals(rev))
		{
			System.out.println("Is Palindrome");
		}
		else
		{
			System.out.println("Not a Palindrome");
		}
		
		

	}

}
