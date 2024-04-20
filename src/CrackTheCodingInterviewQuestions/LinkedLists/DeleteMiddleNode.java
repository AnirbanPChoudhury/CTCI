package CrackTheCodingInterviewQuestions.LinkedLists;

import static Helper.Helper.*;
import Utilities.LinkedList;
import Utilities.Node;

public class DeleteMiddleNode {
    public static void main(String[] args) {
        LinkedList<String> ll = new LinkedList<>("Head");
        ll.insertAtEnd("A");
        ll.insertAtEnd("B");
        ll.insertAtEnd("C");
        ll.insertAtEnd("D");
        ll.traverseList();
        db("\nLength: ", ll.length);
        deleteMidNode("A", ll);
        ll.traverseList();
    }

    static void deleteMidNode(String nodeData, LinkedList<String> ll) {
        Node<String> itr = ll.getHead();
        if(itr.getData().equals(nodeData)) return;
        else {
            while(itr.getNextNode() != null) {
                if(itr.getData().equals(nodeData)) {
                    ll.removeNode(nodeData);
                    return;
                }
                itr = itr.getNextNode();
            }
        }
    }
}
