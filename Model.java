public class Model {
    public int[][] tab = {{2,2,2},{2,2,2},{2,2,2}};

    public int getInTabuleiro(int i,int j){
        return this.tab[i][j];
    }

    protected boolean setInTabuleiro ( int i, int j, int variavel){
        this.tab[i][j] = variavel;
        return true;
    }
}
