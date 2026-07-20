class Solution {
    public int removeElement(int[] nums, int val) {
        int left = 0, right = 0;
        int length = nums.length;
        while (right < length) {
            if (nums[right] != val) {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left++;
            }
            right++;
        }
        return left; 
    }
}