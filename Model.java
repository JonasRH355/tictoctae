public class Model {
    public int[][] tabuleiro = {{2,2,2},{2,2,2},{2,2,2}};
    

    public int getInTabuleiro(int i,int j){
        return this.tabuleiro[i][j];
    }

    protected boolean setInTabuleiro (int i, int j, int variavel){
        this.tabuleiro[i][j] = variavel;
        return true;
    }
}
