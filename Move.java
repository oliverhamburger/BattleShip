/** Class represents a move on a battle ship board, Move has a x and y position
to dertermine the sopt the player or computer is trying to make*/
public class Move{
   private int row; /** the row of the move */
   private int col; /* the column of the move */
   
   /** Creates a Move object from two integers representing the indices in a two dimensional array.
   @param row of the move as an int
   @param col of the move as an int */
   public Move(int row, int col){
      this.row = row;
      this.col = col;
   }
   
   /** Creates a move object from a String consisting of a letter and a number. Facilitates interaction with user
      interface. 
      @param string of two chars to represent a move, first a leter for the row and then an int for the col */
   public Move(String pos){
      //converts char of row to an int and sets to instance value 
      this.row = ((pos.charAt(0)-'A'));
      //converts char of col to an int and sets to instance value 
      this.col = letterToIndexCol(pos);
   }
   
   /** Accessor for row. Using 'row' rather than 'getRow' allows for more compact code when manipulating
   ArrayLists. 
   @return the row as an int */
   public int row(){
      return this.row;
   }
   
   /** Accessor for col. Using 'col' rather than 'getCol' allows for more compact code when manipulating
   arrayLists.
   @return the col as an int */
   public int col(){
      return this.col;
   }
   
   /** @return a 2 to 3 character string consisting of a letter in the range A-J followed by a number in the range
   1-10. Provides for ease of display of move values in an interface.*/
   public String toString(){
       String theRow = numberToIndexRow(this.row);
       String theCol = Integer.toString(this.col+1);
       return theRow+theCol;
   }
   
   /** Helper function converts a string col to the int equivalent
      @return col as an int */
   private int letterToIndexCol(String pos){
   //allows 10 to be entered, handels the two digit string
   //otherwise handels as 1 digit string
      if(pos.length() == 3){
         return Integer.parseInt((pos.substring(1))) - 1;
      }else{
         return Character.getNumericValue((pos.charAt(1))) - 1;
      }
   }
   
   /** Helper function converts a int row to the string equivalent
      @return row as a string*/
   private String numberToIndexRow(int pos){
      switch(pos){
         case(0):
            return "A";
         case(1):
            return "B";
         case(2):
            return "C";
         case(3):
            return "D";
         case(4):
            return "E";
         case(5):
            return "F";
         case(6):
            return "G";
         case(7):
            return "H";
         case(8):
            return "I";
         case(9):
            return "J";  
      }
      //something went wrong
      return " ";
   }


}