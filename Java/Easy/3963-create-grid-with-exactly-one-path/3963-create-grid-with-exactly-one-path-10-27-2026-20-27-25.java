class Solution {
    public String[] createGrid(int m, int n) {
        String[] grid = new String[m];
        char[] row = new char[n];

        Arrays.fill(row, '.');
        grid[0] = new String(row);

        Arrays.fill(row, '#');
        row[n - 1] = '.';
        String restRow = new String(row);

        for (int i = 1; i < m; i++) {
            grid[i] = restRow;
        }
        return grid;
    }
}