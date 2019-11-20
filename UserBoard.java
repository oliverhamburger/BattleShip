/** Class extends board and represents a UserBoard. A UserBoard maintains a list of all possible moves. Initially, it will be all locations on the Board. When the computer
takes a turn, it random selects an item from this list and removes it from the list. */
import java.util.*;
import java.io.*;

public class UserBoard extends Board{
   private ArrayList<Move> moves; /** List of at the possible different moves */
   private ArrayList<Move> chosenMoves; /**List of already chosen moves */
   private Random rand; /** Random object to create random numbers */
     
   /** Passes the filename on to the Board constructor. Initialize the Random object and the ArrayList of all possible
   Moves. 
   @param filename as a string*/
   public UserBoard(String fileName) throws IOException{
      super(fileName);
      rand = new Random();
      moves = new ArrayList<Move>();
      chosenMoves = new ArrayList<Move>();
      
      //populate list with a possible moves
      for(int i = 0; i <= 9; i++){
         for(int j = 0; j <=9; j++){
            Move m = new Move(i,j);
            moves.add(m);
         }
      }
   }
   
   /** Method makes the computer move against UserBoard
   @return a list of strings, the first string is where the computer chose as its move,
            the second string is a message if the move sank a ship or not. */
   public String[] makeComputerMove(){
       String[] message = new String[2];
       Move m = pickRandomMove();
              
              
       //makes sure computer doesnt pick the same move twice
       while(chosenMoves.contains(m)){
         m = pickRandomMove();
       }
       chosenMoves.add(m);
       
       
       message[0] = m.toString();
       CellStatus s = getLayout().get(m.row()).get(m.col());
      
      //based on the cell status, updates the apropriate ship and if the ship is sunk, changes all the
      //cells of the ship to sunk status.
      switch(s){
         case SUB:
            if (getFleet().updateFleet(ShipType.ST_SUB)){
               for(int i = 0; i < 10; i++){
                  for(int j = 0; j < 10; j++){
                     if(getLayout().get(i).get(j) == CellStatus.SUB_HIT){
                        getLayout().get(i).set(j,CellStatus.SUB_SUNK);
                     }
                  }
               }
               getLayout().get(m.row()).set(m.col(),CellStatus.SUB_SUNK);
               message[1] = "I sunk your sub";
            }
            break;
        case AIRCRAFT_CARRIER:
            if (getFleet().updateFleet(ShipType.ST_AIRCRAFT_CARRIER)){
               for(int i = 0; i < 10; i++){
                  for(int j = 0; j < 10; j++){
                     if(getLayout().get(i).get(j) == CellStatus.AIRCRAFT_CARRIER_HIT){
                        getLayout().get(i).set(j,CellStatus.AIRCRAFT_CARRIER_SUNK);
                     }
                  }
               }
               getLayout().get(m.row()).set(m.col(),CellStatus.AIRCRAFT_CARRIER_SUNK);
               message[1] = "I sunk your aircraft carrier";
            }
            break;
         case BATTLESHIP:
            if (getFleet().updateFleet(ShipType.ST_BATTLESHIP)){
               for(int i = 0; i < 10; i++){
                  for(int j = 0; j < 10; j++){
                     if(getLayout().get(i).get(j) == CellStatus.BATTLESHIP_HIT){
                        getLayout().get(i).set(j,CellStatus.BATTLESHIP_SUNK);
                     }
                  }
               }
               getLayout().get(m.row()).set(m.col(),CellStatus.BATTLESHIP_SUNK);
               message[1] = "I sunk your battleship";
            }
            break;
        case CRUISER:
            if (getFleet().updateFleet(ShipType.ST_CRUISER)){
               for(int i = 0; i < 10; i++){
                  for(int j = 0; j < 10; j++){
                     if(getLayout().get(i).get(j) == CellStatus.CRUISER_HIT){
                        getLayout().get(i).set(j,CellStatus.CRUISER_SUNK);
                     }
                  }
               }
               getLayout().get(m.row()).set(m.col(),CellStatus.CRUISER_SUNK);
               message[1] = "I sunk your cruiser";
            }
            break;
         
        case DESTROYER:
            if (getFleet().updateFleet(ShipType.ST_DESTROYER)){
               for(int i = 0; i < 10; i++){
                  for(int j = 0; j < 10; j++){
                     if(getLayout().get(i).get(j) == CellStatus.DESTROYER_HIT){
                        getLayout().get(i).set(j,CellStatus.DESTROYER_SUNK);
                     }
                  }
               }
               getLayout().get(m.row()).set(m.col(),CellStatus.DESTROYER_SUNK);
               message[1] = "I sunk your destroyer";
            }
            break;
      }
      applyMoveToLayout(m);
      return message;
   }
   
   /** Method picks a random move for the computer to chose from
   @return a move object*/
   public Move pickRandomMove(){
      int randomNum = rand.nextInt(moves.size());
      return moves.get(randomNum);  
   }
   
   /** @return a String representation of the ComputerBoard, displaying the second character of the String returned by
      the toString method overridden in CellStatus */
   public String toString(){
      String s = "";
      for(int i = 0; i < SIZE; i++){
         s += "\n";
         if(i==0){
               for(int k = 0; k <= 10; k++){
                  if(k!=0){
                     s += k;
                     s += " ";
                  }else{
                     s += "  ";
                  }
               }
               s += "\n";
            }
         s += (char)('A'+i) + " ";
         for(int j = 0; j < SIZE; j++){
            s += getLayout().get(i).get(j).toString().charAt(1) + " ";
         }
      }
      return s;
   }

   
}