import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.Scanner;

import ecs100.UI;

/**
 * @author Yunian 
 * @version 1.2
 * @since 1.0
 * 
 */
public class UserInterface {
	
	ArrayList<Team> teamList=new ArrayList<>();
	ArrayList<Player> playerList=new ArrayList<>();
	public void listTeams() {
		for(Team t:teamList) {
			UI.println(t.getTeamName());
		}
	}
	
	public void listTeamsWithCoaches() {
		for(Team t:teamList) {
			UI.println(t.getTeamName()+"("+t.getCoachName()+")");
		}
	}

	public void listTeamPlayers() {
		
		String team = UI.askString("Which team?");
	    boolean found = false;
	    for (Team t : teamList) {
	        if (t.getTeamName().equalsIgnoreCase(team)) {
	            found = true;
	            for (Player p : t.getPlayers()) { 
	                UI.println("Name: " + p.getName());
	                UI.println("  Height: " + p.getHeight() + " cm");
	                UI.println("  Birthplace: " + p.getBirthPlace());
	                UI.println("  Positions: " + String.join(", ", p.getPositions()));
	                UI.println("------------------------------------");
	            }
	            break; 
	        }
	    }
	    if (!found) {
	        UI.println("Team not found: " + team);
	        return;
	    }
    }
	/**
	 * @param this method can check the player's position in a team.
	 * 
	 */

	public void listPositionPlayersOnTeam() {
		String team = UI.askString("Which team?");
		String position = UI.askString("Which position?");
		boolean foundTeam = false;
	    boolean foundPlayer = false;
	    for (Team t : teamList) {//先查球队，再找这个球队的位置
	        if (t.getTeamName().equalsIgnoreCase(team)) {
	            foundTeam = true;
	            for (Player p : t.getPlayers()) {
	                boolean hasPosition = false;
	                for (String pos: p.getPositions()) {
	                    if (pos.equalsIgnoreCase(position)) {
	                    	foundPlayer = true;
		                    UI.println("Name: " + p.getName());
		                    UI.println("  Positions: " + String.join(", ", p.getPositions()));
		                    UI.println("------------------------------------");
	                        break;
	                    }
	                }
	            }
	        }
	    }
	    if (!foundTeam) {
	        UI.println("Team not found: " + team);
	    } else if (!foundPlayer) {
	        UI.println("No players found with position " + position + " in this team.");
	    }
	}

	public void listHeights() {
		int min = UI.askInt("Taller than?");
		int max = UI.askInt("Shorter than?");
		boolean found = false;
		for(Player p:playerList) {
			if(p.getHeight()>=min&&p.getHeight()<=max){
				found = true;
				UI.println(p.getName()+"("+p.getHeight()+")");
			}
		}
		if (!found) {
	        UI.println("not found");
	    }
	}
	public void checkSelection() {	
			
	}

	public void graphHeights() {
		String team = UI.askString("Which team?");	
		UI.setColor(Color.black);
		UI.drawLine(0, 400, 600, 400);
		boolean found = false;
	    for (Team t : teamList) {
	        if (t.getTeamName().equalsIgnoreCase(team)) {
	            found = true;
	            int x = 10;        // 初始柱子的 X 轴起始位置
	            int barWidth =20; // 每根柱子的宽度
	            int spacing =30;  // 柱子之间的间隔
	            int baseLineY =400; // 底线 Y 坐标
	            for (Player p : t.getPlayers()) {
	                int height = p.getHeight();
	                //  根据身高设置不同颜色
	                if (height<=180) {
	                    UI.setColor(Color.green);   // <=180cm 绿色
	                } else if (height<=190) {
	                    UI.setColor(Color.blue);    // 181-190cm 蓝色
	                } else {
	                    UI.setColor(Color.red);     //> 190cm 为红色
	                }              
	                int barHeight = height; 
	                int y = baseLineY - barHeight; 
	                UI.fillRect(x, y, barWidth, barHeight); 
	                UI.setColor(Color.black);
	                UI.drawString(p.getName(), x, baseLineY+10); // 名字
	                UI.drawString(height + "cm", x, y-5); // 身高
	                x += barWidth + spacing;
	            }
	            break;
	        }
	    }
	    if (!found) {
	        UI.println("Team not found: " + team);
	    }
	}
	
