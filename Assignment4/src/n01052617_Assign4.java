

import java.sql.*;
import java.io.*;
import java.lang.*;
import java.util.*;
import java.text.*;

public class n01052617_Assign4 {

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

			try {
				Class.forName("com.mysql.jdbc.Driver"); 
				//Get a connection
				Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "root");
				
				//Date Formatter
				SimpleDateFormat date = new SimpleDateFormat("\"YYYY-MM-DD\"");
				//Create a statement
				Statement myStmt = myConn.createStatement();
				
				String database = "CREATE DATABASE PlayerDB_Assign4";
				String useD = "USE PlayerDB_Assign4";
				String playerTable = " CREATE TABLE players ("
						+ "player_id INTEGER not NULL,"
						+ "tag VARCHAR(45),"
						+ "real_name VARCHAR(45),"
						+ "nationality VARCHAR(45),"
						+ "birthdate DATE,"
						+ "game_race VARCHAR(45),"
						+ "PRIMARY KEY (player_id))";
				
				String teamTable = " CREATE TABLE teams ("
						+ "team_id INTEGER not NULL,"
						+ "name VARCHAR(45),"
						+ "founded DATE,"
						+ "disbanded DATE,"
						+ "PRIMARY KEY (team_id))";
				
				String tTable = " CREATE TABLE tournaments ("
						+ "tournament_id INTEGER not NULL,"
						+ "name VARCHAR(45),"
						+ "region VARCHAR(45),"
						+ "major VARCHAR(45),"
						+ "PRIMARY KEY (tournament_id))";
				
				String membersTable = " CREATE TABLE members ("
						+ "player INTEGER not NULL,"
						+ "team INTEGER,"
						+ "start_date DATE,"
						+ "end_date DATE,"
						+ "PRIMARY KEY (start_date),"
						+ "FOREIGN KEY (player) REFERENCES players(player_id))";
				
				String earnings = "CREATE TABLE earnings ("
						+ "tournament INTEGER not NULL,"
						+ "player INTEGER not NULL,"
						+ "prize_money INTEGER,"
						+ "position INTEGER,"
						+ "FOREIGN KEY (tournament) REFERENCES tournaments(tournament_id),"
						+ "FOREIGN KEY (player) REFERENCES players(player_id))";
				
				String matches = "CREATE TABLE matches ("
						+ "match_id INTEGER not NULL,"
						+ "date DATE,"
						+ "tournament INTEGER,"
						+ "playerA INTEGER,"
						+ "playerB INTEGER,"
						+ "scoreA INTEGER,"
						+ "scoreB INTEGER,"
						+ "offline VARCHAR(45),"
						+ "PRIMARY KEY (match_id))";
				
				String insertPlayers = "LOAD DATA LOCAL INFILE '/Users/stephanrotolante/Downloads/Data/players.csv'"
						+ " INTO TABLE players FIELDS TERMINATED BY ','"
						+ " LINES TERMINATED BY '\n'"
						+ " (player_id, tag, real_name, nationality, @birth_date, game_race) " + 
						"SET birthdate = STR_TO_DATE(@birth_date, '\"%Y-%m-%d\"');";
				
				String insertMatches = "LOAD DATA LOCAL INFILE"
						+ " '/Users/stephanrotolante/Downloads/Data/matches_v2.csv'"
						+ " INTO TABLE matches"
						+ " FIELDS TERMINATED BY ','"
						+ " LINES TERMINATED BY '\n'"
						+ " (match_id, @var1, tournament, playerA, playerB, scoreA, scoreB, offline)"
						+ "	SET date = STR_TO_DATE(@var1, '\"%Y-%m-%d\"');";
				
				String insertTeams = "LOAD DATA LOCAL INFILE"
						+ " '/Users/stephanrotolante/Downloads/Data/teams.csv'"
						+ " INTO TABLE teams"
						+ " FIELDS TERMINATED BY ','"
						+ " LINES TERMINATED BY '\n'"
						+ " (team_id, name, @var1, @var2)"
						+ " SET founded = STR_TO_DATE(@var1, '\"%Y-%m-%d\"'), "
						+ " disbanded = STR_TO_DATE(@var2, '\"%Y-%m-%d\"');";
				
