package CrackTheCodingInterviewQuestions.StacksAndQueues;

import Utilities.LinkedList;
import Utilities.Node;

import java.util.ArrayList;

import static Helper.Helper.db;

class Animal {
    String type;
    String name;

    public Animal(String name, String type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Name = " + name + ", Type = " + type;
    }
}

public class AnimalShelter {

    LinkedList<Animal> list = new LinkedList<>();

    void enqueue(Animal animal) {
        list.insertAtEnd(animal);
    }

    Animal dequeue() {
        return list.popHead();
    }

    Animal dequeueDog() {
        Node<Animal> itr = list.getHead();

        while(itr.getNextNode() != null) {
            if(itr.getNextNode().getData().type.equalsIgnoreCase("dog")) {
                Animal ret = itr.getNextNode().getData();
                itr.nextNode = itr.getNextNode().getNextNode();

                return ret;
            }
            itr = itr.getNextNode();
        }

        return null;
    }

    Animal dequeueCat() {
        Node<Animal> itr = list.getHead();

        while(itr.getNextNode() != null) {
            if(itr.getNextNode().getData().type.equalsIgnoreCase("cat")) {
                Animal ret = itr.getNextNode().getData();
                itr.nextNode = itr.getNextNode().getNextNode();

                return ret;
            }
            itr = itr.getNextNode();
        }

        return null;
    }

    public static void main(String[] args) {
        AnimalShelter shelter = new AnimalShelter();

        Animal a1 = new Animal("a1", "dog");
        Animal a2 = new Animal("a2", "dog");
        Animal a3 = new Animal("a3", "cat");
        Animal a4 = new Animal("a4", "dog");

        shelter.enqueue(a1);
        shelter.enqueue(a2);
        shelter.enqueue(a3);
        shelter.enqueue(a4);

        db("\n Dequeue: ", shelter.dequeueCat());
        shelter.list.traverseList();
    }
}
