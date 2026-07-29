class Solution {
    public int numIdenticalPairs(int[] nums) {
        // int n = nums.length;
        // int count=0;
        // for(int i=0;i<n-1;i++){
        //     for(int j=i+1;j<n;j++){
        //         if(nums[i] == nums[j]) count++;
        //     }
        // }
        // return count;

        int count=0;
        int freq[] = new int[101];

        for(int num:nums){
            count+=freq[num]; //0 1 3 6
            freq[num]++;
        }

        return count;
    }
}