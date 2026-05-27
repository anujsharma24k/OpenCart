package LogicPractice;

import java.util.Scanner;

public class AreaOfParallelogram {

	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        //System.out.println("Enter Breadth:");
	        int Breadth = sc.nextInt();
	        //System.out.println("Enter Height:");
	        int Height = sc.nextInt();
	        
	        if(Breadth>0 && Height>0)
	        {
	        	if(Breadth*Height > 0)
	        	{
	              {
	            System.out.println(Breadth*Height);
	              }
	        	}
	        }
	       
	        else if(Breadth<0 || Height<0 || Breadth*Height == 0)
	        {
	            System.out.println("java.lang.Exception: Breadth and height must be positive");
	        }
	        sc.close();
	    }
}
