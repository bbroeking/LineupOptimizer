
public class LeaderboardPlayer 
{
	public String name;
	public String team;
	public String game;
	public String pos;
	public String PA;
	public String B1;
	public String B2;
	public String B3;
	public String HR;
	public String R;
	public String RBIs;
	public String SB;
	public String CS;
	public String BB;
	public String SO;
	public String yahooPP;
	public String fanDuelPP;
	public String draftKingsPP;
	public String playerID;
	
	LeaderboardPlayer(String name, String team, String game, String pos, String PA, String B1, String B2, 
			String B3, String HR, String R, String RBIs, String SB, String CS, String BB, String SO, 
			String yahooPP, String fanDuelPP, String draftKingsPP, String playerID)
	{
		this.name = name;
		this.team = team;
		this.game = game;
		this.pos = pos;
		this.PA = PA;
		this.B1 = B1;
		this.B2 = B2;
		this.B3 = B3;
		this.HR = HR;
		this.R = R;
		this.RBIs = RBIs;
		this.SB = SB;
		this.CS = CS;
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
