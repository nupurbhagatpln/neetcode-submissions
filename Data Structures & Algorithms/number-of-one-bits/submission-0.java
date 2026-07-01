class Solution {
    public int hammingWeight(int n) {

    int result=0;
    for(int i=0;i<32;i++)
    {
        result +=(1<<i & n)!=0 ? 1:0;  
    }

    //  inbuilt function  Integer.bitCount(n);
    return result;
        
    }
}
