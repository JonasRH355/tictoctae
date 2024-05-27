public class Model {
    private int table[][] = {{2,2,2},{2,2,2},{2,2,2}};   // The "map" where we'll play
    private int[] Valuestab = {1,1,1,1,1,1,1,1};

    public int reloadAddValTab (int x, int y){
        setvaluetabone();
        int soma = 0;
        int indexaux = 0;
        int lasttab[][] = {{0,0,0},{0,0,0},{0,0,0}};

        for(int i =0; i<3;i++){
            for(int j= 0; j<3;j++){
                lasttab[i][j] = table[i][j];
            }
        }

        lasttab[x][y]= 3;

        for(int i =0; i<3;i++){
            for(int j= 0; j<3;j++){
                Valuestab[indexaux] *= lasttab[i][j];
            }
            indexaux++;
        }
        for(int j=0;j<3;j++){
            for(int i=0;i<3;i++){
                Valuestab[indexaux] *= lasttab[i][j];
            }
            indexaux++;
        }
        
        Valuestab[6] = lasttab[0][0]*lasttab[1][1]*lasttab[2][2];
        Valuestab[7] = lasttab[2][0]*lasttab[1][1]*lasttab[0][2];

        for(int i = 0; i<Valuestab.length;i++){
            soma += Valuestab[i];
        }
    
        return soma;
    }

    private void setvaluetabone() {
        int indexaux= 0;
        for(int i =0; i<3;i++){
            for(int j= 0; j<3;j++){
                Valuestab[indexaux] = 1;
            }
            indexaux++;
        }
        for(int j=0;j<3;j++){
            for(int i=0;i<3;i++){
                Valuestab[indexaux] = 1;
            }
            indexaux++;
        }
        
        Valuestab[6] = 1;
        Valuestab[7] = 1;
    }

    public boolean reloadAddValTab (){   // Function to reload the summation of columns, rows, mains diagonal ...
        cleanAddValue();
        int indexaux= 0;
        for(int i =0; i<3;i++){
            for(int j= 0; j<3;j++){
                Valuestab[indexaux] += table[i][j];
            }
            indexaux++;
        }
        for(int j=0;j<3;j++){
            for(int i=0;i<3;i++){
                Valuestab[indexaux] += table[i][j];
            }
            indexaux++;
        }
        
        Valuestab[6] = table[0][0]+table[1][1]+table[2][2];
        Valuestab[7] = table[2][0]+table[1][1]+table[0][2];
        return true;
    }
    
    private void cleanAddValue() {  // Clean the addValue to {0000000}
        int indexaux= 0;
        for(int i =0; i<3;i++){
            for(int j= 0; j<3;j++){
                Valuestab[indexaux] = 0;
            }
            indexaux++;
        }
        for(int j=0;j<3;j++){
            for(int i=0;i<3;i++){
                Valuestab[indexaux] = 0;
            }
            indexaux++;
        }
        
        Valuestab[6] = 0;
        Valuestab[7] = 0;
    }

    public int getInTabuleiro(int i,int j){  // Get value to the desired position
        return this.table[i][j];
    }

    public boolean setInTabuleiro (int i, int j, int variavel){  // Set the value to the desired position
        this.table[i][j] = variavel;
        return true;
    }

    public int getValuestab(int index){
        return this.Valuestab[index];
    }

}
