package LogicPractice;

import java.util.Scanner;

public class ReadLinesFromInput {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int lineNumber = 1;
		
		while (sc.hasNext()) {
            String line = sc.nextLine();
            System.out.println(lineNumber + " " + line);
            lineNumber++;
			
        }
		sc.close();

	}

}
