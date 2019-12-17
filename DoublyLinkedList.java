class Node{
    int data;
    Node nextNodeRef;
    Node prevNodeRef;
    Node(int data){
        this.data = data;
    }
};

class DoublyLinkedListCreator{
    Node headNodeRef = null;

    void insertInBeg(int data){
        Node newNode = new Node(data);
        newNode.prevNodeRef = null;
        newNode.nextNodeRef = headNodeRef;
        if(headNodeRef!=null){
            headNodeRef.prevNodeRef = newNode;
        }
        headNodeRef = newNode;
//        newNode.nextNodeRef = headNodeRef;
//        headNodeRef = newNode;
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
        newNode.prevNodeRef = curr;
        curr.nextNodeRef = newNode;

    }

    void deleteNodeWithData(int data){
        Node curr = headNodeRef;
        if(curr.data == data){
            headNodeRef = curr.nextNodeRef;
            headNodeRef.prevNodeRef = null;
            System.out.println("Deleted");
            return;
        }
        while(curr.nextNodeRef.data!=data){
            curr = curr.nextNodeRef;
        }
        curr.nextNodeRef = curr.nextNodeRef.nextNodeRef;
        Node temp = curr;
        curr = curr.nextNodeRef;
        curr.prevNodeRef = temp;
        temp = null;
    }


    void insertAtIndex(int index, int data){
        //index begins from 1
        if(index==1){
            insertInBeg(data);
            return;
        }
        Node newNode = new Node(data);
        Node curr = headNodeRef;
        int currIndex = 1;
        while(currIndex!=index-1){
            curr = curr.nextNodeRef;
            currIndex+=1;
        }
        newNode.nextNodeRef = curr.nextNodeRef;
        newNode.prevNodeRef = curr;
        curr.nextNodeRef = newNode;
        curr = newNode.nextNodeRef;
        curr.prevNodeRef = newNode;
        System.out.println("Added successfully");
    }

    void printLinkedList(){
        Node curr = headNodeRef;
        int nodeNo = 1;
        while(curr!=null){
            System.out.println("Data at Node : " + nodeNo + " : " + curr.data);
            System.out.println("Its location : " + curr);
            System.out.println("Previous Node location: " + curr.prevNodeRef);
            System.out.println("Next Node location: " + curr.nextNodeRef + "\n");
            curr = curr.nextNodeRef;
            nodeNo++;
        }
        System.out.println("\n");
    }
}
public class DoublyLinkedList{
    public static void main(String[] args) {
        DoublyLinkedListCreator l = new DoublyLinkedListCreator();

        l.insertInBeg(10);
        l.insertInBeg(20);
        l.insertInEnd(30);
        l.printLinkedList();
        l.insertAtIndex(2,50);
        l.printLinkedList();
        l.deleteNodeWithData(50);
        l.printLinkedList();
    }
}