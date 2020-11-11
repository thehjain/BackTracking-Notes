//Here we have given a string and we have
//to break that string in such a way.
//every partion is palindrom.


//One way is to check every possible solution using
//recursion

//Efficient way is to use backtracking.

public List<List<String>> partition(String s) {
	List<List<String>> res = new ArrayList<>();
	dfs(0, res, new ArrayList<String>(), s);
	return res;
}
void dfs(int start, List<List<String>> res, ArrayList<String> curr, String s) {
	if (start >= s.length())
		res.add(new ArrayList<>(curr));
	for (int end = start; end < s.length(); end++) {
		if (isPalindrome(s, start, end)) {
			curr.add(s.substring(start, end + 1));
			dfs(end + 1, res, curr, s);
			curr.remove(curr.size() - 1);
		}
	}
}
boolean isPalindrome(String s, int start, int end) {
	while (start < end)
		if (s.charAt(start++) != s.charAt(end--))
			return false;
	return true;
}


//Problem is available on leetcode