import java.awt.Color;

import ecs100.UI;

public class NormalBalloon implements Balloon {
	
	/*private double x;//x position
	private double y;//y position
	private double radius;
	private Color color;*/
	
	/*public NormalBalloon(double x, double y, double radius, Color color) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
    }*/
	
	@Override
	public void pop() {
		// TODO Auto-generated method stub
		
		UI.println("Popping, normal ballooooooon!");

	}

	@Override
	public boolean on(double x, double y) {
		// TODO Auto-generated method stub
		
		
		UI.println("On method, normal ballooooooon!");
		return false;
	}

	@Override
	public void expand() {
		// TODO Auto-generated method stub
		//this.radius += 10;
		UI.println("Expanding, normal ballooooooon!");

	}
	
	
	public String toString()
	{
		return "Hello, this is a normal balloooooon";
	}

}
