import java.sql.*;
import java.math.BigDecimal;
import java.io.*;
import java.lang.*;
import java.util.*;
import java.text.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.math.RoundingMode;
public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		
		
		/*IntermediateFile File = new IntermediateFile("newGen.txt");
		
		
		Scanner ori = new Scanner(new File("crew.txt"));
		
		//System.out.println(ori.nextLine());
		
		String brokenLine[];// = ori.nextLine().split(",");
		String brokenLine2[];
		int pahse = 0;
		//For genres and keywords
		
		while(ori.hasNextLine()) {
		//	System.out.println(ori.next());
			
			brokenLine = ori.nextLine().split(",");
			//System.out.println(brokenLine[0]);
			File.WriteToFile(brokenLine[0]+",");
			
			for(int i = 1; i < brokenLine.length; i ++) {
				//System.out.println(brokenLine[i]);
				
				
				if(brokenLine[i].contains("Director") && !brokenLine[i].contains("P") && !brokenLine[i].contains("A") && !brokenLine[i].contains("S") && !brokenLine[i].contains("M")  && !brokenLine[i].contains("L") && !brokenLine[i].contains("C") ) {
					//System.out.println("JJJJK");
					//System.out.println(brokenLine[i+1]);
					brokenLine2 = brokenLine[i+1].split(":\\s+");
					brokenLine2 = brokenLine2[1].split("\"");
					File.WriteToFile(brokenLine2[2]);
					File.WriteLineToFile("");
					
					break;
					//File.WriteToFile(brokenLine[0]+",");
				}
				
				//if(!brokenLine[i].contains("]")) {
					//System.out.println(brokenLine[i]);
					//File.WriteToFile(brokenLine[0]+",");
					//}
				
				if(brokenLine[i].contains("cast_id") && pahse ==0) {
					//System.out.println(brokenLine[i]);
					//brokenLine2 = brokenLine[i].split(":\\s+");
					//File.WriteToFile(brokenLine2[1]+",");
					
					//dumpArray(brokenLine2);
					pahse =1;
					
					
					
				} else if(brokenLine[i].contains("character") && pahse ==1) {
					//System.out.println(brokenLine[i]);
					///brokenLine2 = brokenLine[i].split(":\\s+");
					//brokenLine2 = brokenLine2[1].split("\"");
					//System.out.println(brokenLine2[2]+"rrrrrrrrrrr");
					//if(brokenLine2[2].contains("\\") ) {
					//	System.out.println(brokenLine2[6]+"rrrrrrrffffffrrrr");
					//}
				//	System
					//if(brokenLine2.length==0) {
						
					//	File.WriteToFile(",");
					///} else {
					//	File.WriteToFile(brokenLine2[2]+",");
					//}
					
					pahse =2;
					
					
					
				} else if(brokenLine[i].contains("credit_id") && pahse ==2) {
				//	System.out.println(brokenLine[i]);
					//brokenLine2 = brokenLine[i].split(":\\s+");
					//brokenLine2 = brokenLine2[1].split("\"");
					//File.WriteToFile(brokenLine2[2]+",");
					pahse = 3;
					
					
					
				} else if(brokenLine[i].contains("gender") && pahse ==3) {
					
					//System.out.println(brokenLine[i]);
					//brokenLine2 = brokenLine[i].split(":\\s+");
					//File.WriteToFile(brokenLine2[1]+",");
					pahse = 4;
					
					
					
				} else if(brokenLine[i].contains("id") && pahse ==4) {
					//System.out.println(brokenLine[i]);
					//brokenLine2 = brokenLine[i].split(":\\s+");
					//File.WriteToFile(brokenLine2[1]+",");
					
					pahse = 5;
					
					
					
				} else if(brokenLine[i].contains("name")&& pahse ==5) {
					//System.out.println(brokenLine[i]);
					brokenLine2 = brokenLine[i].split(":\\s+");
					brokenLine2 = brokenLine2[1].split("\"");
					//System.out.println(brokenLine2[2] + "55");
					File.WriteToFile(brokenLine2[2]);
					pahse = 6;
					
				} else if(brokenLine[i].contains("order")&& pahse ==6) {
					//System.out.println(brokenLine[i]);
					//brokenLine2 = brokenLine[i].split(":\\s+");
					//brokenLine2 = brokenLine2[1].split("}");
					//dumpArray(brokenLine2);
					//File.WriteToFile(brokenLine2[0]);
					pahse = 0;
					File.WriteLineToFile("");
					if(!brokenLine[i].contains("]")) {
						System.out.println(brokenLine[i]);
						File.WriteToFile(brokenLine[0]+",");
						}
				} else {
					//System.out.println(brokenLine[i]);
					//System.out.println(brokenLine[i]);
					//File.WriteLineToFile("tt" + brokenLine[i]);
				} */
				/*if(brokenLine[i].contains("name")) {
					
					
					brokenLine2 = brokenLine[i].split(":\\s+");
					brokenLine2 = brokenLine2[1].split("\"");
					//dumpArray(brokenLine2[1]);
					//System.out.println(brokenLine2[2]);
					File.WriteToFile(brokenLine2[2]);
					File.WriteLineToFile("");
					
					if(!brokenLine[i].contains("]")) {
					File.WriteToFile(brokenLine[0]+",");
					}
				} 
				
			else if(brokenLine[i].contains("id")) {
					brokenLine2 = brokenLine[i].split(":\\s+");
					//System.out.println(brokenLine2[1]);
					File.WriteToFile(brokenLine2[1]+",");
				} else {
					File.WriteToFile(",");
					File.WriteLineToFile("");
				} 
				
			}
			//dumpArray(brokenLine);
			
		//	for
			
			
		}
		File.CloseFile(); */
		
		
		
		// TODO Auto-generated method stub
		try {
		Class.forName("com.mysql.jdbc.Driver"); 
		//Get a connection
		Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "root");
		
		Statement myStmt = myConn.createStatement();
		ArrayList<Film> MasterList = new ArrayList<Film>();	
		String database = "CREATE DATABASE Movies";
		String useD = "USE Movies";
		Scanner scan = new Scanner(System.in);
		String fillTitles = "select movie_id, title, vote_average, vote_count from main;";
		String t1 = "CREATE TABLE main(\n" + 
				"movie_id INTEGER PRIMARY KEY,\n" + 
				"title VARCHAR(100),\n" + 
				"pop FLOAT,\n" + 
				"vote_average DOUBLE,\n" + 
				"vote_count INTEGER\n" + 
				");";
		String t2 = "CREATE TABLE crew(\n" + 
				"	movie_id INTEGER,\n" + 
				"	name VARCHAR(60),\n" + 
				"FOREIGN KEY (movie_id) REFERENCES main (movie_id)\n" + 
				");";
		String t3 = "CREATE TABLE cst(\n" + 
				"	movie_id INTEGER,\n" + 
				"	name VARCHAR(60),\n" + 
				"FOREIGN KEY (movie_id) REFERENCES main (movie_id)\n" + 
				");";
		String t4 = "CREATE TABLE keywords(\n" + 
				"	movie_id INTEGER,\n" + 
				"	 id INTEGER ,\n" + 
				"	 keyword VARCHAR(60),\n" + 
				"FOREIGN KEY (movie_id) REFERENCES main (movie_id));";
		String t5 = "CREATE TABLE genres(\n" + 
				"	movie_id INTEGER,\n" + 
				"	 id INTEGER,\n" + 
				"	 genre VARCHAR(40),\n" + 
				"FOREIGN KEY (movie_id) REFERENCES main (movie_id));";
		String l1 = "LOAD DATA LOCAL INFILE '/Users/stephanrotolante/Desktop/Fixed Folder/newGen.csv' INTO TABLE genres FIELDS TERMINATED BY ',' LINES TERMINATED BY '\\n';";
		String l2 = "LOAD DATA LOCAL INFILE '/Users/stephanrotolante/Desktop/Fixed Folder/keywords.csv' INTO TABLE keywords FIELDS TERMINATED BY ',' LINES TERMINATED BY '\\n';";
		String l3 = "LOAD DATA LOCAL INFILE '/Users/stephanrotolante/Desktop/Fixed Folder/cast.csv' INTO TABLE cst FIELDS TERMINATED BY ',' LINES TERMINATED BY '\\n';";
		String l4 = "LOAD DATA LOCAL INFILE '/Users/stephanrotolante/Desktop/Fixed Folder/crew.csv' INTO TABLE crew FIELDS TERMINATED BY ',' LINES TERMINATED BY '\\n';";
		String l5 = "LOAD DATA LOCAL INFILE '/Users/stephanrotolante/Desktop/Fixed Folder/main.csv' INTO TABLE main FIELDS TERMINATED BY ',' LINES TERMINATED BY '\\n';";
		myStmt.execute(database);
		myStmt.execute(useD);
		//create tables
		myStmt.execute(t1);
		myStmt.execute(t2);
		myStmt.execute(t3);
		myStmt.execute(t4);
		myStmt.execute(t5);
		//insert
		myStmt.execute(l5);
		myStmt.execute(l1);
		myStmt.execute(l2);
		myStmt.execute(l3);
		myStmt.execute(l4);
	
		
		
		ResultSet Q1 = myStmt.executeQuery(fillTitles);
		double rating = 0;
		double res6 =0;
		
		while(Q1.next()) {
		MasterList.add(new Film(Integer.valueOf(Q1.getString(1)),Q1.getString(2)));
		
			rating = Double.valueOf(Q1.getString(3));
			res6 = Double.valueOf(Q1.getString(3)) * (Double.valueOf(Q1.getString(4))/3315117);
			//System.out.println(rating + " " + Q1.getString(3));
			MasterList.get(MasterList.size()-1).score = rating;
		//System.out.printf("%-20s | %-20s ", Q1.getString(1), Q1.getString(2) + "\n");
		}
		
		
		
		//inputs into Master list
		for(int i = 0; i < MasterList.size(); i++) {
			String mov = String.valueOf(MasterList.get(i).mov_id);
			String key = "select id from keywords where movie_id = " + mov;
			String gen = "select id from genres where movie_id = " + mov;
			String dir = "select name from crew where movie_id = " + mov;
			String act = "select name from cst where movie_id = " + mov;
			
			//System.out.println("DID THIS WORK");
			//Puts in the keywords
			ResultSet Q2 = myStmt.executeQuery(key);
			while(Q2.next()) {
				
				//System.out.println("Keyword " + Integer.valueOf(Q2.getString(1)));
				MasterList.get(i).Keyword.add(Integer.valueOf(Q2.getString(1)));
				//MasterList.add(new Film(Integer.valueOf(Q1.getString(1)),Q1.getString(2)));
				//System.out.printf(Q2.getString(1) + "\n");
				}
			//System.out.println(MasterList.get(0).Keyword.size());
			
			//genres
			ResultSet Q3 = myStmt.executeQuery(gen);
			while(Q3.next()) {
				MasterList.get(i).Genres.add(Integer.valueOf(Q3.getString(1)));
				//MasterList.add(new Film(Integer.valueOf(Q1.getString(1)),Q1.getString(2)));
				//System.out.printf(Q2.getString(1) + "\n");
				}
			
			//director
			ResultSet Q4 = myStmt.executeQuery(dir);
			while(Q4.next()) {
				MasterList.get(i).Director= Q4.getString(1);
				//MasterList.add(new Film(Integer.valueOf(Q1.getString(1)),Q1.getString(2)));
				//System.out.printf(Q2.getString(1) + "\n");
				}
			
			
			//actors
			ResultSet Q5 = myStmt.executeQuery(act);
			while(Q5.next()) {
				MasterList.get(i).Cast.add(Q5.getString(1));
				//MasterList.add(new Film(Integer.valueOf(Q1.getString(1)),Q1.getString(2)));
				//System.out.printf(Q2.getString(1) + "\n");
				}
			
			//System.out.println(MasterList.get(0).Cast.size());
			
			
		}
		
		
		int select =-1;
		//System.out.println("Enter");
		String movie;//scan.nextLine();
		//System.out.println(movie);
		boolean stop = true;
		while(stop == true) {
			
			System.out.println("0 - Exit");
			System.out.println("1 - Look for a recommedation");
				movie = "";
				select = scan.nextInt();
				
			
			
			
			
			switch(select) { 	
			
			case 1:
				
							System.out.println("Enter a movie title");
							movie = scan.next() + scan.nextLine();
							//System.out.println(movie + "THE TITLE");
							
							int index = 0;
							//Sees if the movie exists
							while(true) {
								if(MasterList.get(index).Title.equals(movie)) {
									System.out.println("Movie Found");
									int excluedID = MasterList.get(index).mov_id;
									int vec1Size = 1+ MasterList.get(index).Cast.size()+MasterList.get(index).Keyword.size()+MasterList.get(index).Genres.size();
									REC[] recomendations = new REC[5];
									recomendations[0] = new REC(-1,"");
									recomendations[1] = new REC(-1,"");
									recomendations[2] = new REC(-1,"");
									recomendations[3] = new REC(-1,"");
									recomendations[4] = new REC(-1,"");
									int index2=0;
									int tempscore = 0;
									while(true) {
									//director
										if(MasterList.get(index2).Director.equals(MasterList.get(index).Director)) {
											tempscore=tempscore+1;
										}
										//gets the cast count
										for(int i =0; i < MasterList.get(index).Cast.size(); i++ ) {
											for(int j =0; j <MasterList.get(index2).Cast.size();j++ ) {
												if(MasterList.get(index).Cast.get(i).equals(MasterList.get(index2).Cast.get(j))  && MasterList.get(index2).mov_id !=excluedID ) {
													tempscore=tempscore+1;
												}
											}
										}
										//genre count
										for(int i =0; i < MasterList.get(index).Genres.size(); i++ ) {
											for(int j =0; j <MasterList.get(index2).Genres.size();j++ ) {
												if(MasterList.get(index).Genres.get(i)==MasterList.get(index2).Genres.get(j) && MasterList.get(index2).mov_id !=excluedID ) {
													tempscore=tempscore+1;
												}
											}
										}
										//System.out.println("Movie does fffffffffffffnot exist");
										//keyword
										for(int i =0; i < MasterList.get(index).Keyword.size(); i++ ) {
											for(int j =0; j <MasterList.get(index2).Keyword.size();j++ ) {
												
												if(MasterList.get(index).Keyword.get(i)==MasterList.get(index2).Keyword.get(j) && MasterList.get(index2).mov_id !=excluedID ) {
													tempscore=tempscore+1;
												}
											}
										}
										int res = vec1Size - tempscore;
									//System.out.println(vec1Size + " " + tempscore);
										int res2 = res*res;
										double res3 = Math.sqrt(res2);
										//System.out.println(res3);
										for(int q =0; q <5; q++){
											if(res3 < recomendations[q].sim && MasterList.get(index2).score > recomendations[q].score ) {
												recomendations[q].movie_id =MasterList.get(index2).mov_id;
												recomendations[q].Title = MasterList.get(index2).Title;
												recomendations[q].sim = res3;
												break;
											}
										}
										tempscore = 0;
										index2 = index2+1;
										if(index2== MasterList.size()) {
											break;
										}
									}
									for(int q =0; q <5; q++){
										System.out.println(recomendations[q].Title);
									}
									break;
								}
								index = index+1;
								
								if(index== MasterList.size()) {
									System.out.println("Movie does not exist");
									System.out.println("0 - Exit");
									System.out.println("1 - Look for a recommedation");
										System.out.println(scan.next());
										select = scan.nextInt();
									break;
								}
							}
							break;
			case 0:
				System.out.println("Good-Bye");
				stop = false;
				break;
			
	}
		
}
		//myStmt.executeUpdate(useD);
		} catch (Exception exc) {
			exc.printStackTrace();
		} 

	}
	
public static void dumpArray(String[] Array) {
		
		for(int i = 0; i < Array.length; i++) {
			
			System.out.println(Array[i]);
		}
	}

}
