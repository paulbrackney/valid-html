// this class represents the queues that I will use to implement a stack
// each queue has variables length, front, and rear
// the queues will store nodes from my other class, QNode

public class Assignment03_Brackney_Paul_Queue {

    public int length;
    public Assignment03_Brackney_Paul_QNode front, rear;

    // constructor method for the queue 
    public Assignment03_Brackney_Paul_Queue(){
        length = 0;
        front = rear = null;
    }

    // enqueue method for queue
    public void enqueue(String tagName){
        Assignment03_Brackney_Paul_QNode node = new Assignment03_Brackney_Paul_QNode(tagName);
        if (isEmpty()){
            front = node;
        }
        else {
            rear.setNextNode(node);
        }
        rear = node;
        length++;

    }

    // dequeue method for queue
    public String dequeue(){
        String frontTag = front.getTagName();
        front = front.getNextNode();
        length--;
        if(isEmpty()){
            rear = null;
        }
        return frontTag;

    }

    // method to return tag name of first element in the queue
    public String first(){
        return front.getTagName();
    }

    public boolean isEmpty(){
        return length == 0;
    }

    public int size(){
        return length;
    }



}