	public void listPlace() {
		String place = UI.askString("Which birth Place?");	
		int count=0;
		for(Player p:playerList) {
			if(p.getBirthPlace().trim().equalsIgnoreCase(place)) {
				count++;
				UI.println(p.getName()+"( "+place+" )");
			}
		}UI.println(place+" has "+ count+" players");
	}
	
	public void playerPhoto() {	
		    String nameInput = UI.askString("Which player's photo?").trim();
		    boolean found = false;
		    for (Player p : playerList) {
		        if (p.getName().equalsIgnoreCase(nameInput)) {
		            found = true;
		            UI.clearGraphics();  
		            String imagePath = "lib/TeamPhotos/"+p.getName() + ".jpg";	            
		            try {
		                UI.drawImage(imagePath, 50, 50, 150, 200); 
		            } catch (Exception e) {
		                UI.println("Warning: Could not load image " + imagePath);
		            }
		            UI.setColor(java.awt.Color.black);
		            UI.drawString("Name: " + p.getName(), 230, 70);
		            UI.drawString("Height: " + p.getHeight() + " cm", 230, 100);
		            UI.drawString("Birthplace: " + p.getBirthPlace(), 230, 130);
		            UI.drawString("Positions: " + String.join(", ", p.getPositions()), 230, 160);    
		            if (p.getTeamName() != null) {
		                UI.drawString("Team: " + p.getTeamName().getTeamName(), 230, 190);
		            }
		            break;
		        }
		    }
		    if (!found) {
		        UI.println("Player not found: " + nameInput);
		    }	
	}
	
	public UserInterface() {
		UI.initialise();
		UI.addButton("List teams", this::listTeams);
		UI.addButton("List coaches", this::listTeamsWithCoaches);
		UI.addButton("List team players", this::listTeamPlayers);
		UI.addButton("List players by position", this::listPositionPlayersOnTeam);
		UI.addButton("Search by height", this::listHeights);
		UI.addButton("Check team lineup", this::checkSelection);
		UI.addButton("Graph player heights", this::graphHeights);
		UI.addButton("List of the same Place", this::listPlace);
		UI.addButton("Player information&Phote", this::playerPhoto);
		// This is the file with no player data listed.
		// When you extend your system to include players,
		// change it to "teams.txt" and update the parsing
		// code below.
		//String fileName = "teams-simple.txt";
		String fileName="teams.txt";
		// You may want to use this, or move it somewhere else,
		// or write your own version.
		try {
			Scanner scanner = new Scanner(new File(fileName));
            while (scanner.hasNextLine()) {
                String teamName = scanner.nextLine().trim();
                String coachName = scanner.nextLine().trim();
                
                int numPlayers = Integer.parseInt(scanner.nextLine().trim());

                Team team = new Team(teamName, coachName);
                teamList.add(team);

                for (int i = 0; i < numPlayers; i++) {
                    //  位置和姓名 
                    String posAndName = scanner.nextLine().trim();
                    String[] parts = posAndName.split(" ", 2);
                    String position = parts[0];
                    String playerName = parts[1];
                    String[] positions = position.split(",");
                    // 身高
                    int height = Integer.parseInt(scanner.nextLine().trim());
                    // 出生地
                    String birthPlace = scanner.nextLine().trim(); 
                    Player player = new Player(playerName, height, birthPlace, positions);
                    player.setTeamName(team); 
                    team.addPlayer(player); 
                    playerList.add(player);    
                }
            }
            scanner.close();
			
		} catch (FileNotFoundException e) {
			UI.printf("Error loading file: %s%n", e);
		}
	}

	public static void main(String[] args) {
		new UserInterface();
	}
}
