class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        List<Integer> values = new ArrayList<>();
        List<Integer> indices = new ArrayList<>();
        int[] res = new int[n];
        values.add(arr[0][0]);
        indices.add(arr[0][1]);
        for (int i = 1; i < n; i++) {
            if (arr[i][0] - arr[i - 1][0] <= limit) {
                values.add(arr[i][0]);
                indices.add(arr[i][1]);
            } else {
                Collections.sort(indices);
                Collections.sort(values);
                for (int j = 0; j < indices.size(); j++) {
                    res[indices.get(j)] = values.get(j);
                }
                values.clear();
                indices.clear();
                values.add(arr[i][0]);
                indices.add(arr[i][1]);
            }
        }
        Collections.sort(indices);
        Collections.sort(values);
        for (int j = 0; j < indices.size(); j++) {
            res[indices.get(j)] = values.get(j);
        }
        return res;
    }
}