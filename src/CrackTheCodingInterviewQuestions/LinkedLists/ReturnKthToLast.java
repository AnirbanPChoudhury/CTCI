package CrackTheCodingInterviewQuestions.LinkedLists;

import Utilities.LinkedList;
import Utilities.Node;
import static Helper.Helper.*;
import java.util.ArrayList;
import java.util.List;

public class ReturnKthToLast {
    public static void main(String[] args) {
        LinkedList<String> ll = new LinkedList<>("Head");
        ll.insertAtEnd("K");
        ll.insertAtEnd("TT");
        ll.insertAtEnd("HEW");
        ll.insertAtBeginning("Head2");
        ll.insertAtEnd("END");

        db("Kth element: ", returnKthToLast(ll, 2));
        dbnl("", "\n");
        db("Kth element (w/o using buffer): ", returnKthToLastWithOutBuffer(ll, 2));
    }

    static String returnKthToLast(LinkedList<String> ll, int k) {
        List<String> l = new ArrayList<>();
        Node<String> itr = ll.getHead();

        while(itr != null) {
            l.add(itr.getData());
            itr = itr.getNextNode();
        }

        return l.get(l.size() - k);
    }

    static String returnKthToLastWithOutBuffer(LinkedList<String> ll, int k) {

        int length = 0;

        Node<String> itr = ll.getHead();

        while(itr != null) {
            ++length;
            itr = itr.getNextNode();
        }

        itr = ll.getHead();
        int countIdx = 0;

        while(itr != null) {
            ++countIdx;
            if(countIdx == length - k + 1) {

                return itr.getData();
            }
            itr = itr.getNextNode();
        }

        return "Not Found";
    }
}
