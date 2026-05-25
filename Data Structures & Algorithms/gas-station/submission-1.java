class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for(int i=0;i<gas.length;i++)
        {
            gas[i]= gas[i]-cost[i];
        }
        int sum=gas[0];
        int start=0;
        for(int i=0;i<gas.length;i++)
        {
            
            if(gas[i]>=0 && sum<0)
            {
                start=i;
                sum=gas[i];
            }
            else{
                sum+=gas[i];
            }
        }
        sum=0;
        for(int g:gas)
        {
            sum+=g;
        }
        return sum<0 ? -1: start;
        
    }
}
