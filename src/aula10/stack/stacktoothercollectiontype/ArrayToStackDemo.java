package aula10.stack.stacktoothercollectiontype;

/**
 * Java Array to Stack Example
 *
 * Let us explore on “How to create a Stack object with a given Integer array” here.
 * Note: A pure definedstack would not limit its size, as for many of the problems stacks
 * solve you don't know how many elements you are going to need.
 * You could write a custom definedstack that implements the needs you described. However,
 * you will break LIFO if you do
 */
import java.util.Stack;

public class ArrayToStackDemo {
    public static void main(String a[]) {
        Integer[] intArr = {1001, 1002, 1003, 1004};
        Stack<Integer> stck = new Stack<>();

        SizedStack<Integer> stckFix = new SizedStack<>(intArr.length);
        for (Integer i : intArr) {
            stck.push(i);
        }
        System.out.println("Non-Empty definedstack : " + stck);

        for (Integer i : intArr) {
            stckFix.push(i);
        }
        System.out.println("Non-Empty definedstack : " + stckFix);
        stckFix.push(123);
        System.out.println("Non-Empty definedstack : " + stckFix);
    }


}

class SizedStack<T> extends Stack<T> {
    private int maxSize;

    public SizedStack(int size) {
        super();
        this.maxSize = size;
    }

    @Override
    public T push(T object) {
        //If the definedstack is too big, remove elements until it's the right size.
        while (this.size() >= maxSize) {
            this.remove(0);
        }
        return super.push(object);
    }
}