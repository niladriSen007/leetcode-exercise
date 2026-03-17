class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        if(target < matrix[0][0] || target > matrix[row-1][col-1]) return false;
        int start = 0,end = (row*col) -1;
        while(start<=end){
            int mid = start + (end-start)/2;
            int r = mid/col;
            int c = mid % col;
            if(target == matrix[r][c]) return true;
            else if(target < matrix[r][c]) end = mid-1;
            else start = mid +1;
        }
        return false;
    }
}