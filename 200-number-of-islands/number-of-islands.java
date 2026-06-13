class Solution {
    int[] x = { -1, 1, 0, 0 };
    int[] y = { 0, 0, -1, 1 };

    boolean isValid(int i, int j, int row, int col) {
        if (i < 0 || i >= row || j < 0 || j >= col)
            return false;
        return true;
    }

    void dfs(char[][] grid, int rowCount, int colCount, int currentRow, int currentCol, boolean[][] visited) {
        visited[currentRow][currentCol] = true;
        for (int direction = 0; direction < 4; direction++) {
            int row = currentRow + x[direction]; // up , down, left , right
            int column = currentCol + y[direction];
            if (isValid(row, column, rowCount, colCount) && grid[row][column] == '1' && !visited[row][column]) {
                dfs(grid, rowCount, colCount, row, column, visited);
            }
        }
        return;

    }

    public int numIslands(char[][] grid) {
        int rowCount = grid.length;
        int colCount = grid[0].length;
        int result = 0;
        boolean[][] visited = new boolean[rowCount][colCount];
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid, rowCount, colCount, i, j, visited);
                    result++;
                }
            }
        }
        return result;
    }
}