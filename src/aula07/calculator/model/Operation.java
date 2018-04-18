package aula07.calculator.model;

/**
 * Created by cvaz on 20/03/2018.
 */
public abstract class Operation extends Cell {
    protected char c;
    public Operation(char c){
        this.c = c;
    }

    public String toString(){
        return "" + c;
    }

}

