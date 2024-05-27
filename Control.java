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
            
            smartBotInput();
            jModel.reloadAddValTab();
            if (endGame()) {
                break;
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
    private int _endgame(){  // check/return who is the winner when is endgame
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

    private boolean betterposition(){
        int better[] = {0,0,0};
        int resol;
        for(int i = 0 ; i < 3; i++){
            for(int j = 0; j<3;j++){
                if(!alreadyHave(i, j)){
                    resol = jModel.reloadAddValTab(i,j);
                    if(resol > better[0]){
                        better[0] = resol;
                        better[1] = i;
                        better[2] = j;
                    }
                }
            }
        }
        jModel.setInTabuleiro(better[1], better[2], 3);
        return true;
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
        betterposition();
        return true;
    }

    // END BOTS____________________________________________________________________
}
