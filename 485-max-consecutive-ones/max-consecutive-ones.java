class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int counter = 0;
        int ans = Integer.MIN_VALUE;
        int right = 0, n = nums.length;
        while (right < n) {
            if (nums[right] == 0) {
                counter = 0;
            } else {
                counter++;
            }
            ans = Math.max(counter, ans);
            right++;
        }
        return ans;
    }
}