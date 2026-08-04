class Solution {
    public int findMaxLength(int[] nums) {
        // 0 0 1 0 0 0 1 1
        // converting all 0's to -1
        int n = nums.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0)
                nums[i] = -1;
        }
        // -1 -1 1 -1 -1 -1 1 1
        // for(int num:nums){
        //     System.out.println(num);
        // }
        // SUM -> INDEX
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (map.containsKey(sum)) {
                int diff = i - map.get(sum);
                max = Math.max(max, diff);
            } else {
                map.put(sum, i);
            }
        }
        return max;
    }
}