class Solution {
    public int maxContainers(int n, int w, int maxWeight) {
        long totalCells = (long) n * n;
        long maxByWeight = maxWeight / w;
        return (int) Math.min(totalCells, maxByWeight);
    }
}