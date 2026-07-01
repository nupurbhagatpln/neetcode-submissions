class Solution {

/*
    Approach:
    1. we can choose any no. of triplets to form target
    2. we need to decide how we ca eleminate the triplet 
    simple condition to eleminate this is 
    any triplet having any values greater than the target t[0],t[1],t[2].

    keep track of boolean flag for x= t[0], y=t[1], z=t[2];
    whenever the x&&y&&z -> true -> return true 
    else rteurn false after iterating all the triplets.
*/
    public boolean mergeTriplets(int[][] triplets, int[] target) {

        boolean x=false,y=false,z=false;

        for(int[] t:triplets)
        {
            if(target[0]==t[0] && target[1]>= t[1] && target[2]>=t[2])
            {
                x=x||true;
            }
            if(target[0]>=t[0] && target[1]== t[1] && target[2]>=t[2])
            {
                y=y||true;
            }
            if(target[0]>=t[0] && target[1]>= t[1] && target[2]==t[2])
            {
                z=z||true;
            }
            if(x&&y&&z) return true;
        }
        return false;
        
    }
}
