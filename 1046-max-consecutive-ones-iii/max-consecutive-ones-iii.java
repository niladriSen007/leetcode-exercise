class Solution {

    int max_freq_in_arr(int[] arr) {
        return arr[1];
    }

    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int low = 0, high = 0;
        int max_len = 0;
        int[] res = new int[2];
        while (high < n) {
            res[nums[high]]++;
            int window_length = high - low + 1;
            int max_freq_of_1_in_arr = max_freq_in_arr(res);
            int diff = window_length - max_freq_of_1_in_arr;
            if (diff <= k) {
                max_len = Math.max(max_len, window_length);
            }
            while (diff > k) {
                res[nums[low]]--;
                low++;
                window_length = high - low + 1;
                max_freq_of_1_in_arr = max_freq_in_arr(res);
                diff = window_length - max_freq_of_1_in_arr;
            }
            high++;

        }
        return max_len;
    }
}