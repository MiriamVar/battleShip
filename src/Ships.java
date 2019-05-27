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
                while(z<3 && !generatingShip(i)){
                    z++;
                }
            }
        }
//        for (int i = 1; i < 5; i++) {  // ake dlhe su
//            for (int j = 5; j >1; j--) {//kolko ich je
//                generatingShip(j);
//            }
//        }

//        generatingShip(5);
//
//        generatingShip(4);
//        generatingShip(4);
//
//        generatingShip(3);
//        generatingShip(3);
//        generatingShip(3);
//
//        generatingShip(2);
//        generatingShip(2);
//        generatingShip(2);
//        generatingShip(2);

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
                   if(startP.getX()-1 >=0){
                       gameboard[startP.getX()-1][startP.getY()+i] = -1;
                   }
                   if(startP.getX()+1 <=9){
                       gameboard[startP.getX()+1][startP.getY()+i] = -1;
                   }
               }
               //                   hore dole
               if(startP.getY()-1 >=0){
                   gameboard[startP.getX()][startP.getY()-1] = -1;
               }
               if(startP.getY()+num <=9){
                   gameboard[startP.getX()][startP.getY()+num] = -1;
               }
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
                   if(startP.getY()-1 >=0){
                       gameboard[startP.getX()+i][startP.getY()-1] = -1;
                   }
                   if(startP.getY()+1 <=9){
                       gameboard[startP.getX()+i][startP.getY()+1] = -1;
                   }
               }
               //                   hore dole
               if(startP.getX()-1 >=0){
                   gameboard[startP.getX()-1][startP.getY()] = -1;
               }
               if(startP.getX()+num <=9){
                   gameboard[startP.getX()+num][startP.getY()] = -1;
               }
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
                   if(startP.getX()-1 >=0){
                       gameboard[startP.getX()-1][startP.getY()-i] = -1;
                   }
                   if(startP.getX()+1 <=9){
                       gameboard[startP.getX()+1][startP.getY()-i] = -1;
                   }
               }
               //                   hore dole
               if(startP.getY()+1 <=9){
                   gameboard[startP.getX()][startP.getY()+1] = -1;
               }
               if(startP.getY()-num >=0){
                   gameboard[startP.getX()][startP.getY()-num] = -1;
               }
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
                   if(startP.getY()-1 >=0){
                       gameboard[startP.getX()-i][startP.getY()-1] = -1;
                   }
                   if(startP.getY()+1 <=9){
                       gameboard[startP.getX()+i][startP.getY()-1] = -1;
                   }
               }
               //                   hore dole
               if(startP.getX()-1 >=0){
                   gameboard[startP.getX()-1][startP.getY()] = -1;
               }
               if(startP.getX()+num <=9){
                   gameboard[startP.getX()+num][startP.getY()] = -1;
               }
               return true;
           }
           access= true;
       }
       return false;
    }

    public void printG(){
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if(gameboard[j][i]== -1){
                    gameboard[j][i]=0;
                }
                System.out.print(gameboard[j][i]+" ");
            }
            System.out.println();
        }
    }
}
