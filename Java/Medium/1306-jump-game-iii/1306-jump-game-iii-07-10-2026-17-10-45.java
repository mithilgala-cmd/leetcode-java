class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        while (!q.isEmpty()) {
            int i = q.poll();
            if (arr[i] == 0) return true;
            int next1 = i + arr[i], next2 = i - arr[i];
            if (next1 >= 0 && next1 < n && !visited[next1]) {
                visited[next1] = true;
                q.offer(next1);
            }
            if (next2 >= 0 && next2 < n && !visited[next2]) {
                visited[next2] = true;
                q.offer(next2);
            }
        }
        return false;
    }
}