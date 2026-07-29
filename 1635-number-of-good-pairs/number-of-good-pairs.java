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
            freq[num]++;
        }

        // formula = k(k-1)/2
        // 1 element occurs 2 times = 1 pair avalable = 2*(2-1)/2 = 1
        // 1 element occurs 3 times = 3 pair avalable = 3*(3-1)/2 = 3
        // 1 element occurs 4 times = 6 pair avalable = 4*(4-1)/2 = 6
        for(int k:freq){
            count+= k*(k-1)/2;
        }

        return count;

        // int count=0;
        // int freq[] = new int[101];

        // for(int num:nums){
        //     count+=freq[num]; //0 1 3 6
        //     freq[num]++;
        // }

        // return count;
    }
}