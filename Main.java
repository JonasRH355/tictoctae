

public class Main {
    public static void main(String[] args) {
        Model jModel = new Model();
        View tabuleiro = new View();

        tabuleiro.setInTabuleiro(jModel.tab[][],0,0,1);
        tabuleiro.setInTabuleiro(jModel.tab,0,0,3);
       
        

        tabuleiro.showtable();
    }
    
}
