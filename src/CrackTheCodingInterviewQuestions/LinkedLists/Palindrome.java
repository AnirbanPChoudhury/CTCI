package CrackTheCodingInterviewQuestions.LinkedLists;

import Utilities.LinkedList;
import Utilities.Node;

import java.util.Stack;

import static Helper.Helper.db;

public class Palindrome {
    public static void main(String[] args) {
        LinkedList<String> ll = new LinkedList<>("r");
        ll.insertAtEnd("a");
        ll.insertAtEnd("d");
        ll.insertAtEnd("a");
        ll.insertAtEnd("r");
        ll.traverseList();

        db("\nisPalindrome -> ", isPalindrome(ll));
    }

    static boolean isPalindrome(LinkedList<String> ll) {
        Stack<String> stk = new Stack<>();

        Node<String> itr = ll.getHead();

        while (itr != null) {
            stk.add(itr.getData());
            itr = itr.getNextNode();
        }

        itr = ll.getHead();

        while (itr != null) {
            if (!stk.pop().equals(itr.getData())) return false;
            itr = itr.getNextNode();
        }

        return true;
    }
}
