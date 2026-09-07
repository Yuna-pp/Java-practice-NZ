import java.util.ArrayList;
/**
 * @author Yunian
 * @param 
 */

public class Player {
	private String name; //Player name;
	private String[] positions;
	private int height;
	private String birthPlace;
	private Team teamName;
	/**
	 * 
	 * @param name player's name
	 * @param height player's height
	 * @param birthPlace 
	 * @param positions player's position in a team
	 */
	public Player(String name,int height,String birthPlace, String[] positions) {		
		this.name=name;
		this.height=height;
		this.birthPlace=birthPlace;
		this.positions = positions;		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return player's position
	 */	
	public String[] getPositions() {
		return positions;
	}

	public void setPositions(String[] positions) {
		this.positions = positions;
	}

	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public String getBirthPlace() {
		return birthPlace;
	}
	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}
	
	public Team getTeamName() {
		return teamName;
	}

	public void setTeamName(Team teamName) {
		this.teamName = teamName;
	}

	public String toString() {
		return name+birthPlace;
	}
	

}
