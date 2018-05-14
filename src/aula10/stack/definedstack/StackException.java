package aula10.stack.definedstack;

public abstract class StackException extends RuntimeException {
    private final int limit;

    StackException(int size) {
        this(size, null);
    }

    StackException(int size, Exception e) {
        super(e);
        limit = size;
    }

    @Override
    public String getMessage() {
        return "Limit= " + limit;
    }
}
