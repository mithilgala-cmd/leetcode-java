class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums)
        {
            map.put(num, map.getOrDefault(num,0)+1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (key1,key2) -> map.get(key1) - map.get(key2)
        );

        for(int key : map.keySet())
        {
            pq.offer(key);

            if(pq.size()>k)
            {
                pq.poll();
            }
        }

        int res[] = new int[k];
        for(int i=0;i<k;i++)
        {
            res[i] = pq.poll();
        }
        return res;
    }
}