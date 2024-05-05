package CrackTheCodingInterviewQuestions.StacksAndQueues;

import java.util.ArrayList;
import java.util.List;

public class Stack {
    int top = -1;
    int minValueOfSubStack = Integer.MAX_VALUE;

    List<Integer> elements = new ArrayList<>();

    public Stack() {
    }

    public Stack(int data) {
        ++top;
        elements.add(data);
        minValueOfSubStack = Math.min(minValueOfSubStack, data);
    }

    public void push(int data) {
        elements.add(data);
        minValueOfSubStack = Math.min(minValueOfSubStack, data);
        top++;
    }

    public int getMin() {
        return minValueOfSubStack;
    }

    public int peek() {
        return elements.get(top);
    }

    public int pop() {
        int poppedValue = elements.get(top);
        elements.remove(top--);
        return poppedValue;
    }
}
