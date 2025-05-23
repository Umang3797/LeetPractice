class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); // Sort to handle duplicates
        findCombinations(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }

    public void findCombinations(int[] candidates, int index, int target, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (target < 0) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            // Skip duplicates
            if (i == index || candidates[i] != candidates[i - 1]) {
                current.add(candidates[i]);
                findCombinations(candidates, i + 1, target - candidates[i], current, result);
                current.remove(current.size() - 1); // Backtrack
            }
        }
    }
}
