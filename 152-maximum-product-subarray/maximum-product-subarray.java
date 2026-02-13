class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0], max = nums[0], min = nums[0];
        int n = nums.length;
        for (int i = 1; i < n; i++) { // -2 3 -4
            int curr = nums[i];
            int min_end = min * nums[i];
            int max_end = max * nums[i];
            min = Math.min(curr, Math.min(min_end, max_end));
            max = Math.max(curr, Math.max(min_end, max_end));
            res = Math.max(res, Math.max(min, max));
        }
        return res;
    }
}