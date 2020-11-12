//Here we have given an array and we have to find all the
//possible subsets.

public List<List<Integer>> subsets(int[] nums) {
	List<List<Integer>> res = new ArrayList<>();
	int n = nums.length;
	long pow_set_size = (long)Math.pow(2, n);
	int counter, j;
	for (counter = 0; counter < pow_set_size; counter++) {
		List<Integer> curr = new ArrayList<>();
		for (j = 0; j < n; j++) {
			if ((counter & (1 << j)) > 0)
				curr.add(nums[j]);
		}
		res.add(curr);
	}
	return res;
}



//Problem is available on leetcode