				String insertT = "LOAD DATA LOCAL INFILE"
						+ " '/Users/stephanrotolante/Downloads/Data/tournaments.csv'"
						+ " INTO TABLE tournaments"
						+ " FIELDS TERMINATED BY ','"
						+ " LINES TERMINATED BY '\n'";
				
				String insertMembers = "LOAD DATA LOCAL INFILE"
						+ " '/Users/stephanrotolante/Downloads/Data/members.csv'"
						+ " INTO TABLE members"
						+ " FIELDS TERMINATED BY ','"
						+ " LINES TERMINATED BY '\n'"
						+ " (player, team,  @var1, @var2)"
						+ " SET start_date = STR_TO_DATE(@var1, '\\\"%Y-%m-%d\\\"'),"
						+ " end_date = STR_TO_DATE(@var2, '\\\"%Y-%m-%d\\\"');";
				
				String insertEarnings = "LOAD DATA LOCAL INFILE"
						+ " '/Users/stephanrotolante/Downloads/Data/earnings.csv'"
						+ " INTO TABLE earnings"
						+ " FIELDS TERMINATED BY ','"
						+ " LINES TERMINATED BY '\n'";
					
				//Create DataBase
				myStmt.executeUpdate(database);
				//Use DataBase
				myStmt.executeUpdate(useD);
				//Create the tables
				myStmt.executeUpdate(playerTable);
				myStmt.executeUpdate(teamTable);
				myStmt.executeUpdate(tTable);
				myStmt.executeUpdate(membersTable);
				myStmt.executeUpdate(earnings);
				myStmt.executeUpdate(matches);
				//Inserting the Data
				myStmt.execute(insertPlayers);
				myStmt.execute(insertMatches);
				myStmt.execute(insertTeams);
				myStmt.execute(insertT);
				myStmt.execute(insertMembers);
				myStmt.execute(insertEarnings);
				myStmt.execute("USE PlayerDB_Assign4;");
				
				//Query 1
				Scanner scan = new Scanner(System.in);
				
