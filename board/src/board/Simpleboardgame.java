
package board;



public class Simpleboardgame {

    public static void main(String[] args) {
        
        figure[][] chessboard = new figure[8][8];
        board board = new board();
        
        
       
        whiteking Wki01 = new whiteking("Wki01",2,5,true,true);
        blackking Bki01 = new blackking("Bki01",2,3,false,true);
        horse Bho01 = new horse("Bho01",6,1,false);
        rook test1 = new rook("test1",6,4,true);
        chessboard[Wki01.getPositionRow()][Wki01.getPositionColumn()] = Wki01;
        chessboard[Bki01.getPositionRow()][Bki01.getPositionColumn()] = Bki01;
        chessboard[Bho01.getPositionRow()][Bho01.getPositionColumn()] = Bho01;
        chessboard[test1.getPositionRow()][test1.getPositionColumn()] = test1;
        
        
        
        board.showup(chessboard);
       
       //board.move("e2", "d2", chessboard);
        
        board.showup(chessboard);
        
        board.showAllOff_movelist(chessboard);
        board.showUpmoveable(chessboard,Wki01);
        board.showUpmoveable(chessboard,Bki01);  
        
    }
}  
    
  



