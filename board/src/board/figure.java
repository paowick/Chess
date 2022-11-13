package board;

import java.util.ArrayList;

public abstract class figure {
    String Name;
    int PositionRow,PositionColumn;
    boolean isWhite;
    
    boolean checked = false;
    boolean King = false;

    
    public boolean isKing() {
        return King;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
    ArrayList<String> moveableking(figure[][] board){
        ArrayList<String> movelist = new ArrayList<String>();
        return movelist;
    }
    
  ArrayList<String> moveable(figure[][] board){
        ArrayList<String> movelist = new ArrayList<String>();
        return movelist;
    }

    public boolean isIsWhite() {
        return isWhite;
    }
    
    public String getName() {
        return Name;
    }

    public int getPositionRow() {
        return PositionRow;
    }

    public void setPositionRow(int PositionRow) {
        this.PositionRow = PositionRow;
    }
    
    public int getPositionColumn() {
        return PositionColumn;
    }

    public void setPositionColumn(int PositionColumn) {
        this.PositionColumn = PositionColumn;
    }
    public void setName(String Name) {
        this.Name = Name;
    }
    String turnToChar(int input){
       
        switch (input){
            case 0:
                return "a";
            case 1:
                return "b";
            case 2:
                return "c";
            case 3:
                return "d";
            case 4:
                return "e";    
            case 5:
                return "f";
            case 6:
                return "g";    
            case 7:
                return "h";
            default: 
                return "";  
        } 
        
    }
     int turnToInt(char input){
        switch (input){
            case 'a':
                return 0;
            case 'b':
                return 1;
            case 'c':
                return 2;
            case 'd':
                return 3;    
            case 'e':
                return 4;
            case 'f':
                return 5;    
            case 'g':
                return 6;
            case 'h':
                return 7;
            default: 
                return 99; 
        }
        
    }
   
     String sumposition(int positionrow,int positioncol){
        return turnToChar(positioncol) + String.valueOf(positionrow);
    }
     
    figure(String name,int positionrow,int positioncol,boolean isWhite){
        this.Name=name;
        this.PositionRow=positionrow-1;
        this.PositionColumn=positioncol-1;
        this.isWhite=isWhite;
        
    }
    figure(String name,int positionrow,int positioncol,boolean isWhite,boolean King){
        this.Name=name;
        this.PositionRow=positionrow-1;
        this.PositionColumn=positioncol-1;
        this.isWhite=isWhite;
        this.King=King;
        
        
    }
    void print(){
        System.out.print(Name+ "|");   
    }
   
    void recursivemove_bottom_right(int positionrow,int positioncol,figure[][] board,ArrayList<String> movelist){
        if((positionrow < 8 && positioncol < 8) && (board[positionrow][positioncol] == null) ){
            movelist.add(sumposition(positionrow+1,positioncol));
            recursivemove_bottom_right(positionrow+1,positioncol+1,board,movelist);  
        }else if((positionrow < 8 && positioncol < 8) && (board[positionrow][positioncol].isWhite != this.isWhite)){
            movelist.add(sumposition(positionrow+1,positioncol));
        }   
    }
    
    void recursivemove_top_left(int positionrow,int positioncol,figure[][] board,ArrayList<String> movelist){
        if((positionrow > -1 && positioncol > -1) && (board[positionrow][positioncol] == null) ){
            movelist.add(sumposition(positionrow+1,positioncol));
            recursivemove_top_left(positionrow-1,positioncol-1,board,movelist);  
        }else if((positionrow > -1 && positioncol > -1 ) && (board[positionrow][positioncol].isWhite != this.isWhite)){
            movelist.add(sumposition(positionrow+1,positioncol));
        }   
    }
    
    void recursivemove_top_right(int positionrow,int positioncol,figure[][] board,ArrayList<String> movelist){
        if((positionrow > -1 && positioncol < 8) && (board[positionrow][positioncol] == null) ){
            movelist.add(sumposition(positionrow+1,positioncol));
            recursivemove_top_right(positionrow-1,positioncol+1,board,movelist);  
        }else if((positionrow > -1 && positioncol < 8 ) && (board[positionrow][positioncol].isWhite != this.isWhite)){
            movelist.add(sumposition(positionrow+1,positioncol));
        }   
    }
    
    void recursivemove_bottom_left(int positionrow,int positioncol,figure[][] board,ArrayList<String> movelist){
        if((positionrow < 8 && positioncol > -1) && (board[positionrow][positioncol] == null) ){
            movelist.add(sumposition(positionrow+1,positioncol));
            recursivemove_bottom_left(positionrow+1,positioncol-1,board,movelist);  
        }else if((positionrow < 8 && positioncol > -1) && (board[positionrow][positioncol].isWhite != this.isWhite)){
            movelist.add(sumposition(positionrow+1,positioncol));
        }   
    }
    
    void recursivemove_top(int positionrow,int positioncol,figure[][] board,ArrayList<String> movelist){
        if((positionrow > -1 ) && (board[positionrow][positioncol] == null) ){
            movelist.add(sumposition(positionrow+1,positioncol));
            recursivemove_top(positionrow-1,positioncol,board,movelist);  
        }else if((positionrow > -1 ) && (board[positionrow][positioncol].isWhite != this.isWhite)){
            movelist.add(sumposition(positionrow+1,positioncol));
        }
        
    }
    void recursivemove_bottom(int positionrow,int positioncol,figure[][] board,ArrayList<String> movelist){
        if((positionrow < 8 ) && (board[positionrow][positioncol] == null) ){
            movelist.add(sumposition(positionrow+1,positioncol));
            recursivemove_bottom(positionrow+1,positioncol,board,movelist);  
        }else if((positionrow < 8 ) && (board[positionrow][positioncol].isWhite != this.isWhite)){
            movelist.add(sumposition(positionrow+1,positioncol));
        }
        
    }
   
    void recursivemove_left(int positionrow,int positioncol,figure[][] board,ArrayList<String> movelist){
        if((positioncol > -1) && (board[positionrow][positioncol] == null) ){
            movelist.add(sumposition(positionrow+1,positioncol));
            recursivemove_left(positionrow,positioncol-1,board,movelist);  
        }else if((positioncol > -1) && (board[positionrow][positioncol].isWhite != this.isWhite)){
            movelist.add(sumposition(positionrow+1,positioncol));
        }   
    }
   
    void recursivemove_right(int positionrow,int positioncol,figure[][] board,ArrayList<String> movelist){
        if((positioncol < 8) && (board[positionrow][positioncol] == null) ){
            movelist.add(sumposition(positionrow+1,positioncol));
            recursivemove_right(positionrow,positioncol+1,board,movelist);  
        }else if((positioncol < 8 ) && (board[positionrow][positioncol].isWhite != this.isWhite)){
            movelist.add(sumposition(positionrow+1,positioncol));
        }   
    }
    
   
    
}



