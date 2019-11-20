/** Class extends board and represents the computers board in a game of battleship*/
import java.util.*;
import java.io.*;

public class ComputerBoard extends Board{

   /** constructs a ComputerBoard object by passing the filename on to the Board constructor
   @param filename as a string */
   public ComputerBoard(String fileName) throws IOException{
      super(fileName);
   }
   
   /** Method takes a move and makes it AGAINST this board
   @param a move object
   @return a string saying if the move sunk a ship on the board*/
   public String makePlayerMove(Move m){
      String message = null;
      //gets the cell status of the position
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
               message = "You sunk my sub";
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
               message = "You sunk my aircraft carrier";
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
               message = "You sunk my battleship";
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
               message = "You sunk my cruiser";
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
               message = "You sunk my destroyer";
            }
            break;
      }
      applyMoveToLayout(m);
      //returs null if hit did not sink, otherwiser return a message you sank my ___
      return message;
   }
   
   
   /** @return a String representation of the ComputerBoard, displaying the first character of the String returned by the
      toString method overridden in CellStatus */
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
            char cell  = getLayout().get(i).get(j).toString().charAt(0);               
             s += cell + " ";
         }
      }
      return s;
   }
}

