package bugword;


public class Plant {
	
	private int size;
	private int positionX;
    private int positionY;
   // private char pSymbol;
    
    public void grow() {
    	if (this.size < 9) {
            this.size++; 
        }
    }
    
    public Plant(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
        int r= (int) (Math.random() * 9);
        this.size = r; 
    }
    
	public char getpSymbol() {
		return (char) ('0' + size);
	}

	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
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
