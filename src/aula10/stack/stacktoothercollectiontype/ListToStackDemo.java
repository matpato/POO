package aula10.stack.stacktoothercollectiontype;
/**
 * Java List to Stack Example
 *
 * Let us explore on “How to create a Stack object with a given List of Integers” here
 * */
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ListToStackDemo {
    public static void main(String a[]){
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        // Appends all of the elements in the specified Collection to the end of this Vector,
        // in the order that they are returned by the specified Collection's Iterator.
        System.out.println("Non-Empty definedstack addAll Operation : "  + stack.addAll(list));
        System.out.println("Non-Empty definedstack : "  + stack);
    }
}