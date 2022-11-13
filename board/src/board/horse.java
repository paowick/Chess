package board;
import java.util.ArrayList;
public class horse extends figure{
    horse(String name,int positionrow,int positioncol,boolean isWhite){
        super(name,positionrow,positioncol,isWhite);
    }
    @Override
    ArrayList<String> moveable(figure[][] board){
        ArrayList<String> movelist = new ArrayList<>();
        if(board[PositionRow][PositionColumn] == null){
            System.out.println("horse cant do naything");
           
        }else if((board[PositionRow][PositionColumn] != null)){
            
            if(PositionRow-2 > -1){        
                if(PositionColumn+1 < 8){
                    movelist.add(sumposition(PositionRow-1,PositionColumn+1));     
                }
                if(PositionColumn-1 > -1){
                    movelist.add(sumposition(PositionRow-1,PositionColumn-1));
                }
            }
            if(PositionRow+2 < 8 ){
                if(PositionColumn+1 < 8){
                    movelist.add(sumposition(PositionRow+3,PositionColumn+1)); 
                }
                if(PositionColumn-1 > -1){
                    movelist.add(sumposition(PositionRow+3,PositionColumn-1));
                }   
            }
            if(PositionColumn+2 < 8 ){
                if(PositionRow-1 > -1){
                   movelist.add(sumposition(PositionRow,PositionColumn+2)); 
                }
                if(PositionRow+1 < 8){
                   movelist.add(sumposition(PositionRow+2,PositionColumn+2)); 
                }    
            }
            if(PositionColumn-2 > -1 ){
                if(PositionRow-1 > -1){
                   movelist.add(sumposition(PositionRow,PositionColumn-2));
                }
                if(PositionRow+1 < 8){
                   movelist.add(sumposition(PositionRow+2,PositionColumn-2));
                }   
            }    
        }
      return movelist;  
    }
    
}
