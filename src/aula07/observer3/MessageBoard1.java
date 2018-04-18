package aula07.observer3;

import java.util.Observable;
import java.util.Observer;

public class MessageBoard1 extends Observable {
    private String message;

    public String getMessage() {
        return message;
    }

    public void changeMessage(String message) {
        this.message = message;
        setChanged();
        notifyObservers(message);
    }

    public static void main(String[] args) {
        MessageBoard1 board = new MessageBoard1();
        Student bob = new Student();
        Student joe = new Student();
        board.addObserver(bob);
        board.addObserver(joe);
        board.changeMessage("More Homework!");
    }
}

class Student implements Observer {

    public void update(Observable o, Object arg) {

        System.out.println("Message board changed: " + arg);
    }
}