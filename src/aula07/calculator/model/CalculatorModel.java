package aula07.calculator.model;
/**
 * Created by mpato on 09/04/2018.
 */
public class CalculatorModel {

    private CalculatorListener listener;
    private Cell[][] cells;
    private int[]  values; //First is current, Second is summed.
    private final int LIMIT = 150;

    public CalculatorModel(){
        cells = new Cell[4][3];
        values = new int[] {0, 1};  // for product and negative
//        values = new int[2];      // for sum
    }


    public void setListener(CalculatorListener listener) {
        this.listener = listener;
    }

    public boolean touch(int line, int col) {
        Cell current = cells[line][col];
        current.touch(values);
        if(!isFinished())
            listener.accumulate(values,line,col);
        return true;
    }

    public boolean isFinished() { return values[1] > LIMIT;}

    public void init() {
        int k = 1;
        for(int i = 2; i >= 0; i--) {
            for (int j = 0; j < 3; j++) {
                cells[i][j] = new Number(k++);
            }
        }
        cells[3][0] = new Number(0);
        //cells[3][1]= new Negative();
        cells[3][1]= new Mult();
        //cells[3][1]= new Sum(); // you can change operator +/* inside the class
        cells[3][2]= new Clear();

    }

    public Cell getCell(int i, int j){
        return cells[i][j];
    }


    //SIMILAR LISTENER TO LISTENER FROM POWERPLANT
    public interface CalculatorListener {
        void accumulate(int[] values, int lin, int col);
    }

    public int getHeight() {
        return 4;
    }

    public int getWidth() {
        return 3;
    }
}