class Solution {
    public int maximumSum(int[] arr) {
        int n = arr.length;
        if (n == 1)
            return arr[0];
        int nopower = arr[0];
        int power = 0;
        int res = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            int v1 = arr[i]; // taking history(starting new list)
            int v2 = nopower + arr[i]; // taking physics + chemistry + english + history( no deletion)
            int v3 = power + arr[i]; // taking physics + english + history( chemistry deletion)
            int v4 = nopower; // taking physics = chemistry + english(history deletion)
            res = Math.max(res, Math.max(v1, Math.max(v2, Math.max(v3, v4))));
            nopower = Math.max(v1, v2);
            power = Math.max(v3, v4);
            System.out.println(res);
        }
        return res;
    }
}