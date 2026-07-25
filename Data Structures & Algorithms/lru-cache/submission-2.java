class Node {
    private int key;
    private int value;
    private Node next;
    private Node prev; 

    // coonstructor for the doubly linked list
    public Node( int key,int value)
    {
        this.key=key;
        this.value=value;
        this.prev=null;
        this.next=null;
    }
}
class LRUCache {

    private int size;
    private HashMap<Integer,Node> cache;
    private Node left;
    private Node right;

    public LRUCache(int capacity) {
        this.size=capacity;
        this.cache= new HashMap<>();
        this.left=new Node(0,0);
        this.right= new Node(0,0);
        left.next=this.right;
        right.prev=this.left;
        
    }

    private void insert(Node node)
    {
        Node prev=this.right.prev;
        prev.next=node;
        node.prev=prev;
        node.next=this.right;
        this.right.prev=node;
    }

    private void remove(Node node)
    {
        Node prev= node.prev;
        Node next= node.next;
        prev.next=next;
        next.prev=prev;

    }
    
    public int get(int key) {
        if(!cache.containsKey(key)) return -1;

        Node node = cache.get(key);
        remove(node);
        insert(node);
        return node.value;
        
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key))
        {
            remove(cache.get(key));
        }

        Node newNode= new Node(key,value);
        cache.put(key,newNode);
        insert(newNode);

        if(cache.size()>size)
        {
            Node lru= left.next;
            remove(lru);
            cache.remove(lru.key);
        }
        
    }
}
