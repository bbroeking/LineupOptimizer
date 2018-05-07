
public class Player 
{
	public String position;
	public String nameID;
	public String name;
	public String id;
	public String rosterPos;
	public String salary;
	public String gameInfo;
	public String team;
	public String appg;
	public String draftKingsPP;
	public String opponent;
	
	Player(String position, String nameID, String name, String id, String rosterPos, String salary, String gameInfo, String team, String appg)
	{
		this.position = position;
		this.nameID = nameID;
		this.name = name;
		this.id = id;
		this.rosterPos = rosterPos;
		this.salary = salary;
		this.gameInfo = gameInfo;
		this.team = team;
		this.appg = appg;
		opponent = computeOpponent();
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setDraftKingsPP(String draftKingsPP)
	{
		this.draftKingsPP = draftKingsPP;
	}
	
	public String computeOpponent()
	{
		String opponent = null;
		
		if(gameInfo.substring(0,3).equals(team))
		{
			opponent = gameInfo.substring(4, 7);
		}
		else
			opponent = gameInfo.substring(0, 3);
		
		return opponent;
	}

}
