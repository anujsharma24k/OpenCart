package Jabbrrbox_Web;

import java.util.Arrays;

public class Logics {

	public static void main(String[] args) {
		int[] arr = {4,10,3,15,5,1,6,9};
		for(int i=0; i<=arr.length-1; i++){
			
			for(int j=0;j<=arr.length-2;j++) {
				if(arr[j+1] < arr[j]) {
					int temp = arr[j];
				    arr[j] = arr[j+1];
				    arr[j+1] = temp;
				}
			
			}
		}
		
	System.out.println(Arrays.toString(arr));
	System.out.println(arr[arr.length-2]);


	}

}
