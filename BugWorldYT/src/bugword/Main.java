package bugword;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		ArrayList<Bug> bugs=new ArrayList<>();
		Bug ant = new Herbivore("Ant", "ant1", 'A', 6, 3, 110, 1);
		Bug spider = new Carnivore("Spider", "sp1", 'S', 2, 2, 120, 2);
		
			System.out.println("Please input the bug3 attributes");
			Scanner input=new Scanner(System.in);
			System.out.println("species: ");
			String species=input.next();
			System.out.println("name: ");
			String name=input.next();
			System.out.println("symbol: ");
			char symbol=input.next().charAt(0);
			System.out.println("PositionX: ");
			int posX=input.nextInt();
			System.out.println("PositionY: ");
			int posY=input.nextInt();
			System.out.println("energy: ");
			int energy=input.nextInt();
			System.out.println("ID: ");
			int ID=input.nextInt();
			
			Bug bug3 = new Carnivore(species, name, symbol, posX, posY, energy, ID);
			bugs.add(ant);
			bugs.add(spider);
			bugs.add(bug3);
			
			for (Bug b : bugs) {
	            System.out.println(b.toText());	            
	        }
					
			World world = new World();
			world.addBugs(ant);
			world.addBugs(spider);
			world.addBugs(bug3);
				
			Plant plant1 = new Plant(10, 2);
			Plant plant2 = new Plant(20, 7);
			Plant plant3 = new Plant(17, 8);
			world.addPlant(plant1);
			world.addPlant(plant2);
			
			
			Obstacle obs1=new Obstacle(3,5);
			Obstacle obs2=new Obstacle(6,2);
			Obstacle obs3=new Obstacle(12,8);
			world.addObstacle(obs1);
			world.addObstacle(obs2);
			world.addObstacle(obs3);
			
			world.drawWorld();	
			for (int i = 0; i < 10; i++) {
			    world.updateWorld(); 
			    world.drawWorld();   
			}
			
			bugs.sort(new CompareAll.BugEnergy());
			
	}
}
