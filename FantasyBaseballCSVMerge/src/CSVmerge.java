import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CSVmerge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Daily Salary 
		String filename = "../LineupGenData/5.7/5.7Salary.csv";

		File file = new File(filename);

		ArrayList<Player> players = new ArrayList<Player>();
		ArrayList<LeaderboardPlayer> leaderboardPlayers = new ArrayList<LeaderboardPlayer>();
		ArrayList<LeaderboardPitcher> leaderboardPitchers = new ArrayList<LeaderboardPitcher>();

		// create player objects from list of salaries
		try {
			Scanner input = new Scanner(file);
			input.useDelimiter(",");

			while (input.hasNextLine()) {
				String line = input.nextLine();

				String[] attributes = line.split(",");

				String position = attributes[0];
				String nameID = attributes[1];
				String name = attributes[2];
				String id = attributes[3];
				String rosterPos = attributes[4];
				String salary = attributes[5];
				String gameInfo = attributes[6];
				String team = attributes[7];
				String appg = attributes[8];

				Player player = new Player(position, nameID, name, id, rosterPos, salary, gameInfo, team, appg);

				players.add(player);
			}
			input.close();
		} catch (FileNotFoundException e) {
			System.out.println("file not found");
		}

		// create leaderboardplayer objects from leaderboardCSV
		filename = "../LineupGenData/5.7/5.7Batter.csv";

		File file2 = new File(filename);
		try {
			Scanner input2 = new Scanner(file2);
			input2.useDelimiter(",");

			while (input2.hasNextLine()) {
				String line = input2.nextLine();

				String[] attributes = line.split(",");

				String name = attributes[0].replace("\"", "");
				String team = attributes[1].replace("\"", "");
				String game = attributes[2].replace("\"", "");
				String pos = attributes[3].replace("\"", "");
				String PA = attributes[4].replace("\"", "");
				String B1 = attributes[5].replace("\"", "");
				String B2 = attributes[6].replace("\"", "");
				String B3 = attributes[7].replace("\"", "");
				String HR = attributes[8].replace("\"", "");
				String R = attributes[9].replace("\"", "");
				String RBIs = attributes[10].replace("\"", "");
				String SB = attributes[11].replace("\"", "");
				String CS = attributes[12].replace("\"", "");
				String BB = attributes[13].replace("\"", "");
				String SO = attributes[14].replace("\"", "");
				String yahooPP = attributes[15].replace("\"", "");
				String fanDuelPP = attributes[16].replace("\"", "");
				String draftKingsPP = attributes[17].replace("\"", "");
				String playerID = attributes[18].replace("\"", "");

				LeaderboardPlayer LBplayer = new LeaderboardPlayer(name, team, game, pos, PA, B1, B2, B3, HR, R, RBIs,
						SB, CS, BB, SO, yahooPP, fanDuelPP, draftKingsPP, playerID);

				leaderboardPlayers.add(LBplayer);
			}
			input2.close();
		} catch (FileNotFoundException e) {
			System.out.println("file not found");
		}

		// create leaderboardpitcher objects from leaderboardpitcherCSV
		filename = "../LineupGenData/5.7/5.7Pitcher.csv";

		File file3 = new File(filename);
		try {
			Scanner input3 = new Scanner(file3);
			input3.useDelimiter(",");

			while (input3.hasNextLine()) {
				String line = input3.nextLine();

				String[] attributes = line.split(",");

				String name = attributes[0].replace("\"", "");
				String team = attributes[1].replace("\"", "");
				String game = attributes[2].replace("\"", "");
				String w = attributes[3].replace("\"", "");
				String ip = attributes[4].replace("\"", "");
				String tbf = attributes[5].replace("\"", "");
				String h = attributes[6].replace("\"", "");
				String B1 = attributes[7].replace("\"", "");
				String B2 = attributes[8].replace("\"", "");
				String B3 = attributes[9].replace("\"", "");
				String HR = attributes[10].replace("\"", "");
				String BB = attributes[11].replace("\"", "");
				String SO = attributes[12].replace("\"", "");
				String yahooPP = attributes[13].replace("\"", "");
				String fanDuelPP = attributes[14].replace("\"", "");
				String draftKingsPP = attributes[15].replace("\"", "");
				String playerID = attributes[16].replace("\"", "");

				LeaderboardPitcher LBpitcher = new LeaderboardPitcher(name, team, game, w, ip, tbf, h, B1, B2, B3, HR,
						BB, SO, yahooPP, fanDuelPP, draftKingsPP, playerID);

				leaderboardPitchers.add(LBpitcher);
			}
			input3.close();
		} catch (FileNotFoundException e) {
			System.out.println("file not found");
		}

		for(Player s : players) 
		{
			for(LeaderboardPlayer lb : leaderboardPlayers)
			{
				if(lb.getName().equals(s.getName()))
				{
					s.setDraftKingsPP(lb.draftKingsPP);
	
				}
			}
			
			for(LeaderboardPitcher p : leaderboardPitchers)
			{
				if(p.getName().equals(s.getName()))
				{
					
					s.setDraftKingsPP(p.draftKingsPP);
				}
			}
		}
		
		
		//WRITE NEW CSV file with useful info, player name, position, projected points, salary and appg
		String outputFilename = "output.csv";
		FileWriter fileWriter = null;
		
		try
		{
			fileWriter = new FileWriter(outputFilename);
			
			for(Player s : players)
			{
				if(s.draftKingsPP != null)
				{
					fileWriter.append(s.name + ", " + s.salary + ", " + s.rosterPos + ", " + s.draftKingsPP + ", " + s.appg + ", " + s.team + ", " + s.opponent);
					fileWriter.append("\n");
				}
			}
			
			System.out.println("Output file written sucessfully");
			
		}
		catch(Exception e)
		{
			System.out.println("error writing file");
		}
		finally
		{
			try
			{
				fileWriter.flush();
				fileWriter.close();
			}
			catch(IOException e)
			{
				System.out.println("error closing or flushing filewriter");
			}
		}
	}

}
