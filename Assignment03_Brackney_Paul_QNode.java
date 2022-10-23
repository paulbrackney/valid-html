// this class represents the objects that will be stored in the queues
// these objects (nodes) have 1 piece of data which is the name of the HTML tag 

public class Assignment03_Brackney_Paul_QNode {

public String tagName;
public Assignment03_Brackney_Paul_QNode nextNode;

// constructor method
public Assignment03_Brackney_Paul_QNode (String tagName){
    this.tagName = tagName;
}

// getter and setter for the tag name of current node
public String getTagName(){
    return tagName;
}

public void setTagName(String tagName){
    this.tagName = tagName;
}

//getter and setter for the next node
public Assignment03_Brackney_Paul_QNode getNextNode(){
    return nextNode;
}

public void setNextNode(Assignment03_Brackney_Paul_QNode nextNode){
    this.nextNode = nextNode;
}

}