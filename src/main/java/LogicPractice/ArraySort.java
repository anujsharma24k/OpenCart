package LogicPractice;

import java.util.Arrays;

public class ArraySort {

	public static void main(String[] args) {
		
		int arr[]= {7,3,8,2,4};
		
		System.out.println("Unsorted Array: "+Arrays.toString(arr));
		/*
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
        */
		
		/*
		Arrays.parallelSort(arr);
		System.out.println(Arrays.toString(arr));
		*/
		
		//Bubble sort ascending
		/*
		for(int i=0; i<arr.length-1;i++)
		{
			for(int j=0;j<(arr.length-1)-i;j++)
			{
				if(arr[j]>arr[j+1])
				{
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1]= temp;
				}
			}
		}
		
		System.out.println("Sorted Array: "+Arrays.toString(arr));
		*/
		
		//Bubble sort descending
		for(int i=0; i<arr.length-1;i++)
		{
			for(int j=0;j<(arr.length-1)-i;j++)
			{
				if(arr[j]<arr[j+1])  // Reverse the operator for descending order
				{
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1]= temp;
				}
			}
		}
		
		System.out.println("Sorted Array: "+Arrays.toString(arr));
	}

}
