package bugword;

public class Bug {
	private String species;
	private String name;
	private char symbol;
	private int positionX;
	private int positionY;
	private int energy;
	private int ID;
	
	public Bug(){
		this.species="bee";
		this.name="bee1";
		this.symbol='B';
		this.positionX=5;
		this.positionY=5;
		this.energy=100;
		this.ID=0;
						
	}
	public Bug(String species, String name, char symbol, int positionX, int positionY, int energy, int ID) {
        this.species = species;
        this.name = name;
        this.symbol = symbol;
        this.positionX = positionX;
        this.positionY = positionY;
        this.energy = energy;
        this.ID = ID;
    }
	
	public void move(String key) {
		 if (key.equalsIgnoreCase("N")) {
	            positionY--; //up
	        } else if (key.equalsIgnoreCase("S")) {
	            positionY++; //down
	        } else if (key.equalsIgnoreCase("W")) {
	            positionX--; //left
	        } else if (key.equalsIgnoreCase("E")) {
	            positionX++; //right
	        } else {
	            return; 
	        }
	}
	
	public String smellFood(World world) {
		return "NONE";	
	}
	
	public String getSpecies() {
		return species;
	}


	public void setSpecies(String species) {
		this.species = species;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getSymbol() {
		return symbol;
	}

	public void setSymbol(char symbol) {
		this.symbol = symbol;
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

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String toText() {
        return "ID: " + ID + ", Name: " + name + ", Species: " + species + 
               ", Symbol: " + symbol + ", Pos: (" + positionX + "," + positionY + 
               "), Energy: " + energy;
    }

	public String toString()
	{
		return name + " (" + species + ") at (" + positionX + "," + positionY + ")";
    
	}
}
