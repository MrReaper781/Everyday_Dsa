// You are using Java
import java.util.*;
public class Main{
    // Adding Queens without conflict;
    
    // public static void nQueens(char[][] board, int row){
    //     if(row == board.length){
    //         printBoard(board);
    //         return;
    //     }
        
    //     for(int j=0; j<board.length; j++){
    //         board[row][j] = 'Q';    // adding queens without conflict
    //         nQueens(board, row+1);
    //         board[row][j] = 'x';    //  Backtracking
    //     }
    // }
    
    public static boolean isSafe(char[][] board, int row, int col){
        // Vertical
        for(int i=row-1; i>=0; i--){
            if(board[i][col] == 'Q'){
                return false;
            }
        }
        // Diagonal left
        for(int i=row-1,j=col-1; i>=0 && j>=0; i--,j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        // Diagonal right
        for(int i=row-1,j=col+1; i>=0 && j<board.length; i--,j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        
        return true;
    }
    
    public static void nQueens(char[][] board, int row){
        if(row == board.length){
            printBoard(board);
            return;
        }
        
        for(int j=0; j<board.length; j++){
            if(isSafe(board, row, j)){
                board[row][j] = 'Q';
                nQueens(board, row+1);
                board[row][j] = '.';    //  Backtracking
            }
        }
    }
    
    public static void printBoard(char[][] board){
        System.out.println("----------Chess Board----------");
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] board = new char[n][n];
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                board[i][j] = '.';
            }
        }
        nQueens(board,0);
    }
}