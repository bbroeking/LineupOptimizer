
public class LeaderboardPitcher 
{
	String name;
	String team;
	String game;
	String w;
	String ip;
	String tbf;
	String h;
	String B1;
	String B2;
	String B3;
	String HR;
	String BB;
	String SO;
	String yahooPP;
	String fanDuelPP;
	String draftKingsPP;
	String playerID;
	
	LeaderboardPitcher(String name, String team, String game, String w, String ip, String tbf, String h, String B1, String B2, 
			String B3, String HR, String BB, String SO, 
			String yahooPP, String fanDuelPP, String draftKingsPP, String playerID)
	{
		this.name = name;
		this.team = team;
		this.game = game;
		this.w = w;
		this.ip = ip;
		this.tbf = tbf;
		this.h = h;
		this.B1 = B1;
		this.B2 = B2;
		this.B3 = B3;
		this.HR = HR;
		this.BB = BB;
		this.SO = SO;
		this.yahooPP = yahooPP;
		this.fanDuelPP = fanDuelPP;
		this.draftKingsPP = draftKingsPP;
		this.playerID = playerID;
	}
	
	public String getName()
	{
		return name;
	}
}
