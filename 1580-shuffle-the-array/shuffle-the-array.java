class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[nums.length];
        int left = 0, right = n;
        int count = 0;
        while (left < n) {
            res[count] = nums[left];
            res[count+1] = nums[right];
            left++;
            right++;
            count+=2;
        }
        return res;
    }
}