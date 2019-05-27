import java.util.Random;

public class Ships {
    private int [][] gameboard;
    private int height;
    private int width;

    public Ships(int height, int width) {
        this.height = height;
        this.width = width;
        this.gameboard = new int[height][width];
        this.generatingShips();
    }

    private class Point{
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    private Point startPoint() {
        Random rand = new Random();
        int x = rand.nextInt(10);
        int y = rand.nextInt(10);
        return new Point(x,y);
    }

    private void generatingShips(){
        for (int i = 5; i > 1; i--) {  // ake dlhe su
            for (int j = 6-i; j >= 1; j--) {//kolko ich je
                int z =0;
                while(!generatingShip(i)){
                    z++;
                }
            }
        }
    }

    private boolean generatingShip(int num){
        Point startP =  startPoint();
        if (gameboard[startP.getX()][startP.getY()] != 0){
            return false;
        }
        if (gameboard[startP.getX()][startP.getY()] == 0){
            boolean access = true;

//           kontorlujem smer hore
            for (int i =1; i<num; i++){
                if (startP.getY()+i>9){
                    access = false;
                    break;
                }
                if(gameboard[startP.getX()][startP.getY()+i] != 0){
                    access = false;
                    break;
                }
            }
            if(access){
                for (int i =0; i<num; i++){
                    gameboard[startP.getX()][startP.getY()+i] = 1;
//                   boky
                    border(startP.getX()+1,startP.getY()+i);
                    border(startP.getX()-1,startP.getY()+i);
                }
                //                   hore dole
                border(startP.getX(),startP.getY()-1);
                border(startP.getX(),startP.getY()+num);
                // diagonal
                border(startP.getX()+1,startP.getY()-1);
                border(startP.getX()+1,startP.getY()+num);
                border(startP.getX()-1,startP.getY()-1);
                border(startP.getX()-1,startP.getY()+num);
                return true;
            }
            access= true;





            //           kontolujem smer doprava
            for (int i =1; i<num; i++){
                if (startP.getX()+i>9){
                    access = false;
                    break;
                }
                if(gameboard[startP.getX()+i][startP.getY()] != 0){
                    access = false;
                    break;
                }
            }
            if(access){
                for (int i =0; i<num; i++){
                    gameboard[startP.getX()+i][startP.getY()] = 1;
//                   boky
                    border(startP.getX()+i,startP.getY()-1);
                    border(startP.getX()+i,startP.getY()+1);
                }
                //                   hore dole
                border(startP.getX()-1,startP.getY());
                border(startP.getX()+num,startP.getY());
                // diagonal
                border(startP.getX()-1,startP.getY()+1);
                border(startP.getX()+num,startP.getY()+1);
                border(startP.getX()-1,startP.getY()-1);
                border(startP.getX()+num,startP.getY()-1);
                return true;
            }
            access= true;





//           kontolujem smer dole
            for (int i =1; i<num; i++){
                if (startP.getY()-i<0){
                    access = false;
                    break;
                }
                if(gameboard[startP.getX()][startP.getY()-i] != 0){
                    access = false;
                    break;
                }
            }
            if(access){
                for (int i =0; i<num; i++){
                    gameboard[startP.getX()][startP.getY()-i] = 1;
//                   boky
                    border(startP.getX()+1,startP.getY()-i);
                    border(startP.getX()-1,startP.getY()-i);
                }
                //                   hore dole
                border(startP.getX(),startP.getY()+1);
                border(startP.getX(),startP.getY()+num);
                // diagonal
                border(startP.getX()+1,startP.getY()+1);
                border(startP.getX()+1,startP.getY()+num);
                border(startP.getX()-1,startP.getY()+1);
                border(startP.getX()-1,startP.getY()+num);
                return true;
            }
            access= true;



            //           kontolujem smer dolava
            for (int i =1; i<num; i++){
                if (startP.getX()-i<0){
                    access = false;
                    break;
                }
                if(gameboard[startP.getX()-i][startP.getY()] != 0){
                    access = false;
                    break;
                }
            }
            if(access){
                for (int i =0; i<num; i++){
                    gameboard[startP.getX()-i][startP.getY()] = 1;
//                   boky
                    border(startP.getX()-i,startP.getY()+1);
                    border(startP.getX()-i,startP.getY()+1);
                }
                //                   hore dole
                border(startP.getX()+1,startP.getY());
                border(startP.getX()-num,startP.getY());
                // diagonal
                border(startP.getX()+1,startP.getY()+1);
                border(startP.getX()-num,startP.getY()+1);
                border(startP.getX()+1,startP.getY()-1);
                border(startP.getX()-num,startP.getY()-1);
                return true;
            }
        }
        return false;
    }

    private void border(int x, int y){
        if (x > 9 || x < 0 || y > 9 || y < 0){

        } else {
            gameboard[x][y] = -1;
        }
    }

    public void printG(){
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if(gameboard[j][i]== -1){
                    gameboard[j][i]=0;
                }
                System.out.print(gameboard[j][i]+"  ");
            }
            System.out.println();
        }
    }
}
