/** Class represents a game of battleship */
import java.util.*;
import java.io.*;

public class Game{
   private ComputerBoard computer; /** The computers battleship board*/
   private UserBoard player; /** The players battleship board */
   
   /** Constructs a game object. Initializes the computer and player boards*/
   public Game() throws IOException{
      computer = new ComputerBoard("compFleet.txt");
      player = new UserBoard("userFleet.txt");
   }
   
   /** Method maks the computer make a move against the player board
      @return a list of strings, the first string is where the computer chose as its move,
            the second string is a message if the move sank a ship or not. */
   public String[] makeComputerMove(){
      return player.makeComputerMove();
   }
   
   /** Method takes a move and makes it against the computer board
   @param a string in the form of a move so it may be converted to a move
   @return a string saying if the move sunk a ship on the board*/
   public String makePlayerMove(String move){
      Move m = new Move(move);
      return computer.makePlayerMove(m);
   }
   
   /** Method returns true if all of the computer's ships have been sunk, false otherwise.
   @return if the game is over or not by a boolean */
   public boolean computerDefeated(){
      return computer.gameOver();
   }
   
   /** Method returns true if all of the player's ships have been sunk, false otherwise.
   @return if the game is over or not by a boolean */
   public boolean playerDefeated(){
      return player.gameOver();
   }
   
   /** Method returns a string representation of the game
   @return a string representation of the computer board and the player board */
   public String toString(){
      return "\nCOMPUTER" + computer.toString() + "\n\n" + "PLAYER" + player.toString();
   }
   
   /** Returns the CellStatus of a the cell of the given row and column 
   from the computer board
   @param the row and column of the cell as ints
   @return the CellStatus of the cell
   */
   public CellStatus getComputerStatus(int row, int col){
      return computer.getStatus(row,col);
   }
   
   /** Returns the CellStatus of a the cell of the given row and column 
   from the player board
   @param the row and column of the cell as ints
   @return the CellStatus of the cell
   */
   public CellStatus getPlayerStatus(int row, int col){
      return player.getStatus(row,col);
   }



   
}