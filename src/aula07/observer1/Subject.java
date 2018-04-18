package aula07.observer1;

public interface Subject {

    /**
     * Adiciona um novo Observer à lista a notificar.
     */
    void addObserver(Observer obs);

    /**
     * Remove um Observer da lista.
     */
    void delObserver(Observer obs);

    /**
     * Notifica todos os Observers registados.
     */
    void notifyObservers();

}