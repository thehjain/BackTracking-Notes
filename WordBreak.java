//Here we have give a long string and one dictionary containing
//word and we have to break a string in such way so that
//word are available in dictionary and here we have to print
//all the possible combinations that can be possible.

import java.util.*;
class WordBreak {

	static HashSet<String> set = new HashSet<>();

	static void dictContains() {
		String dictionary[] = new String[] {"mobile", "samsung", "sam", "sung",
		                                    "man", "mango", "icecream", "and",
		                                    "go", "i", "love", "ice", "cream"
		                                   };
		for (String ele : dictionary)
			set.add(ele);
		return;
	}

	public static void main(String[] args) {

		String s = "iloveicecreamandmango";
		dictContains();
		wordBreak(s, "");
	}

	static void wordBreak(String s, String res) {

		if (s.length() == 0) {
			System.out.println(res);
			return;
		}
		for (int i = 0; i < s.length(); i++) {
			String left = s.substring(0, i + 1);
			if (set.contains(left)) {
				String right = s.substring(i + 1);
				wordBreak(right, res + left + " ");
			}
		}

	}



	// static void wordBreak(String s) {
	// 	System.out.println("hello");
	// 	wordBreakUtil(s, s.length(), "");
	// }

	// static void wordBreakUtil(String s, int n, String res) {
	// 	for (int i = 1; i < n; i++) {

	// 		String prefix = s.substring(0, i);
	// 		//System.out.println(prefix);
	// 		if (dictContains(prefix)) {
	// 			//System.out.println("yello");
	// 			if (i == n) {
	// 				res += prefix;
	// 				//System.out.println("yello");
	// 				System.out.println(res);
	// 				return;
	// 			}
	// 			wordBreakUtil(s.substring(i, n - i), n - i, res + prefix + " ");
	// 		}

	// 	}
	// }
}


//Problem is avialable on geeksforgeeks