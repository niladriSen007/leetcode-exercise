class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Clean the array
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = n + 1;
            }
        }


        // replace with Negative
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num > n)
                continue;
            if (nums[num - 1] > 0)
                nums[num - 1] = -nums[num - 1]; // 

        }

        // for(int num:nums){
        //     System.out.println(num);
        // }

        // find first positive
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0)
                return i + 1;
        }
        return n + 1;

    }
}