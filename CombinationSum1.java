//Here we have given an array and target sum
//and we have to print every subset whose combined
//sum is equal to target sum.

//Efficient solution is to use backtrack

public List<List<Integer>> combinationSum(int[] candidates, int target) {
	List<List<Integer>> res = new ArrayList<>();
	List<Integer> temp = new ArrayList<>();
	Arrays.sort(candidates);
	combination(res, temp, candidates, target, 0);
	return res;
}
static void combination(List<List<Integer>> res, List<Integer> temp, int[] arr, int target, int i) {
	if (target < 0)
		return;
	if (target == 0) {
		res.add(new ArrayList<>(temp));
		return;
	}
	while (i < arr.length && target - arr[i] >= 0) {
		temp.add(arr[i]);
		combination(res, temp, arr, target - arr[i], i);
		i++;
		temp.remove(temp.size() - 1);
	}

}


//Problem is present on leetcode