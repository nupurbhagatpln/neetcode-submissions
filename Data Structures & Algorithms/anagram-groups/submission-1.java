class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> ans = new ArrayList<>();
        Set<String> set =new HashSet<>();

        for(int i=0;i<strs.length;i++)
        {
            if(!set.isEmpty() && set.contains(strs[i]))
            {
                continue;
            }
            int[] p= new int[26];
            int plen= strs[i].length();

            for(char ch: strs[i].toCharArray())
            {
                p[ch-'a']++;
            }
            List<String> temp= new ArrayList<>();
            temp.add(strs[i]);
            for(int j=i+1;j<strs.length;j++)
            {
                int[] t = Arrays.copyOf(p, p.length); 

                if(strs[j].length() == plen)
                {
                    for(char ch: strs[j].toCharArray())
                    {
                        t[ch-'a']--;
                    }
                    int f=1;
                    for(int m=0;m<26;m++)
                    {
                        if(t[m]>0)
                        {  f=0;
                            break;
                        }
                    }
                    if(f==1)
                    {
                        temp.add(strs[j]);
                        set.add(strs[j]);
                    }
                }

            }
            ans.add(new ArrayList<>(temp));
        }
        return ans;
        
    }
}
