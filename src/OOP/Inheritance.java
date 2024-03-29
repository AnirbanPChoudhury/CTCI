package OOP;


import java.util.*;

class Parent {
    int parentValue;
    String parentName;

    int wealth = 9999999;

    //Default constructor
    public Parent() {

    }

    //Object constructor
    public Parent(Parent p) {
        parentValue = p.parentValue;
        parentName = p.parentName;
    }

    //Parameterized constructor
    public Parent(int parentValue, String parentName) {
        this.parentValue = parentValue;
        this.parentName = parentName;
    }

    //Object class is the grandparent of java objects
    @Override
    public String toString() {
        return parentName + ", " + parentValue;
    }

    public void parentMethod() {
        System.out.println("Parent method called");
    }

    public String overriddenMethod() {
        return "Parent";
    }
}

class Child extends Parent {
    int value;
    String name;

    public Child(int val, String nm) {
//        value = val;
//        name = nm;
        super(val, nm);
    }

    public void childMethod() {
        System.out.println("Child method called");
        parentMethod();
    }

    public int wealthInheritedFromMyLovelyFather() {
        return wealth;
    }

    @Override
    public String overriddenMethod() {
        return super.overriddenMethod() + ", Child class";
    }
}

class childOther extends Parent {}


public class Inheritance {
    public static void main(String[] args) {
        Parent father = new Parent(27, "Abhijit");
        Parent mother = new Parent(26, "Momi");

        Child boychildObject = new Child(23, "Hiren");
        Child girlObject = new Child(34, "Komola");
        Parent anotherParent = father;

        anotherParent.parentValue = 65;
        System.out.println(father);
        System.out.println(anotherParent);

        /* int val = parentObject.parentValue;
        * parentObject ~ this
        *
        * */

        System.out.println(girlObject.wealthInheritedFromMyLovelyFather());

        // Use of Super Keyword: 1. to call Parent class' constructor, 2. to call Parent class' method

        //Dynamic Method Dispatch: Super class can refer to any child's class
        Parent p = new Child(34, "Anirban");
        p = father;
        System.out.println(p.overriddenMethod());

        //to stop inheriting use final keyword before a class declaration: Like final class Parent {}
        System.out.println(Arrays.toString(topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
        System.out.println(Arrays.toString(topKFrequent(new int[]{1, 4, 3, 4, 4, 5, 3, 1, 4, 7}, 3)));

    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();

        for(int i: nums) {
            if(!freq.containsKey(i)) {
                freq.put(i, 1);
            } else {
                freq.put(i, freq.get(i) + 1);
            }
        }

        System.out.println(freq);

        Map<Integer, List<Integer>> vToKey = new TreeMap<>(Collections.reverseOrder());
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if(vToKey.get(entry.getValue()) == null) {
                List<Integer> l = new ArrayList<>();
                l.add(entry.getKey());
                vToKey.put(entry.getValue(), l);
            } else {
                List<Integer> l = vToKey.get(entry.getValue());
                l.add(entry.getKey());
                vToKey.put(entry.getValue(), l);
            }
        }

        System.out.println(vToKey);

        int[] res = new int[k];
        int c = 0;
        for(int i:vToKey.keySet()) {
            List<Integer> val = vToKey.get(i);
            if(c >= k) break;
            for(int j=0;j<val.size();++j) {
                res[c] = val.get(j);
                ++c;
            }
        }

        return res;
    }
}
