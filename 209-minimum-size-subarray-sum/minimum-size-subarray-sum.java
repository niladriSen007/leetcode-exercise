class Solution {
    public int minSubArrayLen(int target, int[] arr) {
        // int n = nums.length;
        // int low = 0, high = 0;
        // int result_length = Integer.MAX_VALUE, sum = 0;
        // while (high < n) {
        //     sum += nums[high];
        //     while (sum >= target) {
        //         result_length = Math.min(result_length, high - low + 1);
        //         sum -= nums[low];
        //         low++;
        //     }
        //     high++;
        // }
        // if (result_length == Integer.MAX_VALUE)
        //     return 0;
        // return result_length;

        int length = arr.length;
        int min_length = Integer.MAX_VALUE;
        int left = 0, right = 0, sum = 0;
        while (right < length) {
            sum += arr[right];
            while (sum >= target) {
                min_length = Math.min(min_length, right - left + 1);
                sum -= arr[left];
                left++;
            }
            right++;
        }
        return min_length == Integer.MAX_VALUE ? 0 : min_length;
    }
}