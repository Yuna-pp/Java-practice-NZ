package bugword;

public class Obstacle {
	private char obstacle;
	private int positionX;
    private int positionY;
    
    
    public Obstacle(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.obstacle='Ø';
    }
    
    public char getpSymbol() {
		return obstacle ;
	}
	
	public char getObstacle() {
		return obstacle;
	}


	public void setObstacle(char obstacle) {
		this.obstacle = obstacle;
	}


	public int getPositionX() {
		return positionX;
	}


	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}


	public int getPositionY() {
		return positionY;
	}


	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

 
}
