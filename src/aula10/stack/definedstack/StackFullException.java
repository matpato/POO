package aula10.stack.definedstack;

class StackFullException extends StackException {

    StackFullException(int size, Exception e) {
        super(size,e);
    }
}
