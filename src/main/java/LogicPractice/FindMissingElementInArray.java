package LogicPractice;

public class FindMissingElementInArray {

	public static void main(String[] args) {
		
		int arr[]= {1,3,5,4,6};
		int n = arr.length+1;
		
		int expectedSum = (n*(n+1))/2;
		
		for(int i=0;i<arr.length;i++)
		{
			expectedSum = expectedSum-arr[i];
		}
		
		System.out.println("Missing element: "+expectedSum);
		
		
		
		

	}

}
