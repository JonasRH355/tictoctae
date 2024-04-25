import java.util.Scanner;
import java.util.Random;

public class Control {
    Model jModel = new Model();
    View table = new View();
    Scanner obj = new Scanner(System.in);
    boolean loop = true;   

    public void reloadgame(){
        while (loop) {  
            System.out.print("\033[H\033[2J");
            System.out.flush();                   // It's a terminal' clear

            table.showtable(jModel); 
            inPutX();
            stupidBotInput();
            jModel.reloadAddValTab();
            if (endGame()) {
                loop=false;
            }

        }
    }

    protected void inPutX(){
        System.out.print("Onde vai: (i,j)");
        int i = 0;
        int j = 0;
        do{
            i = obj.nextInt();
            j = obj.nextInt();
        }while(alreadyHave(i,j));
        
        jModel.setInTabuleiro(i,j,1);
    }

    private boolean alreadyHave(int i, int j){
        boolean x = (jModel.table[i][j] != 2)? true:false;
        return x;
        
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

    protected boolean stupidBotInput(){
        
        int i = 0;
        int j = 0;
        do{
            Random rand = new Random();
            i = Math.abs(rand.nextInt())%3;
            rand = new Random();
            j = Math.abs(rand.nextInt())%3;
        }while(alreadyHave(i,j));
        
        jModel.setInTabuleiro(i,j,3);
        return true;
    }
}
