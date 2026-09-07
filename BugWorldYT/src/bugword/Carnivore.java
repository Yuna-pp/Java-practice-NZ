package bugword;

public class Carnivore extends Bug{
	public Carnivore(String species, String name, char symbol, int positionX, int positionY, int energy, int ID) {
        super(species, name, symbol, positionX, positionY, energy, ID);
    }
	@Override
	public String smellFood(World world) {
		for(Bug ob:world.getBugs()){
			if(ob==this)continue;
			int bx = ob.getPositionX();
            int by = ob.getPositionY();
            
            if(bx==ob.getPositionX()&&by == this.getPositionY()-1||by == this.getPositionY()-2) {
            	return "N";
            }
            if(bx==ob.getPositionX()&&by == this.getPositionY()+1||by == this.getPositionY()+2) {
            	return "S";
            }
            if(by == this.getPositionY() && bx == this.getPositionX()-1||bx==this.getPositionX()-2) {
            	return "W";
            }
            if(by == this.getPositionY() && bx == this.getPositionX()+1||bx==this.getPositionX()+2) {
            	return "E";
            }
		}
		
		return "NONE";
	}
}
