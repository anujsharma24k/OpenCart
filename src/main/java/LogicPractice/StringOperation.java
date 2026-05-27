package LogicPractice;

import java.util.Arrays;

public class StringOperation {

	public static void main(String[] args) {
		
		String[] arr = {"Rahul", "Anuj", "Priya", "Karan", "Anju"};
        String temp;

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {

                int k = 0;
                boolean swap = false;

                while (k < arr[i].length() && k < arr[j].length()) {

                    if (arr[i].charAt(k) > arr[j].charAt(k)) {
                        swap = true;
                        break;
                    }
                    else if (arr[i].charAt(k) < arr[j].charAt(k)) {
                        break;
                    }

                    k++;
                }

                if (swap) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        System.out.println("Sorted Array:");

        System.out.println(Arrays.toString(arr));

	}

}
