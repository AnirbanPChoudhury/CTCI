package CrackTheCodingInterviewQuestions.LinkedLists;

import Utilities.LinkedList;
import Utilities.Node;

import java.util.HashSet;
import java.util.Set;

public class RemoveDups {
    public static void main(String[] args) {

        LinkedList<String> l = new LinkedList<>("A");
        l.insertAtBeginning("B");
        l.insertAtBeginning("C");
        l.insertAtBeginning("D");
        l.insertAtBeginning("A");
        l.traverseList();

        removeDupsWithHash(l);
        l.traverseList();

    }

    static LinkedList<String> removeDupsWithHash(LinkedList<String> list) {
        Set<String> set = new HashSet<>();

        Node<String> itr = list.getHead();

        while(itr != null) {
            if(!set.add(itr.getData())) {
                list.removeNode(itr.getData());
            }
            itr = itr.getNextNode();
        }

        return list;
    }

}
