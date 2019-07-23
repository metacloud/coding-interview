public class LinkedList {
    
    Node head;
    public static LinkedList add(LinkedList list, int value){
        Node newNode = new Node(value);
        if(list.head==null){
            list.head = newNode;
        } 
        else {
            Node temp = list.head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;
        }
        return list;
    }

    public static LinkedList remove(LinkedList list, int value){
        Node curr = list.head;
        Node prev = null;
        if(curr != null && curr.val == value){ //remove the first node of the LinkedList
            list.head = curr.next;
            return list;
        }

        while(curr != null && curr.val != value){
            prev = curr;
            curr = curr.next;
        }
        if(curr != null){ // curr.val == value
            prev.next = curr.next;
        } else { // curr == null
            System.out.print("value : " + value + " not found.");
        }
        return list;
    }

    public static void printAll(LinkedList list){
        System.out.print("LinkedList : ");
        Node curr = list.head;
        while(curr != null){
            System.out.print(" " + curr.val);
            curr = curr.next;
        }
    }
}
