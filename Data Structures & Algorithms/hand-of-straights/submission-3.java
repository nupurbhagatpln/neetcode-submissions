class Solution {
    //Approach :
    /*
        map-> to store the frequenecy
        min heap -> to store the next min
    */    
    public boolean isNStraightHand(int[] hand, int groupSize) {

        int n= hand.length;
        if(n<groupSize || n%groupSize!=0)
        {
            return false;
        }

        Map<Integer, Integer> map= new HashMap<>();

        for(int h: hand)
        {
            map.put(h,map.getOrDefault(h,0)+1);
        }

         PriorityQueue<Integer> q= new PriorityQueue<>(map.keySet());

        for(int i=0; i<n/groupSize ;i++)
        {
            int start= q.peek();
            int k= groupSize;
            
            while(k>0)
            {
                if(map.containsKey(start) && map.get(start)>0)
                {
                    map.put(start, map.get(start)-1);
                    if(map.get(start)==0 && q.peek()==start)
                    {
                        q.poll();
                    }
                }
                else{
                    return false;
                }
                k--;
                start=start+1;
            }
        }

        return true;        
    }
}
