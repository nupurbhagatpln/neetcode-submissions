/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        
        HashMap<Node, Node> oldToCopy= new HashMap<>();
        oldToCopy.put(null, null);

        // Ist pass to create a copy of nodes and map in hashMap 
        Node cur= head;
        while(cur!= null)
        {
            Node newNode= new Node(cur.val);
            oldToCopy.put(cur,newNode);
            cur=cur.next;
        }

        // 2nd pass to map the next and random pointer

        cur=head;
        while(cur!=null)
        {
            Node copy= oldToCopy.get(cur);
            copy.next=oldToCopy.get(cur.next);
            copy.random=oldToCopy.get(cur.random);
            cur=cur.next;
        }

        return oldToCopy.get(head);


    }
}
