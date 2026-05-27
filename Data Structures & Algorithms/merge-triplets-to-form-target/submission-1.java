class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int x=0,y=0,z=0;

        for(int [] t:triplets)
        {
            if(t[0]<= target[0] && t[1]<= target[1] && t[2]<=target[2])
            {
                x= Math.max(t[0],x);
                y= Math.max(t[1],y);
                z= Math.max(t[2],z);
            }
        }
        
        return x==target[0] && y== target[1] && z==target[2];
        
    }
}
