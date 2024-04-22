public class View {

    public void showtable (Model jogModel) {
        for (int i=0; i<3;i++){
            for (int j=0;j<3;j++){
                System.out.print(XorO(jogModel, i, j));
                switch (j) {
                    case 0:
                        System.out.print(" | ");
                        break;
                    case 1:
                        System.out.print(" | ");
                        break;
                    
                    default:
                        break;
                }
                
            }
            System.out.println();
            String result = (i<2)?("-----------"): ("");;
            System.out.println(result);
        }
        
    }

    private char XorO(Model jogModel, int i, int j){
        switch (jogModel.getInTabuleiro( i, j)) {
            case 1:
                return 'X';

            case 2:
                return ' ';
                

            case 3:
                return 'O';

            default:
                return ' ';
        }
    }
    
}
