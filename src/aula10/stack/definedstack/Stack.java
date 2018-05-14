package aula10.stack.definedstack;
import java.util.Iterator;

@SuppressWarnings("ALL")
public class Stack<T> implements Iterable<T> {

    private final T[] elems;
    private int size = 0;

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private int idx = size - 1;

            public boolean hasNext() {
                return idx >= 0;
            }

            public T next() {
                return elems[idx--];
            }
        };
    }


    Stack(int dim) {
        elems = (T[]) new Object[dim];
    }

    // push(Object item) method is used to Pushes an item onto the top of this definedstack
    void push(T e) throws StackFullException {
        //if (size == elems.length)
        //    throw new StackFullException(size);
        try {
            elems[size] = e;
            ++size;
        } catch (IndexOutOfBoundsException ex) {
            throw new StackFullException(size, ex);
        }
    }

    // pop() method is used to Removes the object at the top of this definedstack and
    // returns that object as the value of this function
    T pop() throws StackEmptyException {
        //if (size==0) throw new StackEmptyException(elems.length);
        try {
            //return elems[--size];
            T e = elems[size - 1];
            --size;
            return e;
        } catch (IndexOutOfBoundsException ex) {
            throw new StackEmptyException(elems.length, ex);
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }


    public static void main(String[] args) {
        try {
            // creating definedstack
            Stack<String> stk = new Stack<>(10);
            // populating definedstack
            stk.push("Java");
            stk.push("Source");
            stk.push("code");
            // checking elements

            for (String s : stk)
                System.out.print(s + " ");

            System.out.println("\n< -------------------- >");
            while (!stk.isEmpty())
                System.out.println(stk.pop());

        } catch (StackException e) {
            System.out.println("Erro: " + e);
        }


        System.out.println("< -------------------- >");
        // creating definedstack
        Stack st = new Stack(10);

        // populating definedstack
        //noinspection unchecked
        st.push("Java");
        st.push("Source");
        st.push("code");

        // checking elements
        System.out.println("Elements in the definedstack: " + st);
    }
}
