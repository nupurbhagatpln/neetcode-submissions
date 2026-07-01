class Solution {
/*
    Approach :
    using the hashmap - store the key withs count
    using minHeap -> to keep track of minvalue from where to start with.
    arrange them in group.
*/

    public boolean isNStraightHand(int[] hand, int groupSize) {
        
        if(hand.length % groupSize!=0)
        {
            return false;
        }
        Map<Integer,Integer> map= new HashMap<>();
        // PriorityQueue<Integer> min= new PriorityQueue<>();

        for(int h:hand)
        {
            map.put(h,map.getOrDefault(h,0)+1);
            // min.add(h);
        }

        // for(Map.Entry<Integer,Integer> entry: map.entrySet())
        // {
        //     min.add(entry.getKey());
        // }

        PriorityQueue<Integer> min = new PriorityQueue<>(map.keySet());
        for(int i=0;i<hand.length / groupSize ;i++)
        {
            int m= min.peek();
            int k= groupSize;
            while(k>0)
            {
                if(map.getOrDefault(m,0)>0)
                {
                    map.put(m,map.get(m)-1);
                    if(map.get(m)==0 && m==min.peek())
                    {
                        min.poll();
                    }
                }
                else{
                    return false;
                }
                k--;
                m=m+1;
            }

        }
        return true;
    }
}
