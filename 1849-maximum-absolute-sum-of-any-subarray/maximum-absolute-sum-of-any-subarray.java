class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length;
        if(n==1) return Math.abs(nums[0]);
        int max = nums[0], min = nums[0], res = nums[0];
        for (int i = 1; i < n; i++) {
            min = Math.min(nums[i],min+nums[i]);
            max = Math.max(nums[i],max+nums[i]);
            res = Math.max(res,Math.max(Math.abs(max),Math.abs(min)));
        }
        return res;
    }
}