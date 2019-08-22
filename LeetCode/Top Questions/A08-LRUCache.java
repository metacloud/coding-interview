/*
146. LRU Cache
*/

class LRUCache {
    public class Node {
        int key; int val;
        Node prev; Node next;
        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    int nodes, capacity;
    Map<Integer, Node> map; //key - Node pair
    Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.nodes = 0;
        map = new HashMap<Integer, Node>();

        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.prev = null;
        head.next = tail;
        tail.prev = head;
        tail.next = null;
    }

    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        //map.containsKey(key) => need to update Node
        Node node = map.get(key);
        deleteNode(node);
        addNode(node);
        return node.val;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            //update LRU status with new value
            Node node = map.get(key);
            deleteNode(node);
            node.val = value;
            addNode(node);
        }else {
            // !map.containsKey(key)
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            addNode(newNode);
            nodes++;

            if(nodes > capacity){
                Node removed = popLastNode();
                map.remove(removed.key);
                nodes--;
            }
        }

    }

    //push new Node to Top
    public void addNode(Node node){
        Node next = head.next;
        head.next = node;
        node.prev = head;
        node.next = next;
        next.prev = node;
    }

    //delete Node
    public void deleteNode(Node node){
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    //pop last Node
    public Node popLastNode(){
        Node last = tail.prev;
        deleteNode(last);
        return last;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
