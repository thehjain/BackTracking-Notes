//Here we have given a sequence of numbers
//and we have to find its kth permutation lexiographically


public String getPermutation(int n, int k) {
	List<Integer> notUsed = new ArrayList<>();
	int weight = 1;
	for (int i = 1; i <= n; i++) {
		notUsed.add(i);
		if (i == n)
			break;
		weight *= i;
	}
	String res = "";
	k = k - 1;
	while (true) {
		res += notUsed.remove(k / weight);
		k %= weight;
		if (notUsed.isEmpty())
			break;
		weight /= notUsed.size();
	}
	return res;
}


//Problem is available on leetcode