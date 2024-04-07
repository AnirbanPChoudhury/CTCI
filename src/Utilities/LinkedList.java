package Utilities;

import static Helper.Helper.db;
import static Helper.Helper.dbnl;

public class LinkedList<T> {
    Node<T> head;

    public LinkedList(T data){
        Node<T> node = new Node<>(data);
        this.head = node;
    }

    public void insertAtBeginning(T data) {
        Node<T> node = new Node<>(data);
        node.nextNode = head;
        this.head = node;
    }

    public void insertAtEnd(T data) {
        Node<T> node = new Node<>(data);
        Node<T> itr = head;

        while(itr.nextNode != null) {
            itr = itr.nextNode;
        }

        itr.nextNode = node;
        node.nextNode = null;
    }

    public void removeNode(T data) {
        Node<T> itr = head;

        while(itr.nextNode != null) {
            if(itr.nextNode.data == data) {
                itr.nextNode = itr.nextNode.nextNode;
                return;
            }
            itr = itr.nextNode;
        }
    }

    public void traverseList() {
        Node<T> itr = head;
        dbnl("Head -> ", head.data);

        while(itr != null) {
            db(" -> ", itr.data);
            itr = itr.nextNode;
        }
    }

    public Node<T> getHead() {
        return this.head;
    }

    public static void main(String[] args) {
        LinkedList<String> l = new LinkedList<>("A");
        l.insertAtBeginning("B");
        l.insertAtEnd("C");
        l.removeNode("A");

        l.traverseList();
    }
}
