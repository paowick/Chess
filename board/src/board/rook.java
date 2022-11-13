
package board;

import java.util.ArrayList;


public class rook extends figure{
    rook(String name,int positionrow,int positioncol,boolean isWhite){
        super(name,positionrow,positioncol,isWhite);
}
    @Override
    ArrayList<String> moveable(figure[][] board){
        ArrayList<String> movelist = new ArrayList<>();
        if(board[PositionRow][PositionColumn] == null){
            System.out.println("Rook cant do naything");
            
        }else if(board[PositionRow][PositionColumn] != null){
            
            
            recursivemove_top(this.PositionRow-1,this.PositionColumn,board,movelist);
            recursivemove_bottom(this.PositionRow+1,this.PositionColumn,board,movelist);
            recursivemove_left(this.PositionRow,this.PositionColumn-1,board,movelist);
            recursivemove_right(this.PositionRow,this.PositionColumn+1,board,movelist);
                   
        }
      return movelist;  
    }
        
}