import javafx.application.Application; 
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.paint.Color;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.*;

import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.geometry.Pos;

import java.io.*;


public class BattleShipGUI extends Application{

   private Game game; //guts of the game
   private GridPane userBoard; //userboard as a gridpane
   private GridPane computerBoard; //playerboard as a gridpane
   private BorderPane mainPane; //primary layout for battleship
   private VBox buttonPane; //pane with computer turn button
   private VBox header; //Games Header
   private HBox label; //board labels
   private Button computerTurnButton; //computers turn button
   private Button newGame; //new game button
   private Alert alert; //alert for game updates
   private boolean playerMove;
   private boolean gameOver;

   @Override
   public void start(Stage primaryStage) {
   
      playerMove = false;
      gameOver = false;
      primaryStage.setTitle("BattleShip");
      
      //set up panes
      mainPane = new BorderPane();
      userBoard = new GridPane();
      computerBoard = new GridPane();
      buttonPane = new VBox();
      header = new VBox();
      label = new HBox();
      
      //header setup
      header.setAlignment(Pos.CENTER);
      label.setAlignment(Pos.CENTER);
      Text title = new Text("Battleship");
      Text compHeader = new Text("          Computer Board");
      Text userHeader = new Text("User Board              ");
      Font titleFont = Font.font("Verdana", FontWeight.BOLD, 40);
      Font headerFont = Font.font("Verdana", FontWeight.BOLD, 20);
      title.setFont(titleFont);
      compHeader.setFont(headerFont);
      userHeader.setFont(headerFont);
      header.getChildren().add(title);
      label.getChildren().add(userHeader);
      label.getChildren().add(compHeader);
      header.getChildren().add(label);
      
      //setbackground collor
      header.setStyle("-fx-background-color: Aqua;");
      buttonPane.setStyle("-fx-background-color: DeepSkyBlue;");
      
      //initialize alert
      alert = new Alert(AlertType.INFORMATION);
      
      //initialize game and draw board
      initGame();
      drawBoard();
      
      //computer move button
      computerTurnButton = new Button("Computer's Turn");
      //computer button listener
      computerTurnButton.setOnAction(this::handleButton); 
                             
      //new game button and button listener
      newGame = new Button("New Game");
      newGame.setOnAction( new EventHandler<ActionEvent>() {
         public void handle(ActionEvent e)
         {
            playerMove = false;
            gameOver = false;
            initGame();
            drawBoard();
            computerTurnButton.setDisable(false);
         }
       });
       
      //add buttons to button pane
      buttonPane.getChildren().add(computerTurnButton);
      buttonPane.getChildren().add(newGame);
         
      //place sub panes on mainPane
      mainPane.setLeft(userBoard);
      mainPane.setCenter(computerBoard);
      mainPane.setRight(buttonPane);
      mainPane.setTop(header);
      mainPane.setMargin(userBoard,new Insets(0,10,0,0));
      
      // complete setup
      Scene scene = new Scene(mainPane);
      primaryStage.setScene(scene);
      primaryStage.show();
      
   }
  
  //draws computer and player board
   public void drawBoard()
   {
      
      //message alert if player wins
      if(game.computerDefeated()){
         gameOver = true;
         alert.setHeaderText("You Win!");
         alert.showAndWait();
         computerTurnButton.setDisable(true);

      }
      
      //message alert if computer wins
      if(game.playerDefeated()){
         gameOver = true;
         alert.setHeaderText("Computer Wins! :(");
         alert.showAndWait();
         computerTurnButton.setDisable(true);
      }
            
      computerBoard.getChildren().clear(); // clear the board
      userBoard.getChildren().clear(); // clear the board
      //populate user board
      for(int r = 0; r < 10; r++){
         for(int c = 0; c < 10; c++){
            CellPane cp = new CellPane(game.getPlayerStatus(r,c),r,c,true);
            userBoard.add(cp,c,r);
         }
      }
      
      //populate computer board
      for(int r = 0; r < 10; r++){
         for(int c = 0; c < 10; c++){
            CellPane cp = new CellPane(game.getComputerStatus(r,c),r,c,false);
            computerBoard.add(cp,c,r);
            if(!gameOver && playerMove){
               //cell pane listener
               if(cp.getCanBeClicked()){
                  cp.setOnMouseClicked(this::handleClick);
               }
            }
        }
      }      
   }
   
   //initilize/start game function
   public void initGame(){
      try{
         game = new Game();
      }catch(IOException e){
         System.out.println("File error");
      }
   }
   
   //button listener function
   public void handleButton(ActionEvent e)
   {
   
    if(gameOver && !playerMove){
          computerTurnButton.setDisable(true);
      }
      String [] moveInfo = game.makeComputerMove();
      if(moveInfo[1] != null){
           alert.setHeaderText(moveInfo[1]);
           alert.showAndWait();
      }
      playerMove = !playerMove;
      computerTurnButton.setDisable(true);
      drawBoard();
   }
 
   //cellpane on click listener function
   public void handleClick(MouseEvent e){
      CellPane cp = (CellPane)(e.getSource());
      //gets the position of the cell and converts it into a move apropriate string
      int row = cp.getRow();
      int col = cp.getCol()+1;
      String move = "";
      switch(row){
         case 0:
           move = "A";
           break;
         case 1:
            move = "B";
            break;
         case 2:
            move = "C";
            break;
         case 3:
            move = "D";
            break;
         case 4:
            move = "E";
            break;
         case 5:
            move = "F";
            break;
         case 6:
            move = "G";
            break;
         case 7:
            move = "H";
            break;
         case 8:
            move = "I";
            break;
         case 9:
            move = "J";
            break;       
        }
        move += String.valueOf(col);
        String moveInfo = game.makePlayerMove(move);
        //alert if ship sunk
        if(moveInfo != null){
            alert.setHeaderText(moveInfo);
            alert.showAndWait();
        }
        playerMove = !playerMove; 
        computerTurnButton.setDisable(false); 
        drawBoard();           
     }
   
           
   public static void main(String [] args) {
      launch(args);
   }

}