package is.ru.bolti;
import java.util.ArrayList;
import java.util.Collections;


public class Team {
	public ArrayList<String> team;
	
	public Team(){
		team=new ArrayList<String>();
	}
	
	public void shuffle(){
		Collections.shuffle(team);
	}
	
	public void addPlayer(String player){
		team.add(player);
	}

	public String get(int i){
		return team.get(i);
	}

	public int size(){
		return team.size();
	}
	
	public void clearTeam(){
		team.clear();
	}
}
