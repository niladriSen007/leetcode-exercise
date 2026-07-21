class Solution {
    public int thirdMax(int[] nums) {
        int n= nums.length;
        if(n==1) return nums[0];
        if(n==2) return nums[0] > nums[1] ? nums[0] : nums[1];
        long first_max=Long.MIN_VALUE;
        long second_max=Long.MIN_VALUE;
        long third_max=Long.MIN_VALUE;

        for(int num : nums){

            if(num==first_max || num==second_max || num==third_max) continue;

            if(num > first_max){
                third_max = second_max;
                second_max = first_max;
                first_max = num;
            }
            else if(num > second_max){
                third_max = second_max;
                second_max = num;
            }
            else if(num > third_max){
                third_max = num;
            }
        }
        return (int) (third_max == Long.MIN_VALUE ? first_max : third_max);
    }
}