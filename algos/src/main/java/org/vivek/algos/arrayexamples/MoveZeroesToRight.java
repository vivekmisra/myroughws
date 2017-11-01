package org.vivek.algos.arrayexamples;

/*Problem


 You are given an integer array which contains some zeros. Move the zeros to the right side of the array with minimum number of swaps. The order of the original array can be destroyed.
 Solution


 We can do this in at most n/2 swaps. We move one index from left to right side and another from right to left side. If we get a non zero number
 at right index and zero in the left index then we swap the numbers. If in the right side we get a zero we just move the pointer to
 the left side and if we get a non zero in the left index then we move it to the right side. We continue this process till the two pointers meet.*/
public class MoveZeroesToRight {
	public static void main(String[] args) {
		int[] arr = { 0, 5, 0, 2, 3, 0, 3, 5, 0 };
		moveZeroesToRight(arr);
		for (int num : arr)
			System.out.print(num + ", ");
		System.out.println();
	}

	private static void moveZeroesToRight(int[] arr) {
		int start = 0;
		int end = arr.length - 1;
		while (start < end) {
			if (arr[start] == 0 && arr[end] != 0) {
				int temp = arr[start];
				arr[start] = arr[end];
				arr[end] = temp;
				start++;
				end--;
			} else {
				if (arr[start] != 0)
					start++;
				if (arr[end] == 0)
					end--;
			}
		}
	}

}
