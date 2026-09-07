package bugword;

//吃草虫子判断四周方向上是不是有植物
public class Herbivore extends Bug{
	public Herbivore(String species, String name, char symbol, int positionX, int positionY, int energy, int ID) {
        super(species, name, symbol, positionX, positionY, energy, ID);
    }
	
	@Override
	public String smellFood(World world) {
		for(Plant p:world.getPlants()) {
			int px=p.getPositionX();
			int py=p.getPositionY();
			if (px == this.getPositionX() && py == this.getPositionY() - 1) {
                return "N";
            }
            
            if (px == this.getPositionX() && py == this.getPositionY() + 1) {
                return "S";
            }
           
            if (py == this.getPositionY() && px == this.getPositionX() - 1) {
                return "W";
            }
            
            if (py == this.getPositionY() && px == this.getPositionX() + 1) {
                return "E";
            }
		}
		return "NONE";
	}
}
