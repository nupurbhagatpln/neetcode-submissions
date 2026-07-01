class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] A=nums1;
        int[] B=nums2;
        int total= (A.length+B.length);
        int half=total/2;

        if(nums1.length>nums2.length)
        {
            A=nums2;
            B=nums1;
        }
        // initailise the pointer for that small array
        int l=0,r=A.length;

        while(true )
        {
            int i= (l+r)/2; // half index for A
            int j= half-i; // half index for B
        
        // Mapping the aleft , aright, bleft, bright value
            int aLeft  = (i > 0) ? A[i - 1] : Integer.MIN_VALUE;
            int aRight = (i < A.length) ? A[i] : Integer.MAX_VALUE;

            int bLeft  = (j > 0) ? B[j - 1] : Integer.MIN_VALUE;
            int bRight = (j < B.length) ? B[j] : Integer.MAX_VALUE;
        //  Comparing left and right value for A & B

        //  Here the window for both are correct
        if(aLeft<=bRight && aRight>=bLeft)
        {
            if(total%2==1) return Math.min(aRight,bRight);
            return ((double)(Math.max(aLeft,bLeft) + Math.min(aRight,bRight)))/2;
        }

        else if(aLeft>bRight)
        {
            r=i-1;
        }
        else{
            l=i+1;
        }

        }
        // return (double)(0);
        
    }
}
