class Solution {
    private double powerR(double x, int n)
    {
        if(n==0)    return 1;

        double half= powerR(x,n/2);
        if(n%2==1)
        {
            return x*half*half;
        }
        return half*half;
    }
    public double myPow(double x, int n) {

        if(x==0)    return 0;

        if(n==0)    return 1;

        double temp= powerR(x,Math.abs(n));

        return (n>=0)?temp:1/temp;
        
    }
}
