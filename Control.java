import java.util.Scanner;

public class Control {
    Model jModel = new Model();
    View table = new View();
    Scanner obj = new Scanner(System.in);
    boolean loop = true;   

    public void reloadgame(){
        jModel.setInTabuleiro(0,2,3);
        System.out.print("\033[H\033[2J");
        System.out.flush();                   // It's a terminal' clear

        while (loop) {  
            System.out.print("\033[H\033[2J");
            System.out.flush();                   // It's a terminal' clear
            table.showtable(jModel); 
            inPutX();
            jModel.reloadAddValTab();
            if (endGame()) {
                loop=false;
            }

        }
    }

    protected void inPutX(){
        System.out.print("Onde vai: (i,j)");
        int i = obj.nextInt();
        int j = obj.nextInt();
        jModel.setInTabuleiro(i,j,1);
    }

    protected boolean endGame() {
        if(jModel._endgame() == 3){
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("You WIN!");
            return true;
        } else if(jModel._endgame() == 9){
            System.out.print("\033[H\033[2J");
            System.out.flush();
            
            System.out.print("You LOST!");
            return true;
        } else {
            return false;
        }
    }
}
