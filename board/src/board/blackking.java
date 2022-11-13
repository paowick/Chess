
package board;

import java.util.ArrayList;


public class blackking extends figure{
    
    boolean checked = false;
    boolean King = true;
    blackking(String name,int positionrow,int positioncol,boolean isWhite,boolean King){
        super(name,positionrow,positioncol,isWhite,King);
        
}
    @Override
    ArrayList<String> moveable(figure[][] board){
        ArrayList<String> movelist = new ArrayList<>();
        
        
        bishop trash1 = new bishop("trash",9,9,true);
        board trash = new board();
        
        ArrayList<String> enamyAndKingmoveable = new ArrayList<>();
        String EnamyWhiteKingPosition = trash.findWhiteKing(board);
        int kingpositionrow = Integer.parseInt(String.valueOf(EnamyWhiteKingPosition.charAt(1)));
        int kingpositioncol = trash1.turnToInt(EnamyWhiteKingPosition.charAt(0));
        kingpositionrow -=1;
        enamyAndKingmoveable.addAll(board[kingpositionrow][kingpositioncol].moveableking(board));
        enamyAndKingmoveable.addAll(enamymoveable(board));
        //System.out.print(board[kingpositionrow][kingpositioncol].moveableking(board));
        
        
        if(board[PositionRow][PositionColumn] == null){
            System.out.println("king cant do naything");    
        }else if(board[PositionRow][PositionColumn] != null){        
            
            if(!enamyAndKingmoveable.contains(sumposition(PositionRow+1,PositionColumn+1)) && PositionColumn+1 < 8){
                movelist.add(sumposition(PositionRow+1,PositionColumn+1));
            }
            if(!enamyAndKingmoveable.contains(sumposition(PositionRow+1,PositionColumn-1)) && PositionColumn-1 > -1){
                movelist.add(sumposition(PositionRow+1,PositionColumn-1));
            }
            if(!enamyAndKingmoveable.contains(sumposition(PositionRow,PositionColumn)) && PositionRow > 0){
                movelist.add(sumposition(PositionRow,PositionColumn));
            }
            if(!enamyAndKingmoveable.contains(sumposition(PositionRow+2,PositionColumn))&& PositionRow+2 < 9){
                movelist.add(sumposition(PositionRow+2,PositionColumn));
            }
            if(!enamyAndKingmoveable.contains(sumposition(PositionRow,PositionColumn-1))&& PositionRow > 0 && PositionColumn-1 > -1){
                movelist.add(sumposition(PositionRow,PositionColumn-1));
            }
            if(!enamyAndKingmoveable.contains(sumposition(PositionRow+2,PositionColumn-1))&& PositionRow+2 < 9 && PositionColumn-1 > -1){
                movelist.add(sumposition(PositionRow+2,PositionColumn-1));
            }
            if(!enamyAndKingmoveable.contains(sumposition(PositionRow,PositionColumn+1))&&PositionRow > 0 && PositionColumn+1 < 8){
                movelist.add(sumposition(PositionRow,PositionColumn+1));
            }
            if(!enamyAndKingmoveable.contains(sumposition(PositionRow+2,PositionColumn+1))&& PositionRow+2 < 9 && PositionColumn+1 < 8){
                movelist.add(sumposition(PositionRow+2,PositionColumn+1));
            }         
        }
      return movelist;  
    }
    
    ArrayList<String> enamymoveable(figure[][] board){ 
        ArrayList<String> enamymovelist = new ArrayList<>();
            for(int i=0;i<board.length;i++){
                for(int j=0;j<board.length;j++){
                    if(board[i][j] != null && board[i][j] != this && board[i][j].isIsWhite() == true && board[i][j].isKing() == false){   
                        enamymovelist.addAll(board[i][j].moveable(board));   
                    }     
                }
        }return enamymovelist;
    }
    
    
    @Override
    ArrayList<String> moveableking(figure[][] board){
        ArrayList<String> movelist = new ArrayList<>();
        
        
       
        ArrayList<String> enamyAndKingmoveable = new ArrayList<>();
        
       
        //enamyAndKingmoveable.addAll(board[kingpositionrow][kingpositioncol].moveable(board));
        enamyAndKingmoveable.addAll(enamymoveable(board));
        //System.out.print(enamyAndKingmoveable);
        
        
        if(board[PositionRow][PositionColumn] == null){
            System.out.println("king cant do naything");    
        }else if(board[PositionRow][PositionColumn] != null){        
            
            if(!enamyAndKingmoveable.contains(sumposition(PositionRow+1,PositionColumn+1)) && PositionColumn+1 < 8){
                movelist.add(sumposition(PositionRow+1,PositionColumn+1));
            }
            if(!enamyAndKingmoveable.contains(sumposition(PositionRow+1,PositionColumn-1)) && PositionColumn-1 > -1){
                movelist.add(sumposition(PositionRow+1,PositionColumn-1));
            }
            if(!enamyAndKingmoveable.contains(sumposition(PositionRow,PositionColumn)) && PositionRow > 0){
                movelist.add(sumposition(PositionRow,PositionColumn));
            }
            if(!enamyAndKingmoveable.contains(sumposition(PositionRow+2,PositionColumn))&& PositionRow+2 < 9){
                movelist.add(sumposition(PositionRow+2,PositionColumn));
            }
            if(!enamyAndKingmoveable.contains(sumposition(PositionRow,PositionColumn-1))&& PositionRow > 0 && PositionColumn-1 > -1){
                movelist.add(sumposition(PositionRow,PositionColumn-1));
            }
            if(!enamyAndKingmoveable.contains(sumposition(PositionRow+2,PositionColumn-1))&& PositionRow+2 < 9 && PositionColumn-1 > -1){
                movelist.add(sumposition(PositionRow+2,PositionColumn-1));
            }
            if(!enamyAndKingmoveable.contains(sumposition(PositionRow,PositionColumn+1))&&PositionRow > 0 && PositionColumn+1 < 8){
                movelist.add(sumposition(PositionRow,PositionColumn+1));
            }
            if(!enamyAndKingmoveable.contains(sumposition(PositionRow+2,PositionColumn+1))&& PositionRow+2 < 9 && PositionColumn+1 < 8){
                movelist.add(sumposition(PositionRow+2,PositionColumn+1));
            }         
        }
      return movelist;  
    }
    
        
 
}
