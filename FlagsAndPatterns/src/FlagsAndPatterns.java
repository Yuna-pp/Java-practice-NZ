import java.awt.Color;

import javax.swing.JColorChooser;

import ecs100.*;

final double width = 200;
final double height = 133;



//////// FLAG DRAWING /////////

void testFlagCore(){
    double left = UI.askDouble("left of flag");
    double top = UI.askDouble("top of flag");
    UI.println("Now choose the colours");
    Color stripe1 = JColorChooser.showDialog(null, "First Stripe", Color.white);
    Color stripe2 = JColorChooser.showDialog(null, "Second Stripe", Color.white);
    Color stripe3 = JColorChooser.showDialog(null, "Third Stripe", Color.white);
    //// Uncomment this line when you start work on the core:
    this.drawThreeColourFlagCore(left, top, stripe1, stripe2, stripe3 );
    UI.println("You need to uncomment the line above this in flagCore.");
}

/**
 * draws a three colour flag consisting of three vertical equal-width stripes
 * at the given position
 *
 * CORE
 */
void drawThreeColourFlagCore(double left,double top, Color stripe1,Color stripe2,Color stripe3 ){
    /*# YOUR CODE HERE */

		UI.setColor(stripe1);
		UI.fillRect(left, top, 200/3, 133);
		UI.setColor(stripe2);
		UI.fillRect(left+200/3, top, 200/3, 133);
		UI.setColor(stripe3);
		UI.fillRect(left+400/3, top, 200/3, 133);

}

/**
 * draws multiple flag made up of three equal size stripes by calling the
 * drawThreeColourFlagCompletion method, passing the appropriate arguments
 *
 * COMPLETION
 */
void testFlagCompletion(){
    double left=100;
    double top=20;
    //// Uncomment these lines when you start working on the completion:
    this.drawThreeColourFlagCompletion(true, 20, 50, Color.black, Color.yellow, Color.red);               // Belgium
    this.drawThreeColourFlagCompletion(false, 250, 100, Color.black, Color.red, Color.yellow);            // Germany
    this.drawThreeColourFlagCompletion(true, 140, 430, Color.blue, Color.white, Color.red);               // France
    this.drawThreeColourFlagCompletion(false, 470, 30, Color.red, Color.white, Color.blue);               // The Netherlands
    this.drawThreeColourFlagCompletion(false, 50, 250, Color.white, Color.blue, Color.red);               // Russia
    this.drawThreeColourFlagCompletion(true, 290, 270, Color.red, Color.yellow, Color.green.darker());    // Guinea
    UI.println("You need to uncomment the lines above this in testFlagCompletion.");
}

/**
 * draws a three colour flag consisting of three equal-size stripes
 * at the given position
 * The stripes can be either vertical or horizontal
 *
 * COMPLETION
 */
void drawThreeColourFlagCompletion(boolean answer, double left,double top, Color stripe1,Color stripe2,Color stripe3/*# YOUR CODE HERE */ ){
    /*# YOUR CODE HERE */
	if(answer) {
		UI.setColor(stripe1);
		UI.fillRect(left, top, width, height/3);
		UI.setColor(stripe2);
		UI.fillRect(left, top/3, width/3, height/3);
		UI.setColor(stripe3);
		UI.fillRect(left, top/6, width, height/3);
	}else {
		UI.setColor(stripe1);
		UI.fillRect(left, top, width/3, height);
		UI.setColor(stripe2);
		UI.fillRect(left+200/3, top, width/3, height);
		UI.setColor(stripe3);
		UI.fillRect(left+400/3, top, width/3, height);
	}
}



//////// PATTERN DRAWING /////////

final double boardLeft = 50;   // Top left corner of the board
final double boardTop = 50;
final double boardSize = 300;  // The size of the board on the window

/** Draw a square grid board with white squares.
 *  Asks the user for the number of squares on each side
 *
 * CORE
 */
