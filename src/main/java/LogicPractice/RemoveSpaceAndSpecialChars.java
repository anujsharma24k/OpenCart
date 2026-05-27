package LogicPractice;

import java.util.Scanner;

public class RemoveSpaceAndSpecialChars {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Required String: ");
		
		// Remove Special Chars from String
		/*
		String Text = sc.nextLine();   // My   @#%#$^Number#%$^    is@$#%#% 998364784.
		
		System.out.println(Text.replaceAll("[^a-zA-Z0-9 ]", ""));  // My   Number    is 998364784
		*/
		
		//Remove extra spaces from string
		String Text = sc.nextLine(); // My   Number    is 998364784
		System.out.println(Text.replaceAll("\\s+", " ")); // My Number is 998364784

	}

}
