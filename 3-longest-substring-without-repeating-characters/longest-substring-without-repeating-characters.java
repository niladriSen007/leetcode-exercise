class Solution {
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        int left = 0, right = 0;
        int max_length = Integer.MIN_VALUE;
        Map<Character, Integer> map = new HashMap<>();
        while (right < length) {
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
            if (map.size() == (right - left + 1)) {
                max_length = Math.max(max_length, right - left + 1);
            }
            while (map.size() < right - left + 1) {
                map.compute(s.charAt(left), (key, val) -> val > 1 ? val - 1 : null);
                left++;
            }
            right++;
        }
        return max_length == Integer.MIN_VALUE ? 0 : max_length;
    }
}