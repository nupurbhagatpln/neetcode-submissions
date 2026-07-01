class Solution {
    private int digitSq(int n)
    {
        int sum=0;
        while(n!=0)
        {
            int t= n%10;
            sum+= t*t;
            n=n/10;
        }
        return sum;
    }
    public boolean isHappy(int n) {

        Set<Integer> set= new HashSet<>();
        while(n!=1  && !set.contains(n))
        {
            set.add(n);
            n=digitSq(n);
        }
        if(n==1)
        {
            return true;
        }
        return false;

        
    }
}
