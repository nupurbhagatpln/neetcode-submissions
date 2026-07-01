class TimeMap {
     Map<String,List<Pair<Integer,String>>> map;
    public TimeMap() {
       map=new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k->new ArrayList<>());
        map.get(key).add(new Pair<>(timestamp,value));
    }
    
    public String get(String key, int timestamp) {
        List<Pair<Integer,String>> values= map.getOrDefault
                                    (key, new ArrayList<>());
        int start=0, end=values.size()-1;
        String ans="";

        while(start<=end)
        {
            int mid= start+(end-start)/2;
            if(values.get(mid).getKey()<=timestamp)
            {
                ans=values.get(mid).getValue();
                start=mid+1;
            }
            else {
                end=mid-1;
            }
        }
        return ans;
    }
}
