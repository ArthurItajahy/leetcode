public class NumberOfIslands {
    public int numIslands(char[][] grid){
        int numsIslands = 0;
        for (int i = 0; i< grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    numsIslands++; // We found a nes Island!
                    dfs(grid, i, j); // Let's explore this island
                }
            }
        }
        return numsIslands;

    }
    private void dfs(char[][] grid, int i, int j){
        // if we're not of bounds or we're on water, we stop exploring
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0'){
            return;
        }
        // We mark the current square as visited
        grid[i][j] = '0';
        // Then we explore the squares around it
        dfs(grid, i + 1, j); // Down
        dfs(grid, i - 1, j); // Up
        dfs(grid, i, j + 1); // Right
        dfs(grid, i, j - 1); // Left
    }
    public static void main(String[] args) {
        char[][] grid1 = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        NumberOfIslands solution = new NumberOfIslands();
        System.out.println(solution.numIslands(grid1)); // Output: 1

        char[][] grid2 = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        System.out.println(solution.numIslands(grid2)); // Output: 3
    }
}