				int select;
				while(true) {
				System.out.println("Select a query" + "\n");
				System.out.println("1 - Given a year and month, provide the real name, tag, and nationality of players who were born in that month" + "\n");
				System.out.println("2 - Given a player id and a team id, add that player as a member of the specified team, with the start date set according to the current system time. If the player is currently a member of another team, the database should also be updated to reflect their departure from the “old” team, with the end date set as above. If the player was already a current member of the given “new” team, no changes are necessary." + "\n");
				System.out.println("3 - Show the list of real names and birthdays of each input nationality (e.g., KR ~ non-Korean) player who was born in the input year (e.g., 1988)" + "\n");
				System.out.println("4 - A “triple crown” is the accomplishment of having won a major championship (i.e. came in the first position in a major tournament) in each of the three main regions, namely: Europe (EU), America (AM) and Korea (KR). List the tag and game race of each player who has managed to attain a triple crown at least once" + "\n");
				System.out.println("5 - List the former members of the team “ROOT Gaming”. Give the tag and real name of each player, and the date of their most recent departure from the team");
				System.out.println("6 - From among the Protoss (P) players who have played at least 10 games against Terran (T) opponents, find those who were able to win more than 65% of their “P vs. T” matches. Give the tag, nationality, and P vs. T's win rate (in percent) of these players. Sort the players according to their P vs. T's win rate, with the most successful player first." + "\n");
				System.out.println("7 - List all teams founded before 2011 that are still active (not yet disbanded). For each such team, give the team name, date founded, and the number of current team members who play Protoss, Terran, and Zerg, respectively. Sort the teams alphabetically by name." + "\n");
				select = scan.nextInt(); 
				
				switch(select) {
				
				case 1:
						System.out.println("Select Year" + "\n");
						String year = scan.next(); 
						System.out.println("Select Month" + "\n");
						String month = scan.next();
						ResultSet Q1 = myStmt.executeQuery("select players.real_name, players.tag, players.nationality " + 
								"from players" + 
								" where YEAR(players.birthdate) = " + year + " AND  MONTH(players.birthdate) = " + month + ";");
						
						while(Q1.next()) {
						System.out.printf("%-20s | %-20s | %-7s", Q1.getString(1), Q1.getString(2),
								Q1.getString(3) + "\n");
						}
						break;
				case 2:
						System.out.println("Enter Player ID");
						String player = scan.next();
						System.out.println("Enter Team ID");
						String team = scan.next();
						int Q21 = myStmt.executeUpdate("INSERT INTO members(player,team,start_date) VALUES"
								+ " (" + player + " , " + team + " , CURDATE());" );
						
						int Q22 = myStmt.executeUpdate("UPDATE members SET members.end_date = CURDATE() WHERE members.player = "
								+ player +" AND members.team != " + team +  " AND members.end_date IS NULL;");	
						
						if(Q21 == 1) {
							System.out.println("Insert WORKDED");
						} else {
							System.out.println("Insert Failed");
						}
						
						if( Q22 == 1) {
							System.out.println(" WORKDED");
						} else {
							System.out.println("Update Failed");
						}
					
				case 3:
					System.out.println("Enter Player Nationality");
					String nation = '"'+scan.next() +'"';
					System.out.println("Enter Birth Year");
					 year = scan.next();
					ResultSet Q3 = myStmt.executeQuery("select players.real_name, players.birthdate " + 
							"from players" + 
							" where YEAR(players.birthdate) = " + year + " AND  players.nationality = '" + nation + "';");
					
					while(Q3.next()) {
						System.out.printf("%-20s | %-20s", Q3.getString(1), Q3.getString(2) + "\n");
						}
					
				case 4:
						ResultSet Q4 = myStmt.executeQuery("select P.tag, P.game_race\n" + 
							"from players P\n" + 
							"where P.player_id IN (select P.player_id\n" + 
							"					  from players P, tournaments T, earnings E \n" + 
							"					  where P.player_id = E.player AND E.tournament = T.tournament_id  AND T.major LIKE 'true%' AND T.region = '\"EU\"' AND E.position = 1) \n" + 
							"  AND P.player_id IN (select P.player_id\n" + 
							"					  from players P, tournaments T, earnings E \n" + 
							"					  where P.player_id = E.player AND E.tournament = T.tournament_id  AND T.major LIKE 'true%' AND T.region = '\"AM\"' AND E.position = 1) \n" + 
							"  AND P.player_id IN (select P.player_id\n" + 
							"					  from players P, tournaments T, earnings E \n" + 
							"					  where P.player_id = E.player AND E.tournament = T.tournament_id  AND T.major LIKE 'true%' AND T.region = '\"KR\"' AND E.position = 1);");
					
							while(Q4.next()) {
								System.out.printf("%-20s | %-20s", Q4.getString(1), Q4.getString(2) + "\n");
								}
					
				case 5:
					ResultSet Q5 = myStmt.executeQuery("select P.tag, P.real_name, M.end_date\n" + 
							"from players P\n" + 
							"INNER JOIN members M ON M.player = P.player_id\n" + 
							"INNER JOIN teams T ON T.team_id = M.team\n" + 
							"WHERE T.team_id = 39 AND P.player_id NOT IN (SELECT Player FROM members M WHERE M.end_date IS NULL) AND P.player_id NOT IN(select M.player from members M WHERE M.team = 39 GROUP BY M.player HAVING COUNT(*) > 1);\n" + 
							"");
					
					while(Q5.next()) {
						System.out.printf("%-20s | %-20s | %-20s", Q5.getString(1), Q5.getString(2) , Q5.getString(3) + "\n");
						}
					
				case 6:
					
				case 7:
					
				
				}
				
				
				
				}
				
				
				//Execute Query
				//Result myRs = myStmt.executeQuery(sql)
			} catch (Exception exc) {
				exc.printStackTrace();
			}
	}

}
