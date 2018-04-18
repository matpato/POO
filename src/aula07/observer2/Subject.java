package aula07.observer2;

import java.util.ArrayList;

public class Subject {

    private ArrayList<Observer> observers;
    private Data data;

    public Subject() {

        observers = new ArrayList<>();
    }

    void addObserver(Observer observer) {

        observers.add(observer);
    }

    void delObserver(int idx) {

        observers.remove(idx);
    }

    void setState(Data d) {
        data = d;
        notifyObservers();
    }

    private void notifyObservers() {
        for (Observer obs : observers) {
            obs.update();
        }
    }

    Data getState() {  return data;  }

}