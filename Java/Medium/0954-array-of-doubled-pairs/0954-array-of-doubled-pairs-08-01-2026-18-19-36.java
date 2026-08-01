class Solution {
    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int x : arr) count.put(x, count.getOrDefault(x, 0) + 1);
        Integer[] nums = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(nums, Comparator.comparingInt(Math::abs));
        for (int x : nums) {
            if (count.get(x) == 0) continue;
            if (count.getOrDefault(2 * x, 0) <= 0) return false;
            count.put(x, count.get(x) - 1);
            count.put(2 * x, count.get(2 * x) - 1);
        }
        return true;
    }
}