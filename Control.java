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

            System.out.print("\033[H\033[2J");
            System.out.flush();                   // It's a terminal' clear

            table.showtable(jModel);
            jModel.reloadAddValTab();

            break;
        }
    }
}
