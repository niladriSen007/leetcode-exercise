class Solution {
    int max_freq(int[] arr) {
        int max_freq = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max_freq)
                max_freq = arr[i];
        }
        return max_freq;
    }

    public int characterReplacement(String s, int k) {
        int n = s.length();
        int low = 0, high = 0;
        int[] res = new int[26];
        int max_len = Integer.MIN_VALUE;
        while (high < n) {
            res[s.charAt(high) - 65]++;
            int len = high - low + 1;
            int max_in_arr = max_freq(res);
            int diff = len - max_in_arr;
            while (diff > k) {
                res[s.charAt(low) - 65]--;
                low++;
                len = high - low + 1;
                max_in_arr = max_freq(res);
                diff = len - max_in_arr;
            }
            if (diff <= k) {
                max_len = Math.max(max_len, len);
            }
            high++;
        }
        return max_len;
    }
}