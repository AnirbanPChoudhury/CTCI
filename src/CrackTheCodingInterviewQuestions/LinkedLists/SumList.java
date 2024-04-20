package CrackTheCodingInterviewQuestions.LinkedLists;

import Utilities.LinkedList;
import Utilities.Node;

import static Helper.Helper.db;

public class SumList {
    public static void main(String[] args) {
        LinkedList<Integer> l = new LinkedList<>(7);
        l.insertAtEnd(1);
        l.insertAtEnd(6);
        //l.insertAtEnd(9);
        l.traverseList();

        LinkedList<Integer> l2 = new LinkedList<>(5);
        l2.insertAtEnd(9);
        l2.insertAtEnd(3);
        l2.insertAtEnd(4);
        //l2.insertAtEnd(5);
        l2.traverseList();

        LinkedList<Integer> s = sum(l, l2);
        s.traverseList();
    }

    static LinkedList<Integer> sum(LinkedList<Integer> l1, LinkedList<Integer> l2) {
        LinkedList<Integer> s = new LinkedList<>();

        Node<Integer> i1 = l1.getHead();
        Node<Integer> i2 = l2.getHead();
        int carry = 0;

        while(i1 != null && i2 != null) {
            int sum = i1.getData() + i2.getData() + carry;
            int digit = sum % 10;
            s.insertAtEnd(digit);
            carry = sum / 10;
            i1 = i1.getNextNode();
            i2 = i2.getNextNode();
        }

        while(i1 != null) {
            int sum = i1.getData() + carry;
            int digit = sum % 10;
            s.insertAtEnd(digit);
            carry = sum / 10;
            i1 = i1.getNextNode();
        }
        while(i2 != null) {
            int sum = i2.getData() + carry;
            int digit = sum % 10;
            s.insertAtEnd(digit);
            carry = sum / 10;
            i2 = i2.getNextNode();
        }
        if(carry != 0) s.insertAtEnd(carry);

        return s;
    }
}
