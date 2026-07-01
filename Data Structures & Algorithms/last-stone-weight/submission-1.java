class Solution {
    public int lastStoneWeight(int[] stones) {

        // 1. find the max stone in the array

        int mStone= 0;
        for( int stone : stones)
        {
            mStone=Math.max(mStone,stone);
        }

        // 2. allocated the array to mStone +1 size and values shouls be count

        int [] dummy= new int [mStone+1];

        for(int s: stones)
        {
            dummy[s]++;
        }

        // 3. allocated the two max element
        int f=mStone, s=mStone;

        //  4. run the loop till we reach to 0th index
        //  if dummy[f]==even -> move to next index 
        //  if dummy[f]==odd -> one stone remains , find the next one and 
        //     -> compute the difference and update the dummy 
        //     -> move the pointer the next heaviest 

        while(f>0)
        {
            if(dummy[f]%2==0)
            {
                f--;
                continue;
            }
            int j=Math.min(f-1,s);
            while(j>0 && dummy[j]==0)
            {
                j--;
            }

            if(j==0)
            {
                return f;
            }
            s=j;
            dummy[s]--;
            dummy[f]--;
            dummy[f-s]++;
            f= Math.max(f-s,s);
        }

        return f;
        
    }
}
