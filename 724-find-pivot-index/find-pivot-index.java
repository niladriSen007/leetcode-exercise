class Solution {
    public int pivotIndex(int[] nums) {
        int total_sum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            total_sum += nums[i];
        }
        int left = 0, right = 0;
        if (right == (total_sum - nums[0] - left))
            return 0;
        for (int i = 1; i < n; i++) {
            left += nums[i - 1];
            right = total_sum - left - nums[i];
            if (left == right)
                return i;
        }
        return -1;
    }
}