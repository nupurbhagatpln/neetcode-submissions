class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans= new int[k];
        Map<Integer,Integer> map= new HashMap<>();
        for(int n: nums)
        {
            map.putIfAbsent(n,1);
            map.put(n,map.get(n)+1);
        }

        PriorityQueue<int[]> q= new PriorityQueue<>((a,b)-> b[1]-a[1]);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) 
        {
            q.add(new int[]{entry.getKey(), entry.getValue()});
        }
        for(int i=0;i<k;i++)
        {
            int[] t= q.poll();
            ans[i]= t[0];
        }
        return ans;
        
    }
}
