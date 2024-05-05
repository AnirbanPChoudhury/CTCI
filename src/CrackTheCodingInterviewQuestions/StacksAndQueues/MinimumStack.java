package CrackTheCodingInterviewQuestions.StacksAndQueues;

import static Helper.Helper.db;

public class MinimumStack {
    public static void main(String[] args) {
        Stack stk = new Stack();

        stk.push(34);
        stk.push(21);
        stk.push(1);
        stk.push(25);
        stk.push(-3);
        stk.push(43);

        db("MIn = ", stk.getMin());
    }
}
