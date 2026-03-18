class Solution {
    public boolean isValid(int[][] arr,int k,int mid,int row,int col){
        int r = row -1;
        int c=0;
        int count = 0;
        while(r >= 0 && c<= col-1){
            if(arr[r][c] > mid) r--;
            else{
                count += r +1;
                c++;
            }
        }
        return count >= k;
    }
    public int kthSmallest(int[][] matrix, int k) {
        int row = matrix.length;
        int col = matrix[0].length;
        int start=matrix[0][0],end = matrix[row-1][col-1];
        int res = -1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(isValid(matrix,k,mid,row,col)) {
                res = mid;
                end = mid-1;
            }else start = mid+1;
        }
        return res;
    }
}