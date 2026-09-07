package bugword;

import java.util.ArrayList;

public class World {
	private ArrayList<Bug> bugs;
	private ArrayList<Plant> plants;
	private ArrayList<Obstacle> obstacles;
	private int height;
	private int width;
	
	public World() {
		this.height=10;
		this.width=30;	
		this.bugs=new ArrayList<>();
		this.plants=new ArrayList<>();
		this.obstacles=new ArrayList<>();
	}
	
	public void addBugs(Bug bug) {
		bugs.add(bug);
	}
	public void addPlant(Plant plant) {
        plants.add(plant);
    }
	public void addObstacle(Obstacle obstacle) {
		obstacles.add(obstacle);
	}
		
	public ArrayList<Bug> getBugs() {
		return bugs;
	}

	public void setBugs(ArrayList<Bug> bugs) {
		this.bugs = bugs;
	}

	public ArrayList<Plant> getPlants() {
		return plants;
	}

	public void setPlants(ArrayList<Plant> plants) {
		this.plants = plants;
	}

	public void updateWorld() {
		String[] directions = {"N", "S", "E", "W", "NONE"};		
		for(Bug b:bugs) {	
			String dir = b.smellFood(this);
			
			if (dir.equals("NONE")) {
	            int randomNum = (int) (Math.random() * 5);
	            dir = directions[randomNum];
	        }
			
			b.move(dir);
			for (Obstacle o : obstacles) {
				if(b.getPositionX()==o.getPositionX()&&b.getPositionY()==o.getPositionY()) {
					if(dir.equals("N")) {
						b.move("S️");
					}
					else if(dir.equals("S")) {
						b.move("N");
					}
					else if(dir.equals("E")) {
						b.move("W");	
					}
					else if(dir.equals("W")) {
						b.move("E");
					}
					break;
				}
			}
				if (b.getPositionX() < 0) {
		            b.move("E"); 
		        } else if (b.getPositionX() >= width) {
		            b.move("W"); 
		        } else if (b.getPositionY() < 0) {
		            b.move("S"); 
		        } else if (b.getPositionY() >= height) {
		            b.move("N"); 
		        }						
		}
		for (Plant p : plants) {
            p.grow();
        }
	}	
	
	public void drawWorld() {
		System.out.print("|");
		for(int i=1;i<width+1;i++) {
			System.out.print("-");
		}
		System.out.println("|");
		for(int y=0;y<height;y++) {
			System.out.print("|");
			for(int x=0;x<width;x++) {
				char symbolToPrint = ' ';
				for (Bug b : bugs) {
	                if (b.getPositionX() == x && b.getPositionY() == y) {
	                	symbolToPrint = b.getSymbol();
	                	break;
	                	}
	                }
				
				for(Plant p:plants) {
					if(symbolToPrint ==' ') {
						if (p.getPositionX() == x && p.getPositionY() == y) {
		                	symbolToPrint = p.getpSymbol();
		                	break;
		                	}
					}
				}
				
				for(Obstacle o:obstacles) {
					if(symbolToPrint ==' ') {
						if(o.getPositionX() == x && o.getPositionY() == y) {
							symbolToPrint = o.getpSymbol();
							break;
						}
					}
				}
				System.out.print(symbolToPrint);
			}
			System.out.println("|");
		}
		System.out.print("|");
		for(int i=1;i<width+1;i++) {
			System.out.print("-");
		}
		System.out.println("|");
		
	}
}
