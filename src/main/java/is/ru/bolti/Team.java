package is.ru.bolti;



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
	
	public void clearTeam(){
		team.clear();
	}
}
