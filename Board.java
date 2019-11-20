/** Class represents a board in the game of battleship*/
import java.util.*;
import java.io.*;

public class Board{
   private ArrayList<ArrayList<CellStatus>> layout; /** layout of the board*/
   private Fleet fleet; /** the fleet that will be on the board*/
   public final int SIZE = 10;
   
   /** Construts a board object by initializing the layout, initially setting all cells to CellStatus.NOTHING. Then calls loadFromFile() and passes it
   filename to add ships to the layout. Initializes Fleet.
   @param file name as a string */
   public Board(String fileName) throws IOException{
      layout = new ArrayList<ArrayList<CellStatus>>();
      //populate borad with cellstaus of nothing
      for(int i = 0; i < SIZE; i++){
         layout.add(new ArrayList<CellStatus>());
         for(int j = 0; j < SIZE; j++){
            (layout.get(i)).add(CellStatus.NOTHING);
         }
         
      }
      
      //init fleet
      fleet = new Fleet();
      
      //read through file, populate ship after each line
      String shipType = "";
      String startPos = "";
      String stopPos = "";
      Scanner infile = new Scanner(new File(fileName));
      while(infile.hasNext()){
         shipType = infile.next();
         //convert string to cell status to be put onto board
         CellStatus ship = CellStatus.NOTHING;
         switch(shipType){
            case "A":
               ship = CellStatus.AIRCRAFT_CARRIER;
               break; 
             case "B":
               ship = CellStatus.BATTLESHIP;
               break;
             case "C":
               ship = CellStatus.CRUISER;
               break;
             case "D":
               ship = CellStatus.DESTROYER;
               break;
             case "S":
               ship = CellStatus.SUB;
               break;
         }
         startPos = infile.next();
         stopPos = infile.next();
         Move start = new Move(startPos);
         Move stop = new Move(stopPos);
         //check to see if move valid/empty for ship to be placed
         if(moveTaken(start) && moveTaken(stop)){
            //if ship will be placed horizontally
            if(start.row() == stop.row()){
               //populates ship on to board
               for(int i = start.col(); i <= stop.col(); i++){
                  getLayout().get(start.row()).set(i,ship);
               }
             //if ship will be placed vertically
             }else if(start.col() == stop.col()){
               //populates shipt on to board
               for(int i = start.row(); i <= stop.row(); i++){
                  getLayout().get(i).set(start.col(),ship);
               }
            }
         }
      }      
   }
   
   /** Method applies a move to layout. If the targeted cell does not contain a ship, it is set to CellStatus.NOTHING_HIT. If it
      contains a ship, the cell is changed from, for instance, CellStatus.SUB to CellStatus.SUB_HIT. It returns the
      original CellStatus of the targeted cell. 
      @param a move object*/
   public void applyMoveToLayout(Move m){      
      CellStatus spot = getLayout().get(m.row()).get(m.col());
      
      //switch statement to check possibilities of spot and execute appropriate action
      switch(spot){
         case NOTHING:
            getLayout().get(m.row()).set(m.col(),CellStatus.NOTHING_HIT);
            break;
         case AIRCRAFT_CARRIER:
            getLayout().get(m.row()).set(m.col(),CellStatus.AIRCRAFT_CARRIER_HIT);
            break;
         case BATTLESHIP:
            getLayout().get(m.row()).set(m.col(),CellStatus.BATTLESHIP_HIT);
            break;
         case CRUISER:
            getLayout().get(m.row()).set(m.col(),CellStatus.CRUISER_HIT);
            break;
         case DESTROYER:
            getLayout().get(m.row()).set(m.col(),CellStatus.DESTROYER_HIT);
            break;
         case SUB:
            getLayout().get(m.row()).set(m.col(),CellStatus.SUB_HIT);
            break;
      }
   }
   
   /** Method takes a move and determines if the spot is available
   @param a move object 
   @return if the move is taken or not by a boolean*/
   public boolean moveTaken(Move m){
      //Takes a move and determines if the spot is available
      CellStatus spot = getLayout().get(m.row()).get(m.col());
      //checks if the spot on the layout has aship or nothing and returns true if so.
      switch(spot){
         case NOTHING:
            return true;
         case SUB:
            return true;
         case AIRCRAFT_CARRIER:
            return true;
         case BATTLESHIP:
            return true;
         case CRUISER:
            return true;
         case DESTROYER:
            return true;
      }
      return false;
   }
   
   /** Returns true if all ships have been sunk, false otherwise.
   @return if the game is over or not by a boolean */
   public boolean gameOver(){
      //Returns true if all ships have been sunk, false otherwise
      return this.fleet.gameOver();
   }
   
   /** Returns a reference to the Fleet object 
   @return a fleet object*/
   public Fleet getFleet(){
      //Returns a reference to the Fleet object
      return this.fleet;
   }
   
   /** Returns a copy of layout for processing by a graphical user interface 
   @return an arraylist of arralists of CellStatus, the layout of the board*/
   public ArrayList<ArrayList<CellStatus>> getLayout(){
      //Returns a copy of layout for processing by a graphical user interface
      return layout;
   }
   
   /** Returns the CellStatus of a cell
   @param row and column of the cell as ints
   @return the CellStatus of that cell*/
   public CellStatus getStatus(int row, int col){
      return layout.get(row).get(col);
   }
} 