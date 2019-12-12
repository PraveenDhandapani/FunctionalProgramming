 class RLinkedList {

    static Node head;

    static class Node{
        int data;
        Node next;

        Node(int d){
            data=d;
            next=null;
        }
    }

    Node reverseLinkedList(Node node){
        Node prev=null;
        Node curr=node;
        Node next=null;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        node=prev;
        return node;
    }

    void printList(Node node){
        while(node!=null){
            System.out.println(node.data+" ");
            node=node.next;
        }
    }

    public static void main(String[] args) {
        RLinkedList list = new RLinkedList();
        list.head = new Node(30);
        list.head.next = new Node(45);
        list.head.next.next = new Node(15);
        list.head.next.next.next = new Node(60);

        System.out.println("intial list");
        list.printList(head);
        head=list.reverseLinkedList(head);
        System.out.println("reversed list");
        list.printList(head);

    }
}
