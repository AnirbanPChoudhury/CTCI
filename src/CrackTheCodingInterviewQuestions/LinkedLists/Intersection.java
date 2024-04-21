package CrackTheCodingInterviewQuestions.LinkedLists;

import Utilities.LinkedList;
import Utilities.Node;

import java.util.HashSet;
import java.util.Set;

import static Helper.Helper.db;

public class Intersection {
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
        l1.traverseList();

        LinkedList<String> l2 = new LinkedList<>();
        l2.insertAtEnd(n5);
        l2.insertAtEnd(n6);
        //l2.insertAtEnd(n3);
        l2.traverseList();

        db("\nIntersection At: ", intersection(l1, l2));
    }

    static String intersection(LinkedList<String> l1, LinkedList<String> l2) {
        Set<Node<String>> set = new HashSet<>();

        Node<String> itr = l1.getHead();
        while(itr != null) {
            set.add(itr);
            itr = itr.getNextNode();
        }

        itr = l2.getHead();
        while(itr != null) {
            if(!set.add(itr)) return itr.getData();
            itr = itr.getNextNode();
        }

        return "null";
    }
}
