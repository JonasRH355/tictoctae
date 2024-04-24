public class Model {
    public int[][] table = {{2,2,2},{2,2,2},{2,2,2}};   // The "map" where we'll play
    private int[] addValuesTab = {0,0,0,0,0,0,0,0};
    public int endgamevalue;

    protected boolean reloadAddValTab (){   // Function to reload the summation of columns, rows, mains diagonal ...
        cleanAddValue();
        int indexaux= 0;
        for(int i =0; i<3;i++){
            for(int j= 0; j<3;j++){
                addValuesTab[indexaux] += table[i][j];
            }
            indexaux++;
        }
        for(int j=0;j<3;j++){
            for(int i=0;i<3;i++){
                addValuesTab[indexaux] += table[i][j];
            }
            indexaux++;
        }
        
        addValuesTab[6] = table[0][0]+table[1][1]+table[2][2];
        addValuesTab[7] = table[2][0]+table[1][1]+table[0][2];
        return true;
    }
    
    private void cleanAddValue() {
        int indexaux= 0;
        for(int i =0; i<3;i++){
            for(int j= 0; j<3;j++){
                addValuesTab[indexaux] = 0;
            }
            indexaux++;
        }
        for(int j=0;j<3;j++){
            for(int i=0;i<3;i++){
                addValuesTab[indexaux] = 0;
            }
            indexaux++;
        }
        
        addValuesTab[6] = 0;
        addValuesTab[7] = 0;
    }

    public int getInTabuleiro(int i,int j){  // Get value to the desired position
        return this.table[i][j];
    }

    protected boolean setInTabuleiro (int i, int j, int variavel){  // Set the value to the desired position
        this.table[i][j] = variavel;
        return true;
    }

    public int _endgame(){
        for(int index = 0;index<8;index++){
            if(addValuesTab[index] == 9 || addValuesTab[index] == 3){
                System.out.print(addValuesTab[index]);
                return addValuesTab[index];
            }
        }
        return 0;
    }
}
