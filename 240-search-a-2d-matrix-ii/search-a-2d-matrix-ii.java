class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int start_row = row-1;
        int start_col = 0;
        while(start_row>=0 && start_col < col){
            // int mid = start + (end-start)/2;
            if(target == matrix[start_row][start_col]) return true;
            else if(target<matrix[start_row][start_col]) start_row--;
            else start_col++;
        }
        return false;
    }
}