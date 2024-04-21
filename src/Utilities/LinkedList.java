package Utilities;

import static Helper.Helper.db;
import static Helper.Helper.dbnl;

public class LinkedList<T> {
    Node<T> head;
    public int length = 0;

    public LinkedList() {
        head = null;
    }

    public LinkedList(T data){
        Node<T> node = new Node<>(data);
        ++length;
        this.head = node;
    }

    public void insertAtBeginning(T data) {
        Node<T> node = new Node<>(data);
        if(head == null) head = node;
        else {
            node.nextNode = head;
            this.head = node;
        }
        ++length;
    }

    public void insertAtBeginning(Node<T> node) {
        if(head == null) head = node;
        else {
            node.nextNode = head;
            head = node;
        }
        ++length;
    }

    public void insertAtEnd(T data) {
        Node<T> node = new Node<>(data);

        if(head == null) head = node;
        else {
            Node<T> itr = head;

            while(itr.nextNode != null) {
                itr = itr.nextNode;
            }

            itr.nextNode = node;
            node.nextNode = null;
        }

        ++length;
    }

    public void insertAtEnd(Node<T> node) {
        if(head == null) head = node;
        else {
            Node<T> itr = head;

            while(itr.nextNode != null) {
                itr = itr.nextNode;
            }

            itr.nextNode = node;
            //node.nextNode = null;
        }
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
        --length;
    }

    public void traverseList() {
        Node<T> itr = head;
        db("\n", "");
        while(itr != null) {
            db(" -> ", itr.data);
            itr = itr.nextNode;
        }
        db("\n", "");
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
