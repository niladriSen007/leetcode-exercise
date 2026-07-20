class Solution {
    public void moveZeroes(int[] nums) {
        // int left = 0;
        // int n = nums.length;
        // for (int right = 0; right < n; right++) {
        //     if (nums[right] != 0) {
        //         if (right != left) {
        //             int temp = nums[left];
        //             nums[left] = nums[right];
        //             nums[right] = temp;
        //         }
        //         left++;
        //     }
        // }

        int left = 0, right = 0;
        int length = nums.length;
        while (right < length) {
            if (nums[right] != 0) {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left++;
            }
            right++;
        }

    }
}