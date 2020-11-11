//This is same as combination sum 1
//only difference is here we have to return
//all the unique subsets of an array

public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
		if (res.contains(temp)) return;
		res.add(new ArrayList<>(temp));
		return;
	}
	while (i < arr.length && target - arr[i] >= 0) {
		temp.add(arr[i]);
		combination(res, temp, arr, target - arr[i], i + 1);
		i++;
		temp.remove(temp.size() - 1);
	}
}


//Problem is available on leetcode