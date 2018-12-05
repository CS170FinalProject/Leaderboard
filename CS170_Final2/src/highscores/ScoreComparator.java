package highscores;

import java.util.Comparator;

public class ScoreComparator implements Comparator<Score> {
        public int compare(Score score1, Score score2) {

        	// delary sc1 and sc2
            int sc1 = score1.getScore();
            int sc2 = score2.getScore();

            // Compare the scores to which is greater, return of -1 is the Sc1 is larger and +1 means smaller while 0 equals the same.
            if (sc1 > sc2){
                return -1;
            }else if (sc1 < sc2){
                return +1;
            }else{
                return 0;
            }
        }
}// end of class
