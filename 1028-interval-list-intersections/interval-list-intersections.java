class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int m = firstList.length;
        int n = secondList.length;
        // if(m==0||n==0) return new int[];
        int[][] res = new int[m + n][2];
        int i = 0, j = 0, index = 0;
        while (i < m && j < n) {
            int start1 = firstList[i][0];
            int end1 = firstList[i][1];
            int start2 = secondList[j][0];
            int end2 = secondList[j][1];
            if (start1 <= start2) {
                if (end1 >= start2) {
                    int interval1 = Math.max(start1, start2);
                    int interval2 = Math.min(end1, end2);
                    res[index++] = new int[] { interval1, interval2 };
                }
            } else {
                if (end2 >= start1) {
                    int interval1 = Math.max(start1, start2);
                    int interval2 = Math.min(end1, end2);
                    res[index++] = new int[] { interval1, interval2 };
                }
            }
            if (end1 < end2)
                i++;
            else
                j++;
        }
        return Arrays.copyOfRange(res,0,index);
    }
}