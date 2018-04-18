package aula07.observer1;

import java.util.ArrayList;
import java.util.List;

public class MessageBoard implements Subject {

    /**
     * Lista com todos os Observers a notificar.
     */
    private List <Observer> observers;

    /**
     * Ultima mensagem registada.
     */
    private String message;

    public MessageBoard(){
        this.observers = new ArrayList<>();
    }

    public String getMessage() {
        return message;
    }

    /**
     * O método set para alem de atribui um novo valor à
     * mensagem executa o método para notificar os Observers.
     */
    public void setMessage(String message) {
        this.message = message;
        notifyObservers();
    }

    /**
     * Adiciona um novo Observer a ser notificado
     */
    public void addObserver(Observer obs) {
        this.observers.add(obs);
    }

    /**
     * Remove um Observer da lista de Observers a serem notificados.
     */
    public void delObserver(Observer obs) {
        this.observers.remove(obs);
    }

    /**
     * Notifica e actualiza todos o observers registados.
     * Para alem de notificar envia também a nova mensagem.
     */
    public void notifyObservers() {
        for(Observer obs : this.observers){
            obs.update(this.message);
        }
    }
}