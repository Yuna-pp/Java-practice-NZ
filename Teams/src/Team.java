import java.util.ArrayList;

/**
 * @author Yunian
 * @param This class is for team management
 * including team Name, coach Name, the counts of every team 
 */
public class Team {
	private String teamName;
	private String coachName;
	private int numPlayers;
	private ArrayList<Player> players;
	
	public Team(String teamName,String coachName) {
		this.teamName=teamName;
		this.coachName=coachName;
		this.players = new ArrayList<>();
	}
	
	public void addPlayer(Player player) {
        this.players.add(player);
    }
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getCoachName() {
		return coachName;
	}
	public void setCoachName(String coachName) {
		this.coachName = coachName;
	}
	public int getNumPlayers() {
		return numPlayers;
	}
	public void setNumPlayers(int numPlayers) {
		this.numPlayers = numPlayers;
	}
	public ArrayList<Player> getPlayers() {
	    return players;
	}
	public String toString() {
		return teamName+coachName;
	}

}
