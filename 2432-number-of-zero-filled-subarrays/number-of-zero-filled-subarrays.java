class Solution {
    public long zeroFilledSubarray(int[] nums) {
        int n = nums.length;
        long res = 0, count = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                count += 1;
            } else {
                count = 0;
            }
            res += count;
        }
        return res;

        // int res =0,count=0;
        // for(int num:nums){
        //     if(num ==0){
        //         count+=1;
        //         res+=count;
        //     }else{
        //         count=0;
        //     }
        // }
        // return res;

    }
}