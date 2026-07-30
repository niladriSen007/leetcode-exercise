class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        int count = 0;
        for (int num : nums) {
            set.add(num);
        }
        for (int num : set) {
            if (!set.contains(num - 1)){
                int streak = 1;
                while (set.contains(num + 1)) {
                    num++;
                    streak++;
                }
                count = Math.max(count, streak);
            }
        }
        return count;
    }
}