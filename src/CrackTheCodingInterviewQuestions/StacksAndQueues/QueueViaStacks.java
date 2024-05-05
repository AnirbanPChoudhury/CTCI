package CrackTheCodingInterviewQuestions.StacksAndQueues;

import static Helper.Helper.db;

public class QueueViaStacks {
    Stack stk1;
    Stack stk2;

    public QueueViaStacks() {
        stk1 = new Stack();
        stk2 = new Stack();
    }

    public void enqueue(int data) {
        stk1.push(data);
    }

    public int dequeue() throws Exception {
        if (stk2.top == -1) {
            while (stk1.top != -1) {
                stk2.push(stk1.pop());
            }
        }

        if (stk2.top != -1) {
            return stk2.pop();
        } else throw new Exception("Queue Empty");
    }

    public int peek() throws Exception {
        if(stk2.top == -1) {
            while(stk1.top != -1) stk2.push(stk1.pop());
        }

        if (stk2.top != -1) {
            return stk2.peek();
        } else throw new Exception("Queue Empty");
    }

    public static void main(String[] args) throws Exception {
        QueueViaStacks q = new QueueViaStacks();

        q.enqueue(23);
        q.enqueue(3);
        q.enqueue(563);
        q.enqueue(983);
        q.enqueue(-34);

        db("\nDQ: ", q.dequeue());
        db("\nDQ: ", q.dequeue());
        db("\nDQ: ", q.dequeue());
        db("\nDQ: ", q.dequeue());
        db("\nDQ: ", q.dequeue());
        q.enqueue(0);
        db("\nDQ: ", q.dequeue());
    }
}
