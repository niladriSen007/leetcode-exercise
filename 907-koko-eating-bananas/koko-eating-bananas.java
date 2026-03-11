class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int max = -1;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, piles[i]);
        }
        int start = 1, end = max;
        int res = 0;
        int min_hours = Integer.MAX_VALUE;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            System.out.println(mid);
            res = 0;
            for (int i = 0; i < n; i++) {
                int rem = piles[i] / mid;
                int mod = piles[i] % mid;
                res = mod == 0 ? res + rem : res + rem + 1;
            }
            System.out.println("res->" + res);
            if (res > h) {
                start = mid + 1;
            } else if(res <=h && res > 0) {
                end = mid - 1;
                min_hours = Math.min(min_hours, mid);
            }else{
                return min_hours;
            }
        }
        return min_hours;
    }
}