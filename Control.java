import java.util.Scanner;

public class Control {
    Model jModel = new Model();
    View table = new View();
    Scanner obj = new Scanner(System.in);   

    public void reloadgame(){
        while (true) {
            
            jModel.setInTabuleiro(0,2,3);
            inPutX();

            System.out.print("\033[H\033[2J");
            System.out.flush();                   // It's a terminal' clear

            table.showtable(jModel);
            jModel.reloadAddValTab();

            break;
        }
    }

    protected void inPutX(){
        System.out.print("Onde vai: (i,j)");
        int i = obj.nextInt();
        int j = obj.nextInt();
        jModel.setInTabuleiro(i,j,1);
    }
}
