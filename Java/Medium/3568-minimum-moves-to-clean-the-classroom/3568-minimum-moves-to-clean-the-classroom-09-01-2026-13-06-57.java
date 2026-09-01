class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();
        int[][] id = new int[m][n];
        for (int[] row : id) Arrays.fill(row, -1);
        
        int k = 0, sr = 0, sc = 0;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                char ch = classroom[r].charAt(c);
                if (ch == 'S') {
                    sr = r;
                    sc = c;
                } else if (ch == 'L') {
                    id[r][c] = k++;
                }
            }
        }
        
        if (k == 0) return 0;
        
        int totalMask = (1 << k) - 1;
        int[][][] best = new int[m][n][1 << k];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(best[i][j], -1);
            }
        }
        
        class State {
            int r, c, mask, e, moves;
            State(int r, int c, int mask, int e, int moves) {
                this.r = r;
                this.c = c;
                this.mask = mask;
                this.e = e;
                this.moves = moves;
            }
        }
        
        Queue<State> q = new LinkedList<>();
        best[sr][sc][0] = energy;
        q.offer(new State(sr, sc, 0, energy, 0));
        
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        
        while (!q.isEmpty()) {
            State cur = q.poll();
            
            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];
                
                if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
                char nextChar = classroom[nr].charAt(nc);
                if (nextChar == 'X') continue;
                
                int ne = cur.e - 1;
                if (ne < 0) continue;
                
                int nmask = cur.mask;
                if (nextChar == 'R') {
                    ne = energy;
                } else if (nextChar == 'L') {
                    nmask |= (1 << id[nr][nc]);
                }
                
                if (nmask == totalMask) {
                    return cur.moves + 1;
                }
                
                if (ne <= best[nr][nc][nmask]) continue;
                best[nr][nc][nmask] = ne;
                q.offer(new State(nr, nc, nmask, ne, cur.moves + 1));
            }
        }        
        return -1;
    }
}