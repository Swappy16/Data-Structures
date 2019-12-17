class Node{
    int data;
    Node nextNodeRef;
    Node(int data){
        this.data = data;
    }
};

class LinkedListCreator{
    Node headNodeRef = null;

    void insertInBeg(int data){
        Node newNode = new Node(data);
        newNode.nextNodeRef = headNodeRef;
        headNodeRef = newNode;
    }

    void insertInEnd(int data){
        Node newNode = new Node(data);
        if(headNodeRef == null){
            headNodeRef = newNode;
            return;
        }

        Node curr = headNodeRef;
        while(curr.nextNodeRef!=null){
            curr = curr.nextNodeRef;
        }
        curr.nextNodeRef = newNode;
    }

    void printLinkedList(){
        Node curr = headNodeRef;
        int nodeNo = 1;
        while(curr!=null){
            System.out.println("Data at Node : " + nodeNo + " : " + curr.data);
            System.out.println("Its location : " + curr);
            System.out.println("Next Node location: " + curr.nextNodeRef + "\n");
            curr = curr.nextNodeRef;
        }
        System.out.println("\n");
    }
}
public class LinkedList{
    public static void main(String[] args) {
        LinkedListCreator l = new LinkedListCreator();

        l.insertInBeg(10);
        l.insertInBeg(20);
        l.printLinkedList();
        l.insertInEnd(100);
        l.printLinkedList();
    }
}