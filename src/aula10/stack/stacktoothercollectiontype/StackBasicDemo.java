package aula10.stack.stacktoothercollectiontype;
/**
 * Java Stack is a legacy Collection class.
 * It extends Vector class with five operations to support LIFO (Last In First Out).
 * It is available in Collection API since Java 1.0.
 * <p>
 * As Vector implements List, Stack class is also a List implementation class but does
 * NOT support all operations of Vector or List.
 * As Stack supports LIFO, it is also known as LIFO Lists.
 */

import java.util.EmptyStackException;
import java.util.Stack;

public class StackBasicDemo {
    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        System.out.println("Empty definedstack : " + stack);

        // boolean empty(): Tests if this definedstack is empty
        System.out.println("Empty definedstack : " + stack.isEmpty());

        // <E> pop() : Removes the object at the top of this definedstack and returns
        // that object as the value of this function.
        // ====|> Exception in thread "main" java.util.EmptyStackException
        try{
            System.out.println("Empty definedstack : Pop Operation : "  + stack.pop());
        }catch (EmptyStackException e){
            System.out.println("Message " + e);
        }

        // E push(E item) : Pushes an item onto the top of this definedstack.
        stack.push(1001);
        stack.push(1002);
        stack.push(1003);
        stack.push(1004);
        System.out.println("Non-Empty definedstack : " + stack);

        System.out.println("Non-Empty definedstack: Pop Operation : " + stack.pop());
        System.out.println("Non-Empty definedstack : After Pop Operation : " + stack);

        // int search(Object o) : Returns the 1-based position where an object is on this definedstack
        System.out.println("Non-Empty definedstack : search() Operation : " + stack.search(1002));
        System.out.println("Non-Empty definedstack : " + stack.isEmpty());

    }
}
