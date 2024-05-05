package CrackTheCodingInterviewQuestions.StacksAndQueues;

import static Helper.Helper.db;

public class SortStack {
    static Stack sort(Stack stk) {
        Stack temp = new Stack();

        while(stk.top != -1) {
            int t = stk.pop();

            while(temp.top != -1 && temp.peek() > t) {
                stk.push(temp.pop());
            }

            temp.push(t);
        }

        while(temp.top != -1) stk.push(temp.pop());

        return stk;
    }

    public static void main(String[] args) {
        Stack stk = new Stack();

        stk.push(34);
        stk.push(-2);
        stk.push(4334);
        stk.push(3344);

        stk = sort(stk);

        db("\nStack: ", stk.elements);

        db("\nTop: ", stk.peek());
    }
}
