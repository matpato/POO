package aula07.observer2;

public abstract class Observer implements ObserverI {

    Subject data;

    public Observer(Subject d) { data = d; }
}
