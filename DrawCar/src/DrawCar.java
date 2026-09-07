import java.awt.Color;

import javax.swing.JColorChooser;

import ecs100.*;

// If you need any constants or fields, put them here
void main() {
	UI.initialise();
	// Set up your buttons here
	UI.addButton("Clear", UI::clearPanes );
	UI.addButton("drawCar", this::drawCar);	
}

// Add your methods here...
void drawCar() {
	UI.println("Draw your dream car now");
	double l=UI.askDouble("the length of car");//length
	double h=UI.askDouble("the heigth of car");//height
	double tl=UI.askDouble("the toplength of car");//top length
	double bh=UI.askDouble("the bottomHeigh of car");//bottom height 
	int x = UI.askInt("the X position of car");
    int y = UI.askInt("the Y position of car");
    this.Car(x, y, l, tl, bh, h); //draw car body   
}

void Car(int x,int y,double l, double tl,double bh,double h) {
		double size=50;//wheel size
		this.bodyColor();
		UI.fillRect(x,y,tl,h-bh);//car body top
		UI.fillRect(x,y+(h-bh),l,bh);//car body botton
		this.doorColor();//car door color
		UI.fillRect(x+20, y+40, tl-40, h-40);//car door
		this.wheelColor();
		UI.fillOval(x-size/2, y+h-size/2, size, size);
		UI.fillOval(x+l-size/2,y+h-size/2, size, size);
		
}

void bodyColor() {
	UI.println("Now choose your car's colours");
	String bodyColor=UI.askString("Please input the body Color of the car:(black, red, blue, green and yellow)");
	if(bodyColor.equalsIgnoreCase("black")) {
		UI.setColor(Color.black);
	}else if(bodyColor.equalsIgnoreCase("red")) {
		UI.setColor(Color.red);
	}else if (bodyColor.equalsIgnoreCase("blue")) {
		UI.setColor(Color.blue);
	}else if(bodyColor.equalsIgnoreCase("green")) {
		UI.setColor(Color.green);
	}else if(bodyColor.equalsIgnoreCase("yellow")) {
		UI.setColor(Color.yellow);
	}else {
		//if user don't print the default,they can choose the color.
		UI.println("Not the default color，please select color:");
		Color bodyColor1 = JColorChooser.showDialog(null, "bodyColor", Color.white);
		UI.setColor(bodyColor1);
	}
	
}
void wheelColor() {
	String wheelColor=UI.askString("Please input the wheel Color of the car:(black, red, blue, green and yellow)");
	if(wheelColor.equalsIgnoreCase("black")) {
		UI.setColor(Color.black);
	}else if(wheelColor.equalsIgnoreCase("red")) {
		UI.setColor(Color.red);
	}else if (wheelColor.equalsIgnoreCase("blue")) {
		UI.setColor(Color.blue);
	}else if(wheelColor.equalsIgnoreCase("green")) {
		UI.setColor(Color.green);
	}else if(wheelColor.equalsIgnoreCase("yellow")) {
		UI.setColor(Color.yellow);
	}else {
		UI.println("Not the default color，please select color:");
		Color wheelColor1 = JColorChooser.showDialog(null, "wheelColor", Color.white);
		UI.setColor(wheelColor1);
	}	
}

void doorColor() {
	String doorColor=UI.askString("Please input the door Color of the car:(black, red, blue, green and yellow)");
	if(doorColor.equalsIgnoreCase("black")) {
		UI.setColor(Color.black);
	}else if(doorColor.equalsIgnoreCase("red")) {
		UI.setColor(Color.red);
	}else if (doorColor.equalsIgnoreCase("blue")) {
		UI.setColor(Color.blue);
	}else if(doorColor.equalsIgnoreCase("green")) {
		UI.setColor(Color.green);
	}else if(doorColor.equalsIgnoreCase("yellow")) {
		UI.setColor(Color.yellow);
	}else {
		UI.println("Not the default color，please select color:");
		Color doorColor1 = JColorChooser.showDialog(null, "wheelColor", Color.white);
		UI.setColor(doorColor1);
	}	
}

void clearAll() {
	UI.clearGraphics();
}