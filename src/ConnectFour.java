import java.util.Arrays;

/**
 * connect four class for connect four gui class
 * @author PSwigart
 * @version 5/18/23
 * worked with charles
 */

public class ConnectFour implements BoardGame {


    private int[][] board;
    private int currentPlayer;
    private Position[] winningPositions;
    private int winner;


    /**
     * constructor
     */
    public ConnectFour(){
        newGame();
    }


    /**
     * sort of like another constructor
     */
    @Override
    public void newGame() {
        board = new int[6][7];
        currentPlayer = 1+(int)(Math.random()*2);
        winningPositions = new Position[4];
        winner = 0;
    }


    /**
     * checks to see if the game is over
     * @return
     */
    @Override
    public boolean gameOver() {
        return checkCol() || checkRow() || checkRightDiagonals() || checkLeftDiagonals();
    }

    /**
     * checks if someone has won with a /
     * @return
     */
    public boolean checkLeftDiagonals(){
        for(int j = 3; j >= 0; j--) {
            for(int i = 2; i >= 0; i--){
                if(board[i][j] == 0){
                    break;
                }
                else if(board[i][j] == board[i+1][j+1] && board[i+1][j+1] == board[i+2][j+2] && board[i+2][j+2] == board[i+3][j+3]){
                    winner = board[i][j];
                    winningPositions[0] = new Position(i, j);
                    winningPositions[1] = new Position(i+1, j+1);
                    winningPositions[2] = new Position(i+2, j+2);
                    winningPositions[3] = new Position(i+3, j+3);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * checks columns for \ diagonals
     * @return
     */
    public boolean checkRightDiagonals(){
        for(int j = 0; j <= 3; j++) {
            for(int i = 5; i >= 3; i--){
                if(board[i][j] == 0){
                    break;
                }
                else if(board[i][j] == board[i-1][j+1] && board[i-1][j+1] == board[i-2][j+2] && board[i-2][j+2] == board[i-3][j+3]){
                    winner = board[i][j];
                    winningPositions[0] = new Position(i, j);
                    winningPositions[1] = new Position(i-1, j+1);
                    winningPositions[2] = new Position(i-2, j+2);
                    winningPositions[3] = new Position(i-3, j+3);
                    return true;
                }
            }
        }
        return false;
    }


    //checks columns for vertical connect four
    public boolean checkCol(){
        for(int j = 0; j <= 6; j++) {
            for(int i = 5; i >= 3; i--){
                if(board[i][j] == 0){
                    break;
                }
                else if(board[i][j] == board[i-1][j] && board[i-1][j] == board[i-2][j] && board[i-2][j] == board[i-3][j]){
                    winner = board[i][j];
                    winningPositions[0] = new Position(i, j);
                    winningPositions[1] = new Position(i-1, j);
                    winningPositions[2] = new Position(i-2, j);
                    winningPositions[3] = new Position(i-3, j);
                    return true;
                }
            }
        }
        return false;
    }


    //checks rows for horizontal connect fours
    public boolean checkRow(){
        for(int i = 5; i >= 0; i--){
            for(int j = 0; j <= 3; j++) {
                if(board[i][j] == 0){
                    break;
                }
                else if(board[i][j] == board[i][j+1] && board[i][j+1] == board[i][j+2] && board[i][j+2] == board[i][j+3]){
                    winner = board[i][j];
                    winningPositions[0] = new Position(i, j);
                    winningPositions[1] = new Position(i, j+1);
                    winningPositions[2] = new Position(i, j+2);
                    winningPositions[3] = new Position(i, j+3);
                    return true;
                }
            }
        }
        return false;
    }


    //returns who won
    @Override
    public int getWinner() {
        return winner;
    }


    //returns winning positions
    @Override
    public Position[] getWinningPositions() {
        return winningPositions;
    }




    //checks if column is full
    @Override
    public boolean columnFull(int column) {
        return board[0][column] != 0;
    }


    //checks if you can play and if you can it plays
    @Override
    public void play(int column) {
        if(!columnFull(column)){
            for(int r = 5; r >= 0; r--){
                if(board[r][column] == 0) {
                    board[r][column] = currentPlayer;
                    currentPlayer = (currentPlayer == 1) ? 2 : 1;
                    return;
                }
            }
        }
    }


    //returns the current player
    public int getCurrentPlayer(){
        return currentPlayer;
    }


    //returns the board
    @Override
    public int[][] getBoard() {
        return board;
    }
}



