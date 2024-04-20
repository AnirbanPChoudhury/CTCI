package CrackTheCodingInterviewQuestions.LinkedLists;

import Utilities.LinkedList;
import Utilities.Node;

import java.util.ArrayList;
import java.util.List;

import static Helper.Helper.db;

public class Partition {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>(3);
        ll.insertAtEnd(5);
        ll.insertAtEnd(8);
        ll.insertAtEnd(5);
        ll.insertAtEnd(10);
        ll.insertAtEnd(2);
        ll.insertAtEnd(1);
        db("\nInput: ","");
        ll.traverseList();

        LinkedList<Integer> part = makePartition(5, ll);
        db("\nOutput: ", "");
        part.traverseList();
    }

    static LinkedList<Integer> makePartition(int x, LinkedList<Integer> ll) {
        Node<Integer> itr = ll.getHead();
        List<Integer> values = new ArrayList<>();

        while(itr != null) {
            values.add(itr.getData());
            itr = itr.getNextNode();
        }
        db("\nList: ", values);

        LinkedList<Integer> partitioned = new LinkedList<>();

        values.forEach(value -> {
            if(value < x) partitioned.insertAtBeginning(value);
            else partitioned.insertAtEnd(value);
        });

        return partitioned;
    }
}
