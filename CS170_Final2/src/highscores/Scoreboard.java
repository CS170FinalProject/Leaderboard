
package highscores;

import java.util.*;
import java.awt.image.BufferedImageFilter;
import java.io.*;

public class Scoreboard {
	// Create an array list to store the score
	private ArrayList<Score> scores;

	// The name of the file where the highscores will be saved
	private static final String LEADERBOARDSCORE_FILE_DAT = "scores.dat";
	private static final String LEADERBOARDSCORE_FILE_TXT = "scores.txt";
	// Starts the in and outputStream for the file
	ObjectOutputStream outputStream = null;
	ObjectInputStream inputStream = null;

	public Scoreboard() {

		// Initializing the array
		scores = new ArrayList<Score>();
	}

	// makes the arraylist load the scores
	public ArrayList<Score> getScores() {
//		addScore("ryanTest", 1000000); // just for testing
		loadScoreFile();
		sort();		
		return scores;
	}

	public void addScore(String name, int score) {
		loadScoreFile();
		scores.add(new Score(name, score));
		updateScoreFile();
	}

	// Sorts the the score based on which is higher
	private void sort() {
		ScoreComparator comparator = new ScoreComparator();
		Collections.sort(scores, comparator);
	}

	// read the LEADERBOARDSCORE_FILE_DAT and display any errors when loading
	public void loadScoreFile() {
		BufferedReader br =null;
		
		try {
//			inputStream = new ObjectInputStream(new FileInputStream(LEADERBOARDSCORE_FILE_DAT));
//			scores = (ArrayList<Score>) inputStream.readObject();
			br = new BufferedReader(new FileReader(LEADERBOARDSCORE_FILE_TXT));
			String line;
			while((line = br.readLine()) != null) {
				String tokens[] = line.split(",");
				Score score = new Score(tokens[1], Integer.parseInt(tokens[0]));
				scores.add(score);
			}
			
//			for (Score score : scores) {
//				System.out.println(score.getScore() + "," + score.getName());
//			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found Error " + e.getMessage());
		} catch (IOException e) {
			System.out.println("There was an I/O error: " + e.getMessage());
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				System.out.println("[Laad] IO Error: " + e.getMessage());
			}
		}
	}

	// Method to use to wirte the array data to the file and show errors on adding
	public void updateScoreFile() {
		PrintWriter fw = null;
		try {
			fw = new PrintWriter(LEADERBOARDSCORE_FILE_TXT);
			StringBuffer buffer = new StringBuffer();
			for(Score score:scores) {
				buffer.append(score.getScore()).append(",").append(score.getName()).append("\n");				
			}
			fw.write(buffer.toString());
			fw.flush();
//			outputStream = new ObjectOutputStream(new FileOutputStream(LEADERBOARDSCORE_FILE_DAT));
//			outputStream.writeObject(scores);
			
		} catch (FileNotFoundException e) {
			System.out.println(" File not found Error: " + e.getMessage() + ", program will  make a new file");
		} catch (IOException e) {
			System.out.println("There was an I/O error:" + e.getMessage());
		} finally {
			if (fw != null) {
				fw.close();
			}
		}
	}

	// Used to only display 5 scores and send to GUI
	public String getHighscoreString() {
		String highscoreString = "";
		int max = 5;

		ArrayList<Score> scores;
		scores = getScores();

		int i = 0;
		int x = scores.size();
		if (x > max) {
			x = max;
		}
		while (i < x) {
			highscoreString += (i + 1) + ".\t" + scores.get(i).getName() + "\t\t" + scores.get(i).getScore() + "\n";
			i++;
		}
		return highscoreString;
	}
}