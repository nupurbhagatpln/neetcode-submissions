class Solution {
    List<Integer> lengthCount=new ArrayList<>();
    public String encode(List<String> strs) {
        String s="";
        
        int curIndex=0;
        for(String str:strs)
        {
            s+=str;
            lengthCount.add(s.length());
        }
        System.out.println(lengthCount);
        return s;
    }

    public List<String> decode(String str) {
        List<String> res=new ArrayList<>();
        int start=0;
        for(int i=0;i<lengthCount.size()-1;i++)
        {
            res.add(str.substring(start,lengthCount.get(i)));
            start=lengthCount.get(i);
        }
        if(start!=lengthCount.size())
        {
            res.add(str.substring(start));
        }
        

        return res;


    }
}
