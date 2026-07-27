class LRUCache {
    class Node {
        int key;
        int value;
        Node prev;
        Node next;
        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    int capacity;
    HashMap<Integer, Node> mp;
    Node head;
    Node tail;

    private void removeNode(Node node){
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    private void addNode(Node node){
        Node prev = tail.prev;
        prev.next = node;
        node.prev = prev;
        tail.prev = node;
        node.next = tail;
    }
    
    private void moveToEnd(Node node){
        removeNode(node);
        addNode(node);
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        mp = new HashMap<>();
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!mp.containsKey(key)){
            return -1;
        }

        Node node = mp.get(key);
        moveToEnd(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(mp.containsKey(key)){
            Node node = mp.get(key);
            node.value = value;

            moveToEnd(node);
            return;
        }


        if(mp.size() == capacity){
            Node node = head.next;
            removeNode(node);
            mp.remove(node.key);
        }

        Node newNode = new Node(key, value);
        addNode(newNode);
        mp.put(key, newNode);
    }
}
