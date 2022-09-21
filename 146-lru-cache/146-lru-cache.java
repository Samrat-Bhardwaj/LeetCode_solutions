class LRUCache {
    class Node{
        int key;
        int value;
        Node next=null;
        Node prev=null;
        
        public Node(int key, int value){
            this.key=key;
            this.value=value;
        }
    }
    
    Node head=null;
    Node tail=null;
    int size=0;
    int maxSize=0;
    
    void addLast(Node node){
        if(this.size==0){
            head=tail=node;
        } else {
            tail.next=node;
            node.prev=tail;
            tail=node;
            tail.next=null;
        }
        size++;
    }
    
    void removeNode(Node node){
        if(size==1){
            head=tail=null;
        } else if(node==this.head){
            head=head.next;
            head.prev=null;
            node.next=null;
        } else if(node==tail){
            tail=tail.prev;
            tail.next=null;
            node.prev=null;
        } else {
            Node cnode_next=node.next;
            Node cnode_prev=node.prev;
            
            cnode_prev.next=cnode_next;
            cnode_next.prev=cnode_prev;
            
            node.next=null;
            node.prev=null;
        }
        size--;
    }
    
    HashMap<Integer,Node> map;
    
    public LRUCache(int capacity) {
        maxSize=capacity;
        map=new HashMap<>();
    }
    
    public int get(int key) {
        if(map.containsKey(key)==false) return -1;
        
        Node node=map.get(key);
        
        removeNode(node);
        addLast(node);
        
        return node.value;
    }
    
    public void put(int key, int value) {
        if(!map.containsKey(key)){
            Node nn=new Node(key,value);
            
            map.put(key,nn);
            addLast(nn);
            
            if(size>maxSize){ // remove least recently used
                Node tr=head;
                removeNode(tr);
                map.remove(tr.key);
            }
        } else { // value update
            int val=get(key);
            
            if(val!=value){
                Node nn=map.get(key);
                nn.value=value;
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */