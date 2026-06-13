class Solution {
    int[] x = { -1, 1, 0, 0 };
    int[] y = { 0, 0, -1, 1 };

    boolean isValid(int i, int j, int row, int col) {
        if (i < 0 || i >= row || j < 0 || j >= col)
            return false;
        return true;
    }

    void dfs(char[][] grid, int row, int col, int currentRow, int currentCol, boolean[][] visited) {
        visited[currentRow][currentCol] = true;
        for (int k = 0; k < 4; k++) {
            int r = currentRow + x[k]; // up , down, left , right
            int c = currentCol + y[k];
            if (isValid(r, c, row, col) && grid[r][c] == '1' && !visited[r][c]) {
                dfs(grid, row, col, r, c, visited);
            }
        }
        return;

    }

    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int res = 0;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid, row, col, i, j, visited);
                    res++;
                }
            }
        }
        return res;
    }
}