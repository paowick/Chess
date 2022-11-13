
package board;

import java.util.ArrayList;


public class board {
    bishop trash = new bishop("test",9,9,true);
    
    
    void move(String currentposition,String targetposition,figure[][] board){
        int currentpositionrow = Integer.parseInt(String.valueOf(currentposition.charAt(1))); 
        int currentpositioncol = trash.turnToInt(currentposition.charAt(0)); 
        int targetpositionrow = Integer.parseInt(String.valueOf(targetposition.charAt(1)));
        int targetpositioncol = trash.turnToInt(targetposition.charAt(0));
        currentpositionrow -=1;
        targetpositionrow -=1;
        
        
        if((board[currentpositionrow][currentpositioncol] == null)){
            System.out.println("the position of your choice is is  null");
            return;
        }else if(board[currentpositionrow][currentpositioncol].moveable(board).contains(targetposition)&&board[currentpositionrow][currentpositioncol] != null ){
            if ((targetpositionrow > board.length || targetpositionrow < 0 )&&(targetpositioncol > board.length || targetpositioncol < 0)||(board[currentpositionrow][currentpositioncol] == null)){
                System.out.println("it's can't be baka!!!!!");
                System.out.println("----------------------------------------------");
            }else if (null == board[targetpositionrow][targetpositioncol ]){
                board[targetpositionrow][targetpositioncol] =  board[currentpositionrow][currentpositioncol]; 
                board[currentpositionrow][currentpositioncol] = null;
                board[targetpositionrow][targetpositioncol].PositionRow = targetpositionrow;
                board[targetpositionrow][targetpositioncol].PositionColumn = targetpositioncol;
            }else if(board[currentpositionrow][currentpositioncol].isWhite == (board[targetpositionrow][targetpositioncol].isWhite) && null != board[targetpositionrow][targetpositioncol]){
                System.out.println("it's can't be baka!!!!!");
                System.out.println("----------------------------------------------");
            } else {
                board[targetpositionrow][targetpositioncol] =  board[currentpositionrow][currentpositioncol]; 
                board[currentpositionrow][currentpositioncol] = null;
                board[targetpositionrow][targetpositioncol].PositionRow = targetpositionrow;
                board[targetpositionrow][targetpositioncol].PositionColumn = targetpositioncol;
            }
            System.out.println("Move "+currentposition+" to "+targetposition);
        }else{
            System.out.println("cant move to that position");
        }
        
        
       
        String EnamyWhiteKingPosition = findWhiteKing(board);
        String EnamyBlackKingPosition = findBlackKing(board);
        ArrayList<String> moveablelist = new ArrayList<>();
        moveablelist.addAll(board[targetpositionrow][targetpositioncol].moveable(board));
        
        
        if(board[targetpositionrow][targetpositioncol].isIsWhite() == false){
            for(int i = 0;i < moveablelist.size();i++){
                if(moveablelist.get(i).equals(EnamyWhiteKingPosition)){
                    int kingpositionrow = Integer.parseInt(String.valueOf(EnamyWhiteKingPosition.charAt(1)));
                    int kingpositioncol = trash.turnToInt(EnamyWhiteKingPosition.charAt(0));
                    kingpositionrow -=1;
                    board[kingpositionrow][kingpositioncol].setChecked(true);
                    System.out.println("------------------------------------king has been checked------------------------------------------");
                    
                }
            }
        }else if(board[targetpositionrow][targetpositioncol].isIsWhite() == true){
            for(int i = 0;i < moveablelist.size();i++){
                if(moveablelist.get(i).equals(EnamyBlackKingPosition)){
                    int kingpositionrow = Integer.parseInt(String.valueOf(EnamyBlackKingPosition.charAt(1)));
                    int kingpositioncol = trash.turnToInt(EnamyBlackKingPosition.charAt(0));
                    kingpositionrow -=1;
                    board[kingpositionrow][kingpositioncol].setChecked(true);
                    System.out.println("------------------------------------king has been checked------------------------------------------");
                    
                
                }  
            }
        } 
    }
    
    String findWhiteKing(figure[][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                if((board[i][j] != null) && (board[i][j].isKing() == true) && (board[i][j].isIsWhite() == true)){
                    return trash.sumposition(i+1, j);
                    }    
                }       
            } 
        return null;
        }
    String findBlackKing(figure[][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                if((board[i][j] != null) && (board[i][j].isKing() == true)&& (board[i][j].isIsWhite() == false)){
                    return trash.sumposition(i+1, j);
                    }    
                }       
            } 
        return null;
        }
    
    void show (figure x,figure[][] board ){  
        x.moveable(board);    
    }
    
    void showup(figure[][] board){
        System.out.print("        A            B           C           D           E           F           G           H");
        System.out.println();
        for(int i=0;i<board.length;i++){
            System.out.print(i+1+"  ");
            for(int j=0;j<board.length;j++){
                if(board[i][j] == null){
                    System.out.print( " [         ]");
                }else{   
                    System.out.print(" [  "+board[i][j].getName() + "  ]");  
                }   
            }
            System.out.println();    
        }
    }
    
    void showUpmoveable(figure[][] board,figure x){
        System.out.print("        A            B           C           D           E           F           G           H");
        System.out.println();
        for(int i=0;i<board.length;i++){
            System.out.print(i+1+"  ");
            for(int j=0;j<board.length;j++){
                if(x.moveable(board).contains(x.sumposition(i+1,j))){
                    if((board[i][j] != null)&&(x.isIsWhite() != board[i][j].isIsWhite())){
                        System.out.print( " [ |"+board[i][j].getName()+"| ]");
                    }else{
                      System.out.print( " [    *    ]");  
                    }
                }else if(board[i][j] == null){
                    System.out.print( " [         ]");
                }else{
                    System.out.print(" [  "+board[i][j].getName() + "  ]");    
                }   
            }
            System.out.println();    
        }
    }
    
     void showAllOff_movelist(figure[][] board){
       System.out.println("------------------------all of moveablelist--------------------------");
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                if(board[i][j] != null){
                    System.out.println(board[i][j].getName()+board[i][j].moveable(board));
                    
                    
                    
                }       
            }
        } 
    }
}

        
    

