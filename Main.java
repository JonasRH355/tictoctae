import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Model jModel = new Model();
        View tabuleiro = new View();
        Scanner obj = new Scanner(System.in);
        while (true) {
            
            jModel.setInTabuleiro(0,2,1);
            int aux = obj.nextInt();
            jModel.setInTabuleiro(0,0,aux);
            tabuleiro.showtable(jModel);
            System.out.print(obj);
            break;
        }

    }
    
}
