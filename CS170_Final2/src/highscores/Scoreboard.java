

package highscores;


import java.util.*;
import java.io.*;

public class Scoreboard {
    // Create an array list to store the score
    private ArrayList<Score> scores;

    // The name of the file where the highscores will be saved
    private static final String LEADERBOARDSCORE_FILE = "scores.dat";

    //Starts the in and outputStream for the file
    ObjectOutputStream outputStream = null;
    ObjectInputStream inputStream = null;

    public Scoreboard() {
        
    	//Initializing the array
        scores = new ArrayList<Score>();
    }

    // makes the arraylist load the scores
    public ArrayList<Score> getScores() {
        loadScoreFile();
        sort();
        return scores;
    }
    

    public void addScore(String name, int score) {
        loadScoreFile();
        scores.add(new Score(name, score));
        updateScoreFile();
}
  //Sorts the the score based on which is higher
    private void sort() {
        ScoreComparator comparator = new ScoreComparator();
        Collections.sort(scores, comparator);
} 
   //read the LEADERBOARDSCORE_FILE and display any errors when loading
    public void loadScoreFile() {
        try {
            inputStream = new ObjectInputStream(new FileInputStream(LEADERBOARDSCORE_FILE));
            scores = (ArrayList<Score>) inputStream.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("File not found Error " + e.getMessage());
        } catch (IOException e) {
            System.out.println("There was an I/O error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
           System.out.println(" There was a conjunctive normal form: " + e.getMessage());
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException e) {
                System.out.println("[Laad] IO Error: " + e.getMessage());
            }
        }
}
    // Method to use to wirte the array data to the file and show errors on adding 
    public void updateScoreFile() {
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream(LEADERBOARDSCORE_FILE));
            outputStream.writeObject(scores);
        } catch (FileNotFoundException e) {
            System.out.println(" File not found Error: " + e.getMessage() + ", program will  make a new file");
        } catch (IOException e) {
            System.out.println("There was an I/O error:" + e.getMessage());
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException e) {
                System.out.println(" Error updating data " + e.getMessage());
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