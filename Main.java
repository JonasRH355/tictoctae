

public class Main {
    public static void main(String[] args) {
        Model jModel = new Model();
        View tabuleiro = new View();



        jModel.setInTabuleiro(0,2,1);
        jModel.setInTabuleiro(0,0,3);
       
        

        tabuleiro.showtable(jModel);
    }
    
}
