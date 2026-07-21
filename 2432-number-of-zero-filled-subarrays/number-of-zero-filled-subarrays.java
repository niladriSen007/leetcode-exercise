class Solution {
    public long zeroFilledSubarray(int[] nums) {
        int n = nums.length;
         long count = 0;
        int consecutiveZeros = 0;

        for (int num : nums) {
            if (num == 0) {
                consecutiveZeros++;
            } else {
                consecutiveZeros = 0;
            }
            // Each new zero in a run of length k adds k new subarrays
            count += consecutiveZeros;
        }

        return count;

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