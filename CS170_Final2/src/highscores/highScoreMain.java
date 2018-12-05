package highscores;

import javax.swing.JFrame;

public class highScoreMain extends JFrame {
  
public static void main(String[] args) {

	//creates the High Score panel 
	ScorePanel scpnl = new ScorePanel();
// Allows pannel to be Seen
scpnl.setVisible(true);


highScoreMain hsm = new highScoreMain();

//used to create the Jframe
hsm.setTitle("LeaderBoard");
hsm.add(scpnl);
hsm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
hsm.setSize(530, 530);
hsm.setVisible(true);
}
}// end of main