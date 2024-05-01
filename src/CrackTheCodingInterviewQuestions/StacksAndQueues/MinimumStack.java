package CrackTheCodingInterviewQuestions.StacksAndQueues;

import java.util.ArrayList;
import java.util.List;

import static Helper.Helper.db;

class Stack{
    int top = -1;
    int minValueOfSubStack = Integer.MAX_VALUE;

    List<Integer> elements = new ArrayList<>();

    public Stack(){}

    public Stack(int data) {
        elements.add(data);
        minValueOfSubStack = Math.min(minValueOfSubStack, data);
        top++;
    }

    public void add(int data) {
        elements.add(data);
        minValueOfSubStack = Math.min(minValueOfSubStack, data);
        top++;
    }

    public int getMin() {
        return minValueOfSubStack;
    }
}

public class MinimumStack {
    public static void main(String[] args) {
        Stack stk = new Stack();

        stk.add(34);
        stk.add(21);
        stk.add(1);
        stk.add(25);
        stk.add(-3);
        stk.add(43);

        db("MIn = ", stk.getMin());
    }
}
