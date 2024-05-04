package CrackTheCodingInterviewQuestions.StacksAndQueues;

import java.util.ArrayList;
import java.util.List;

import static Helper.Helper.db;

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
