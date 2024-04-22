import java.util.Scanner;

public class Control {
    Model jModel = new Model();
    View table = new View();
    Scanner obj = new Scanner(System.in);   

    public void reloadgame(){
        while (true) {
            
            jModel.setInTabuleiro(0,2,1);
            int aux = obj.nextInt();
            jModel.setInTabuleiro(0,0,aux);
            table.showtable(jModel);
            System.out.print(aux);
            jModel.reloadAddValTab();

            break;
        }
    }
}
