package aula10.stack.stacktoothercollectiontype;
/**
 * Java Stack to List Example
 * Let us explore on “How to create a List object with a Stack of Integers” here*/
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StackToListDemo {
    public static void main(String a[]) {

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        List<Integer> list = new ArrayList<>(stack.size());

        // addAll() method is used for adding all the elements of a list to the another list.
        list.addAll(stack);
        System.out.println("Non-Empty definedstack : " + stack);
        System.out.println("Non-Empty List : " + list);
    }
}
