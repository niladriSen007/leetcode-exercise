class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int counter=0;
        int ans = Integer.MIN_VALUE;
        int right=0,n=nums.length;
        while(right < n){
            if(nums[right] == 0){
                ans = Math.max(counter,ans);
                counter=0;
            }else{
                counter++;
            }
            right++;
        }
        return counter > ans ? counter : ans;
    }
}