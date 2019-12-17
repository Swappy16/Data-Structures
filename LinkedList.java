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

    void deleteNodeWithData(int data){
        Node curr = headNodeRef;
        if(curr.data == data){
            headNodeRef = curr.nextNodeRef;
            System.out.println("Deleted");
            return;
        }
        while(curr.nextNodeRef.data!=data){
            curr = curr.nextNodeRef;
        }
        curr.nextNodeRef = curr.nextNodeRef.nextNodeRef;
    }

    void deleteNodeWithIndex(int index){
        //index starts from 1 to n
        Node curr = headNodeRef;
        if(index==1){
            headNodeRef = curr.nextNodeRef;
            return;
        }

        int currIndex = 1;
        while(currIndex!=index-1){
            curr=curr.nextNodeRef;
            currIndex++;
        }
        curr.nextNodeRef = curr.nextNodeRef.nextNodeRef;
        System.out.println("Deleted successfully");
    }

    void printLinkedList(){
        Node curr = headNodeRef;
        int nodeNo = 1;
        while(curr!=null){
            System.out.println("Data at Node : " + nodeNo + " : " + curr.data);
            System.out.println("Its location : " + curr);
            System.out.println("Next Node location: " + curr.nextNodeRef + "\n");
            curr = curr.nextNodeRef;
            nodeNo++;
        }
        System.out.println("\n");
    }
}
public class LinkedList{
    public static void main(String[] args) {
        LinkedListCreator l = new LinkedListCreator();

        l.insertInBeg(10);
        l.insertInBeg(20);
        l.insertInEnd(30);
        l.insertInEnd(40);
        l.printLinkedList();
        l.deleteNodeWithIndex(1);
        l.printLinkedList();
    }
}