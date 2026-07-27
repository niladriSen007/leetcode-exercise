class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int candidate1 = Integer.MIN_VALUE;
        int candidate2 = Integer.MIN_VALUE;

        int counter1 = 0;
        int counter2 = 0;

        for(int i=0;i<nums.length;i++){

            if(counter1 == 0 && nums[i] != candidate2) {
                candidate1 = nums[i];
                counter1 = 1;
            }

            else if(counter2 == 0 && nums[i] != candidate1){
                candidate2 = nums[i];
                counter2 = 1;
            }
            else if(candidate1 == nums[i]) counter1++;
            else if(candidate2 == nums[i]) counter2++;
            else{
                counter1--;
                counter2--;
            }

        }

        counter1=0;
        counter2=0;
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(candidate1 == nums[i]) counter1++;
            if(candidate2 == nums[i]) counter2++;
        }
        int min_count = (nums.length / 3)+1;
        if(counter1 >= min_count) result.add(candidate1);
        if(counter2 >= min_count) result.add(candidate2);
        return result;
    }
}