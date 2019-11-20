/** Class extends HBox and represents a Cell in the game of battleship */
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.geometry.Pos;
import javafx.scene.text.Text;

class CellPane extends HBox{
   private int row; /** row of the cell*/
   private int col; /** column of the cell*/
   private CellStatus status; /** status of the cell*/
   private Text text; /** text displayed on the cell*/
   private String color; /** color of the cell*/
   private boolean userBoard; /** determins if the cell is a userboard or computer board cell*/ 
   private boolean canBeClicked; /** determins if the cell can be clicked or not */
   
   /** Constructs a cell pane and defines its charachteristics based on 
       which board the cell pane belongs to and the CellStatus of the cell
       @param CellStatus of the cell
       @param row of the cell as an int
       @param column of the cell as an int
       @param boolean that is true if the cell belongs to the userboard, false otherwise*/
   public CellPane(CellStatus status, int row, int col, boolean userBoard){
      this.status = status;
      this.row = row;
      this.col = col;
      this.userBoard = userBoard;
      
         
      if(!userBoard){
         //display computer board
         switch(status){
            case NOTHING: 
               this.setAlignment(Pos.CENTER);
               this.setPrefSize(50,60);
               this.setStyle("-fx-border-width: 5;" +
                         "-fx-border-color: black;"+
                         "-fx-background-color: blue;");
               this.text = new Text();
               this.getChildren().add(this.text);
               this.canBeClicked = true;
               break;
            case AIRCRAFT_CARRIER_HIT:
               this.setAlignment(Pos.CENTER);
               this.setPrefSize(50,60);
               this.setStyle("-fx-border-width: 5;" +
                         "-fx-border-color: black;"+
                         "-fx-background-color: red;");
               this.text = new Text();
               this.getChildren().add(this.text);
               this.canBeClicked = false;
               break;
            case BATTLESHIP_HIT:
               this.setAlignment(Pos.CENTER);
               this.setPrefSize(50,60);
               this.setStyle("-fx-border-width: 5;" +
                         "-fx-border-color: black;"+
                         "-fx-background-color: red;");
               this.text = new Text();
               this.getChildren().add(this.text);
               this.canBeClicked = false;
               break;
            case CRUISER_HIT:
               this.setAlignment(Pos.CENTER);
               this.setPrefSize(50,60);
               this.setStyle("-fx-border-width: 5;" +
                         "-fx-border-color: black;"+
                         "-fx-background-color: red;");
               this.text = new Text();
               this.getChildren().add(this.text);
               this.canBeClicked = false;
               break;
            case SUB_HIT:
               this.setAlignment(Pos.CENTER);
               this.setPrefSize(50,60);
               this.setStyle("-fx-border-width: 5;" +
                         "-fx-border-color: black;"+
                         "-fx-background-color: red;");
               this.text = new Text();
               this.getChildren().add(this.text);
               this.canBeClicked = false;
               break;
            case DESTROYER_HIT:
               this.setAlignment(Pos.CENTER);
               this.setPrefSize(50,60);
               this.setStyle("-fx-border-width: 5;" +
                         "-fx-border-color: black;"+
                         "-fx-background-color: red;");
               this.text = new Text();
               this.getChildren().add(this.text);
               this.canBeClicked = false;
               break;
            case AIRCRAFT_CARRIER_SUNK:
               this.setAlignment(Pos.CENTER);
               this.setPrefSize(50,60);
               this.setStyle("-fx-border-width: 5;" +
                         "-fx-border-color: black;"+
                         "-fx-background-color: yellow;");
               this.text = new Text(5,5, "A");
               this.getChildren().add(this.text);
               this.canBeClicked = false;
               break;
            case BATTLESHIP_SUNK:
               this.setAlignment(Pos.CENTER);
               this.setPrefSize(50,60);
               this.setStyle("-fx-border-width: 5;" +
                         "-fx-border-color: black;"+
                         "-fx-background-color: yellow;");
               this.text = new Text(5,5, "B");
               this.getChildren().add(this.text);
               this.canBeClicked = false;
               break;
            case CRUISER_SUNK:
               this.setAlignment(Pos.CENTER);
               this.setPrefSize(50,60);
               this.setStyle("-fx-border-width: 5;" +
                         "-fx-border-color: black;"+
                         "-fx-background-color: yellow;");
               this.text = new Text(5,5, "C");
               this.getChildren().add(this.text);
               this.canBeClicked = false;
               break;
            case SUB_SUNK:
               this.setAlignment(Pos.CENTER);
               this.setPrefSize(50,60);
               this.setStyle("-fx-border-width: 5;" +
                         "-fx-border-color: black;"+
                         "-fx-background-color: yellow;");
               this.text = new Text(5,5, "S");
               this.getChildren().add(this.text);
               this.canBeClicked = false;
               break;
            case DESTROYER_SUNK:
               this.setAlignment(Pos.CENTER);
               this.setPrefSize(50,60);
               this.setStyle("-fx-border-width: 5;" +
                         "-fx-border-color: black;"+
                         "-fx-background-color: yellow;");
               this.text = new Text(5,5, "D");
               this.getChildren().add(this.text);
               this.canBeClicked = false;
               break;
            case NOTHING_HIT:
               this.setAlignment(Pos.CENTER);
               this.setPrefSize(50,60);
               this.setStyle("-fx-border-width: 5;" +
                         "-fx-border-color: black;"+
                         "-fx-background-color: white;");
               this.text = new Text();
               this.getChildren().add(this.text);
               this.canBeClicked = false;
               break;
            default:
               this.setAlignment(Pos.CENTER);
               this.setPrefSize(50,60);
               this.setStyle("-fx-border-width: 5;" +
                         "-fx-border-color: black;"+
                         "-fx-background-color: blue;");
               char s = status.toString().charAt(1);
               this.text = new Text();
               this.getChildren().add(this.text);
               this.canBeClicked = true;
               break;
            }
      }else{
         //display user board
         switch(status){
            case NOTHING: 
               this.setAlignment(Pos.CENTER);
               this.setPrefSize(50,60);
               this.setStyle("-fx-border-width: 5;" +
                         "-fx-border-color: black;"+
                         "-fx-background-color: blue;");
               this.text = new Text();
               this.getChildren().add(this.text);
               this.canBeClicked = true;
               break;
            case AIRCRAFT_CARRIER_HIT:
               this.setAlignment(Pos.CENTER);
               this.setPrefSize(50,60);
               this.setStyle("-fx-border-width: 5;" +
                         "-fx-border-color: black;"+
                         "-fx-background-color: red;");
               this.text = new Text(5,5, "A");
               this.getChildren().add(this.text);
               this.canBeClicked = false;
               break;
            case BATTLESHIP_HIT:
               this.setAlignment(Pos.CENTER);
               this.setPrefSize(50,60);
               this.setStyle("-fx-border-width: 5;" +
                         "-fx-border-color: black;"+
                         "-fx-background-color: red;");
               this.text = new Text(5,5, "B");
               this.getChildren().add(this.text);
               this.canBeClicked = false;
               break;
            case CRUISER_HIT:
               this.setAlignment(Pos.CENTER);
               this.setPrefSize(50,60);
               this.setStyle("-fx-border-width: 5;" +
                         "-fx-border-color: black;"+
                         "-fx-background-color: red;");
               this.text = new Text(5,5, "C");
               this.getChildren().add(this.text);
               this.canBeClicked = false;
               break;
            case SUB_HIT:
               this.setAlignment(Pos.CENTER);
               this.setPrefSize(50,60);
               this.setStyle("-fx-border-width: 5;" +
                         "-fx-border-color: black;"+
                         "-fx-background-color: red;");
               this.text = new Text(5,5, "S");
               this.getChildren().add(this.text);
               this.canBeClicked = false;
               break;
            case DESTROYER_HIT:
               this.setAlignment(Pos.CENTER);
               this.setPrefSize(50,60);
               this.setStyle("-fx-border-width: 5;" +
                         "-fx-border-color: black;"+
                         "-fx-background-color: red;");
               this.text = new Text(5,5, "D");
               this.getChildren().add(this.text);
               this.canBeClicked = false;
               break;
            case AIRCRAFT_CARRIER_SUNK:
               this.setAlignment(Pos.CENTER);
               this.setPrefSize(50,60);
               this.setStyle("-fx-border-width: 5;" +
                         "-fx-border-color: black;"+
                         "-fx-background-color: yellow;");
               this.text = new Text(5,5, "A");
               this.getChildren().add(this.text);
               this.canBeClicked = false;
               break;
            case BATTLESHIP_SUNK:
               this.setAlignment(Pos.CENTER);
               this.setPrefSize(50,60);
               this.setStyle("-fx-border-width: 5;" +
                         "-fx-border-color: black;"+
                         "-fx-background-color: yellow;");
               this.text = new Text(5,5, "B");
               this.getChildren().add(this.text);
               this.canBeClicked = false;
               break;
            case CRUISER_SUNK:
               this.setAlignment(Pos.CENTER);
               this.setPrefSize(50,60);
               this.setStyle("-fx-border-width: 5;" +
                         "-fx-border-color: black;"+
                         "-fx-background-color: yellow;");
               this.text = new Text(5,5, "C");
               this.getChildren().add(this.text);
               this.canBeClicked = false;
               break;
            case SUB_SUNK:
               this.setAlignment(Pos.CENTER);
               this.setPrefSize(50,60);
               this.setStyle("-fx-border-width: 5;" +
                         "-fx-border-color: black;"+
                         "-fx-background-color: yellow;");
               this.text = new Text(5,5, "S");
               this.getChildren().add(this.text);
               this.canBeClicked = false;
               break;
            case DESTROYER_SUNK:
               this.setAlignment(Pos.CENTER);
               this.setPrefSize(50,60);
               this.setStyle("-fx-border-width: 5;" +
                         "-fx-border-color: black;"+
                         "-fx-background-color: yellow;");
               this.text = new Text(5,5, "D");
               this.getChildren().add(this.text);
               this.canBeClicked = false;
               break;
            case NOTHING_HIT:
               this.setAlignment(Pos.CENTER);
               this.setPrefSize(50,60);
               this.setStyle("-fx-border-width: 5;" +
                         "-fx-border-color: black;"+
                         "-fx-background-color: white;");
               this.text = new Text();
               this.getChildren().add(this.text);
               this.canBeClicked = false;
               break;
            default:
               this.setAlignment(Pos.CENTER);
               this.setPrefSize(50,60);
               this.setStyle("-fx-border-width: 5;" +
                         "-fx-border-color: black;"+
                         "-fx-background-color: blue;");
               char s = status.toString().charAt(1);
               this.text = new Text(5,5, Character.toString(s));
               this.getChildren().add(this.text);
               this.canBeClicked = true;
               break;

         }
         
      }
      
   }
   
   /** Method returns the row of the cell
       @return row of the cell as an int */
   public int getRow(){
      return row;
   }
   
   /** Method returns the column of the cell
       @return column of the cell as an int*/
   public int getCol(){
      return col;
   }
   
   /** Method returns if the cell can be clicked or not
       @return a boolean that is true if the cell can be
        clicked, false otherwise */
   public boolean getCanBeClicked(){
      return canBeClicked;
   }
   
}