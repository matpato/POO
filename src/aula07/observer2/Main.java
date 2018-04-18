package aula07.observer2;

public class Main {
        public static void main(String[] args) {
            Subject dados = new Subject();
            dados.addObserver(new TabelaObserver(dados));
            dados.addObserver(new BarraObserver(dados));
            dados.addObserver(new PercentagemObserver(dados));

            dados.setState(new Data(7, 3, 1));
            dados.setState(new Data(2, 3, 1));
            dados.delObserver(1);

        }
    }
