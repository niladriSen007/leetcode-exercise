class Solution {

    int[] x = { -1, 1, 0, 0 };
    int[] y = { 0, 0, -1, 1 };

    boolean isValid(int currentRow, int currentCol, int actualRow, int actualCol) {
        if (currentRow < 0 || currentRow >= actualRow || currentCol < 0 || currentCol >= actualCol)
            return false;
        return true;
    }

    public int orangesRotting(int[][] grid) {

        int rowCount = grid.length;
        int colCount = grid[0].length;
        int freshOranges = 0;
        int time = 0;
        Deque<List<Integer>> queue = new ArrayDeque<>();
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (grid[i][j] == 1)
                    freshOranges++;
            }
        }

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (grid[i][j] == 2)
                    queue.add(List.of(i, j));
            }
        }
        while (!queue.isEmpty() && freshOranges > 0) {
            time++;
            int levelSize = queue.size();
            while (levelSize > 0) {
                List<Integer> cuurrentPos = queue.poll();
                Integer cuurrentRow = cuurrentPos.get(0);
                Integer cuurrentCol = cuurrentPos.get(1);
                for (int k = 0; k < 4; k++) {
                    int activeRow = cuurrentRow + x[k];
                    int activeCol = cuurrentCol + y[k];
                    if (isValid(activeRow, activeCol, rowCount, colCount) && grid[activeRow][activeCol] == 1 &&
                            grid[activeRow][activeCol] > 0) {
                        grid[activeRow][activeCol] *= -1;
                        freshOranges--;
                        queue.add(List.of(activeRow, activeCol));
                    }
                }
                levelSize--;
            }
        }

        return freshOranges > 0 ? -1 : time;
    }
}