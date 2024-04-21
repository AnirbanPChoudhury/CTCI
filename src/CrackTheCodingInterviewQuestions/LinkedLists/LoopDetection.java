package CrackTheCodingInterviewQuestions.LinkedLists;

import Utilities.LinkedList;
import Utilities.Node;

import java.util.HashSet;
import java.util.Set;

import static Helper.Helper.db;

public class LoopDetection {
    public static void main(String[] args) {
        Node<String> n1 = new Node<>("A");
        Node<String> n2 = new Node<>("B");
        Node<String> n3 = new Node<>("C");
        Node<String> n4 = new Node<>("D");
        Node<String> n5 = new Node<>("E");
        Node<String> n6 = new Node<>("F");

        LinkedList<String> l1 = new LinkedList<>();
        l1.insertAtEnd(n1);
        l1.insertAtEnd(n2);
        l1.insertAtEnd(n3);
        l1.insertAtEnd(n4);
        l1.insertAtEnd(n5);
        l1.insertAtEnd(n6);
        l1.insertAtEnd(n3);
        //l1.traverseList();
        db("\n N6 Next: ", n6.getNextNode().getData());

        db("\nLoop Present -> ", detectLoop(l1));
        db("\nIntersection Point -> ", detectIntersectionPoint(l1));
    }

    /** tortoise and hare approach to detect cycle in a linked list, may not give the same intersection points
     * for different cycle lengths or on the amount of hops the fast pointer makes */

    static String detectLoop(LinkedList<String> l) {
        Node<String> slowPtr = l.getHead();
        Node<String> fastPtr = l.getHead().getNextNode();

        while(slowPtr != fastPtr) {
            if(fastPtr == null || fastPtr.getNextNode() == null) return "false";
            slowPtr = slowPtr.getNextNode();
            fastPtr = fastPtr.getNextNode().getNextNode();
        }
        return fastPtr.getData();
    }

    static String detectIntersectionPoint(LinkedList<String> l) {
        Set<Node<String>> set = new HashSet<>();

        Node<String> itr = l.getHead();

        while(itr != null) {
            if(!set.add(itr)) return itr.getData();
            itr = itr.getNextNode();
        }

        return "Null";
    }

}
