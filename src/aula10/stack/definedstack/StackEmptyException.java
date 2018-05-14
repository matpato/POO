package aula10.stack.definedstack;

class StackEmptyException extends StackException {

    StackEmptyException(int size, IndexOutOfBoundsException ex) {
        super(size);
    }
}
