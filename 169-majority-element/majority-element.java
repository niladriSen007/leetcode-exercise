class Solution {
    public int majorityElement(int[] nums) {
        // int n = nums.length;
        // if (n == 0)
        //     return 0;
        // if (n == 1)
        //     return nums[0];
        // int count = 0;
        // int candidate=nums[0];
        // for (int i = 0; i < n; i++) {
        //     if (count == 0) {
        //         candidate = nums[i];
        //     }
        //     count = (nums[i] == candidate) ? count + 1 : count - 1;
        // }
        // return candidate;

        int n = nums.length;
        int candidate = nums[0];
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (count == 0) {
                candidate = nums[i];
                count = 1;
            } else if (candidate == nums[i])
                count++;
            else
                count--;
        }

        return candidate;

    }
}