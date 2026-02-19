class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int[][] res = new int[n + 1][2];
        int[][] ans = new int[n + 1][2];
        boolean flag = true;
        int id = 0;
        for (int i = 0; i < n; i++) {
            if (intervals[i][0] > newInterval[0] && flag) {
                res[id++] = newInterval;
                flag = false;
            }
            res[id++] = intervals[i];
        }
        if (flag)
            res[n] = newInterval;
        else
            res[n] = intervals[n - 1];
        for (int[] arr : res) {
            for (int elem : arr) {
                System.out.print(elem);
            }
            System.out.println();
        }
        int start1 = res[0][0];
        int end1 = res[0][1];
        int index = 0;
        for (int i = 1; i < n + 1; i++) {
            int start2 = res[i][0];
            int end2 = res[i][1];
            if (end1 >= start2) { // merge
                start1 = start1;
                end1 = Math.max(end1, end2);
            } else {
                ans[index++] = new int[] { start1, end1 };
                start1 = start2;
                end1 = end2;
            }
        }
        ans[index] = new int[] { start1, end1 };
        return Arrays.copyOfRange(ans, 0, index + 1);
    }
}