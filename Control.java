import java.util.Scanner;
import java.util.Random;

public class Control {
    private Model jModel = new Model();
    private View table = new View();
    private Scanner obj = new Scanner(System.in);
    private boolean loop = true;   

    public void reloadgame(){  // Loop Game Function
        while (loop) {  
            System.out.print("\033[H\033[2J");
            System.out.flush();                   // It's a terminal' clear

            table.showtable(jModel); 
            inPutX();
            jModel.reloadAddValTab();
            if (endGame()) {
                break;
            }
            
            if(loop != false){
                lazyBotInput();
                jModel.reloadAddValTab();
                if (endGame()) {
                    break;
                }
            }
        }
    }

    private void inPutX(){  // Function to input the 'X' in the square/hash
        System.out.print("Onde vai: (i,j)");
        int i = 0;
        int j = 0;
        do{
            i = obj.nextInt();
            j = obj.nextInt();
        }while(alreadyHave(i,j));
        
        jModel.setInTabuleiro(i,j,1);
    }

    private boolean alreadyHave(int i, int j){  // Collision Function
        boolean x = (jModel.getInTabuleiro(i, j) != 2)? true:false;
        return x;
        
    }

    private boolean drawgame(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(!alreadyHave(i, j)){
                    return false;
                }
            }
        }
        return true;
    }
    protected int _endgame(){  // check/return who is the winner when is endgame
        for(int index = 0;index<8;index++){
            if(jModel.getValuestab(index) == 3 || jModel.getValuestab(index) == 9 ){
                return jModel.getValuestab(index);
            }
        }
        return 0;
    }

    private boolean endGame() { // End Game situation
        if(_endgame() == 3){
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("You WIN!");
            return true;
        } 
        if(_endgame() == 9){
            System.out.print("\033[H\033[2J");
            System.out.flush();
            
            System.out.print("You LOST!");
            return true;
        } 
        if(drawgame()){
            System.out.print("\033[H\033[2J");
            System.out.flush();
            
            System.out.print("Draw!");    
            return true;        
        } else {
            return false;
        }
    }

    // BOTS -------------------------------------------------------------------

    private boolean lazyBotInput(){  // Bot that will make a random move
        
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

    private boolean midlleBotInput(){  // Bot that will be more inteligent than lazyBot and less than smartBot
        return true;
    }

    private boolean smartBotInput(){ // SmartBot

        return true;
    }

    // END BOTS____________________________________________________________________
}
