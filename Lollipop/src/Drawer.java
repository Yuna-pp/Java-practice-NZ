import ecs100.*;
import java.awt.Color;
//final double x = 30;	// horizontal center of lollipop
//final double y = 50;  	// vertical center of lollipop
double a=0;
double b=0;

void main() {	
	UI.initialise();
	UI.addButton("DrawLots", this::DrawLots);
	UI.addButton("Draw Lollipop", this::drawLollipop);	
	//UI.addButton("drawColors", this::drawColors);
	UI.addButton("Clear it",this::clearAll);	
}

void singledrawLollipop(double x, double y, double size, double stick) {
	/*
	 *  Convert this to Java (look up the documentation
	 *  as necessary):
	 */
	
	/*final double size = 80;	// diameter of lollipop
	final double stick =  200;	// length of lollipop stick

	double left = x - size/2;	// left of lollipop
	double top = y - size/2;	// top of lollipop
	double bot =  y + stick; 	// bottom of stick*/
		
	double left= x - size/2;
	double top=y - size/2;
	double bot=y + stick; 
	//size = UI.askDouble("Diameter:");
	//stick =  UI.askDouble("StickHeight");

	//int redVal = (int)(Math.random() * 256);
    //int yellowVal = (int)(Math.random() * 256);
    //int blueVal = (int)(Math.random() * 256);
    //Color randomColor = new Color(redVal, yellowVal, blueVal);
    Color rc = new Color((int)(Math.random()*(1<<24)));
    
	UI.setColor(Color.black);
	// set line width to 10
	UI.setLineWidth(10);
	// draw line  (300, 200) to (300, 400)
	UI.drawLine(x, y, x, bot);
	// set line width to 1
	UI.setLineWidth(1);
	// set colour 
	
	UI.setColor(rc);
	// fill oval at  (260, 160) that is 80x80
	UI.fillOval(left, top, size, size);

}
public void DrawLots() {
    
	a = UI.askInt("X-coordinate:");
	b = UI.askInt("Y-coordinate:");
	this.drawHouse(a, b, 100,70,20);
	this.drawHouse(a+80, b-50, 150,70,20);
	this.drawHouse(a+180, b-20, 120,70,20);
		
}
public void drawLollipop() {
	this.singledrawLollipop(a+100, b+100, 30, 50);
	this.singledrawLollipop(a+120, b+100, 50, 50);
	this.singledrawLollipop(a-50, b+100, 20, 80);
	this.singledrawLollipop(a+20, b+100, 20, 80);
}

void drawHouse(double a, double b, double h, double w, double size) {
	//random color
	//int redVal = (int)(Math.random() * 256);
    //int yellowVal = (int)(Math.random() * 256);
    //int blueVal = (int)(Math.random() * 256);
    //Color randomColor = new Color(redVal, yellowVal, blueVal);
    Color rc = new Color((int)(Math.random()*(1<<24)));
    //draw house
	UI.setLineWidth(2);
	UI.setColor(rc);
	UI.drawRect(a, b, w, h);
	UI.drawLine(a, b, a+w/2, b-w/2);
	UI.drawLine(a+w, b, a+w/2, b-w/2);
	//draw window
	UI.setLineWidth(1);
	UI.setColor(rc);
	UI.drawRect(a+10, b+10, size, size);
	UI.drawLine(a+10+size/2, b+10, a+10+size/2, b+10+size);
	UI.drawLine(a+10, b+10+size/2, a+10+size, b+10+size/2);
	UI.drawRect(a+20+size, b+10, size, size);
	UI.drawLine(a+20+size*1.5, b+10, a+20+size*1.5, b+10+size);
	UI.drawLine(a+20+size, b+10+0.5*size, a+20+2*size, b+10+size/2);
	
	
}

void clearAll() {
	UI.clearGraphics();
}


