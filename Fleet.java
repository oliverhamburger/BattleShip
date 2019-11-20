/** class represents a fleet of ships on a battleship board*/
public class Fleet{
   private Ship battleShip; /* battleship of the fleet */
   private Ship aircraftCarrier; /* aircraftCarrier of the fleet */
   private Ship sub; /* sub of the fleet */
   private Ship destroyer; /* destroyer of the fleet */
   private Ship cruiser; /* cruiser of the fleet */
   
   /** Constructs a fleet object by initializint the Ship fields*/
   public Fleet(){
      battleShip = new Battleship();
      aircraftCarrier = new AircraftCarrier();
      sub = new Sub();
      destroyer = new Destroyer();
      cruiser = new Cruiser();
   }
   /** Method informs the appropriate ship that it has been hit, and returns true if this sank the ship, and false if it did not.
   @return true if this sank the ship, otherwise false */
   public boolean updateFleet(ShipType s){
      switch (s) { 
        case ST_AIRCRAFT_CARRIER: 
            return aircraftCarrier.hit(); 
        case ST_BATTLESHIP: 
            return battleShip.hit();
        case ST_CRUISER:
            return cruiser.hit();
        case ST_SUB:
            return sub.hit();
        case ST_DESTROYER:
            return destroyer.hit();
        default:
            System.out.println("Something went wrong");
            return false;
      }
       

   }
   
   /** Method answers the essential existential question, "Is the game over? Is all lost? Was there any point to any of it?"
      @return true if all ships have been sunk, returns false if not.
   */
   public boolean gameOver(){
      return battleShip.getSunk() && aircraftCarrier.getSunk() && sub.getSunk() 
               && destroyer.getSunk() && cruiser.getSunk();
   }

} 