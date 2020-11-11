//Here we have given a string and we have to print all
//the permutations of it.

//Basic is to use recursion and efficient approach is
//use backtracking

import java.util.*;
class StringPermuatation {
	public static void main(String[] args) {

		String s = "ABC";
		int n = s.length();
		permute(s, 0, n - 1);

	}

	static void permute(String s, int l, int r) {

		if (l == r)
			System.out.println(s);
		else {
			for (int i = l; i <= r; i++) {
				s = swap(s, l, i);
				permute(s, l + 1, r);
				s = swap(s, l, i);
			}
		}
	}

	static String swap(String s, int i, int j) {
		char temp;
		char[] arr = s.toCharArray();
		temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		return String.valueOf(arr);
	}

}

//Question is available on geeksforgeeks