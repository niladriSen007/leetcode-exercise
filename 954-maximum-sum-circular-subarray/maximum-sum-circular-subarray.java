class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int max = nums[0], min = nums[0], res = nums[0], max_sum_subarr = nums[0], min_sum_subarr = nums[0];
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            int curr = nums[i];
            max = Math.max(curr, max + curr);
            min = Math.min(curr, min + curr);
            max_sum_subarr = Math.max(max_sum_subarr, max);
            min_sum_subarr = Math.min(min_sum_subarr, min);
        }
        int total_sum = 0;
        for (int i = 0; i < n; i++) {
            total_sum += nums[i];
        }
        System.out.println(max_sum_subarr+"<--->"+min_sum_subarr);
        int dev = total_sum - min_sum_subarr;
        res = Math.max(res, Math.max(max_sum_subarr, dev == 0 ? max_sum_subarr : dev));
        return res;
    }
}