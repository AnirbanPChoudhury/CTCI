package CrackTheCodingInterviewQuestions.StacksAndQueues;

import java.util.ArrayList;
import java.util.List;

import static Helper.Helper.db;

public class SetOfStacks {
    List<Stack> setOfStacks;
    int ptrToTop = -1;

    int threshold = 5;

    public SetOfStacks() {
        setOfStacks = new ArrayList<>();
    }

    public void push(int el) {
        if(ptrToTop == -1) {
            ++ptrToTop;
            setOfStacks.add(new Stack());
        }

        if(setOfStacks.get(ptrToTop).elements.size() < threshold) {
            setOfStacks.get(ptrToTop).push(el);
        } else {
            setOfStacks.add(new Stack(el));
            ++ptrToTop;
        }
    }

    public int peek() {
        return setOfStacks.get(ptrToTop).peek();
    }

    public int pop() {
        db("\nTop Index: ", setOfStacks.get(ptrToTop).top);
        if(setOfStacks.get(ptrToTop).top != -1) {
            return setOfStacks.get(ptrToTop).pop();
        } else {
            return setOfStacks.get(--ptrToTop).pop();
        }
    }

    public static void main(String[] args) {
        SetOfStacks set = new SetOfStacks();

        set.push(23);
        set.push(2);
        set.push(66);
        set.push(-9);
        set.push(3);
        set.push(97834);
        set.push(98);
        set.push(92);

        set.push(-23);
        set.push(98);
        set.push(34);

        db("SetOfStacks Size: ", set.setOfStacks.size());
        db("\nSetOfStacks Ptr Top: ", set.peek());
        db("\nStacks 1: ", set.setOfStacks.get(0).elements);
        db("\nStacks 2: ", set.setOfStacks.get(1).elements);
        db("\nStacks 3: ", set.setOfStacks.get(2).elements);
        db("\nTop of Stacks 1: ", set.setOfStacks.get(0).peek());
        db("\nTop of Stacks 2: ", set.setOfStacks.get(1).peek());
        db("\nTop of Stacks 3: ", set.setOfStacks.get(2).peek());
        //db("Popped Value: ", set.pop());
        db("\nPtr Top Value: ", set.ptrToTop);
        db("\nTop Value: ", set.peek());
        db("\n Popped value: ", set.pop());
        db("\nPtr Top Value: ", set.ptrToTop);
        db("\n Popped value: ", set.pop());
        db("\nPtr Top Value: ", set.ptrToTop);
        db("\n Peek Value: ", set.peek());

        db("\nStacks 1: ", set.setOfStacks.get(0).elements);
        db("\nStacks 2: ", set.setOfStacks.get(1).elements);
        db("\nStacks 3: ", set.setOfStacks.get(2).elements);
    }

}
