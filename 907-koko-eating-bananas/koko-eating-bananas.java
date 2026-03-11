class Solution {

    boolean isCapacity(int[] arr, int mid, int h) {
        int hours = 0;
        for (int item : arr) {
            int div = item / mid;
            int mod = item % mid;
            hours += mod == 0 ? div : div + 1;
        }
        return hours <= h;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int start = 1, end = 0;
        for (int i : piles) {
            end = Math.max(end, i);
        }
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (isCapacity(piles, mid, h)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}