void drawGridBoard(){
    UI.clearGraphics();
    int num = UI.askInt("How many rows:");
    /*# YOUR CODE HERE */
    double left = UI.askDouble("left of Grid");
    double top = UI.askDouble("top of Grid");
    int size =UI.askInt("size of Grid");
    
    for(int i=0;i<num;i++) {
    	for(int j=0;j<num;j++) {
    		UI.drawRect(left, top, size, size);
    		left=left+size;      		
    	}
    	left=left-size*num;
    	top=top+size;		    	    	
    }   
}

/** Illusion
 * a pattern that makes dark circles appear in the intersections
 * when you look at it.
 **/
void drawIllusion(){
    //UI.clearGraphics();
    int num = UI.askInt("How many rows:");
    /*# YOUR CODE HERE */
    double left = UI.askDouble("left of Illusion ");
    double top = UI.askDouble("top of Illusion");
    int size =UI.askInt("size of Illusion");
    int margin = 2;
    //int count=num-1; // the number of each line
    for(int i= 0;i<num;i++) {
    	//UI.drawRect(left, top, size, size);
    	//while(j<num) {
    	
    	for(int j=0;j<num-i;j++) {
    		
    		
    		UI.setColor(Color.black);
    		UI.fillRect(left, top, size-margin, size-margin);
    		left=left+size;
    		
    	}
    	left=left-(num-i)*size;
    	top=top+size;   
    	
    }

}

/** Draw a checkered board with alternating black and white squares
 *    Asks the user for the number of squares on each side
 *
 * COMPLETION
 */
void drawCheckersBoard(){
    UI.clearGraphics();
    int num = UI.askInt("How many rows:");
    /*# YOUR CODE HERE */
    double left = UI.askDouble("left of checkersBoard");
    double top = UI.askDouble("top of checkersBoard");
    int size =UI.askInt("size of checkersBoard");
    
    double startLeft=left;
    
    for(int i=0;i<num;i++) {
    	for(int j=0;j<num;j++) {
    		UI.setColor(Color.black);
    		UI.drawRect(left, top, size, size);
    		if((i+j)%2==0) {
    			UI.fillRect(left, top, size, size);
    		}else {
    			UI.drawRect(left, top, size, size);
    		}
    		left=left+size;  
    	
    		
    	}
    	left=startLeft;
    	top=top+size;		    	
    	
    }
}

/** Draw a board made of concentric circles, 2 pixel apart
 *  Asks the user for the number of squares on each side
 */
void drawConcentricBoard(){
    UI.clearGraphics();
    int num = UI.askInt("How many rows:");
    /*# YOUR CODE HERE */
    double left = UI.askDouble("left of checkersBoard");
    double top = UI.askDouble("top of checkersBoard");
    double squSize=200.0;
    double cellSize=squSize/num;   
    //int count=squSize/size;
    for(int row=0;row<num;row++) {
    	
    	for(int col=0;col<num;col++) {
    		
    		double cellX = left + col * cellSize;
            double cellY = top + row * cellSize;
            
            // 为画同心圆准备临时变量
            
            double currentX = cellX;
            double currentY = cellY;
        	
        	for(double currentDiam=cellSize;currentDiam>0;currentDiam--) {
        		
        		UI.drawOval(currentX, currentY, currentDiam, currentDiam);
        		currentX = currentX + 1;
                currentY = currentY + 1;
                currentDiam = currentDiam - 1;
        	}
        	
        }
    	
    }
   
}


/////////// STARTUP CODE - YOU DON'T NEED TO TOUCH THIS //////////
void main() {
	UI.initialise();
	UI.addButton("Clear", UI::clearPanes );
	UI.addButton("Flags - core", this::testFlagCore);
	UI.addButton("Flags - completion", this::testFlagCompletion);
    UI.addButton("Patterns - core: grid", this::drawGridBoard);
    UI.addButton("Patterns - core: illusion", this::drawIllusion);
    UI.addButton("Patterns - completion: checkers", this::drawCheckersBoard);
    UI.addButton("Patterns - challenge: concentric", this::drawConcentricBoard);
	UI.addButton("Quit", UI::quit );
}
