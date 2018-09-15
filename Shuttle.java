// Shahraiz Niazi
/**
 * The shuttle hovers on the left edge of the canvas. It can be moved up or down by pressing
 * the 'K' or 'J' key accordingly. The shuttle has 5 fuelcells, which can be launched one at
 * a time using the space bar. After launching all 5 fuelcells a refueling cannot occur.
 * 
 * @author Computer Science Department
 * @version October 2016
 */

public class Shuttle
{ 
    private Triangle shuttle; 
    private Canvas canvas;
    private SpaceStation spaceStation;
    private String direction;    // Which way to move, "up" or "down"
    private int numberFuelCells; // Note: Up to 5 fuel cells can be created and launched
    
    public Shuttle(Canvas theCanvas, SpaceStation theSpaceStation)
    {
        canvas = theCanvas;
        spaceStation = theSpaceStation;
        shuttle = new Triangle(canvas);
        
        shuttle.moveDirection(0,150);
        shuttle.changeColor("black");
        shuttle.makeVisible();
        numberFuelCells = 5;
        
    }

  
    public void setDirection(String theDirection)
    {
        direction = theDirection;
          
    }

 
    public void moveSmallDistance()
    {
       if( direction == "up" ){
       
       shuttle.moveDirection(0,-10);
    }
       else 
       {
       shuttle.moveDirection(0,10);
        
    }
    }

   
    public FuelCell launchCell()
    {
        FuelCell cell = null;
        if(numberFuelCells>0) 
        { 
            cell = new FuelCell(canvas, spaceStation); 
            cell.launch(shuttle.getXPosition(), shuttle.getYPosition()); 
            numberFuelCells = numberFuelCells - 1; 
        }
        return cell;
    }    

    
    public void dock()
    {
         while(shuttle.getXPosition() < spaceStation.getXPosition()) { 
            shuttle.moveDirection(10,0); 
            canvas.wait(30); 
        }
        shuttle.moveTo(spaceStation.getXPosition(), spaceStation.getYPosition());
        canvas.wait(3000); 
        
        while(shuttle.getXPosition() > 30) { 
            shuttle.moveDirection(-10,0); 
            canvas.wait(30);
        } 
    }
            
   
    public int getNumberFuelCells()
    {
        return numberFuelCells;
    }     
}