class MyHashMap {
    private ArrayList<int[]> map;
    public MyHashMap() {
        map= new ArrayList<>();
    }
    
    public void put(int key, int value) {
        if(map.size()==0)
        {
            map.add(new int[]{key,value});
            return ;
        }
        for(int i=0;i<map.size();i++)
        {
            int[] t= map.get(i);
            if(t[0]==key)
            {
                map.remove(i);
                map.add(new int[]{key,value});
                return;
            }
        }
        map.add(new int[]{key,value});
        return ;
    }
    
    public int get(int key) {
        for(int i=0;i<map.size();i++)
        {
            int[] t= map.get(i);
            if(t[0]==key)
            {   
                return t[1];
            }
        }
        return -1;
        
    }
    
    public void remove(int key) {

        for(int i=0;i<map.size();i++)
        {
            int[] t= map.get(i);
            if(t[0]==key)
            {
                map.remove(i);
                return;
            }
        }
        return;

        
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */