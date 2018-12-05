
package highscores;

public class ScorePanel extends javax.swing.JPanel {

Scoreboard sb;



// declaring Variables 

private javax.swing.JButton showLeader;

//private javax.swing.JLabel jLabel1;

private javax.swing.JLabel jLabel2;

private javax.swing.JScrollPane jScrollPane1;

//private javax.swing.JTextField UserName;

private javax.swing.JTextArea GameRank;

//private javax.swing.JTextField GameScore;


// Creates Leader Board Panel



public ScorePanel() {

sb = new Scoreboard();

initComponents();

}

//WindowBuilder Generated Code

@SuppressWarnings("unchecked")



private void initComponents() {

//UserName = new javax.swing.JTextField();

//jLabel1 = new javax.swing.JLabel();

jLabel2 = new javax.swing.JLabel();

//GameScore = new javax.swing.JTextField();

showLeader = new javax.swing.JButton();

jScrollPane1 = new javax.swing.JScrollPane();

GameRank = new javax.swing.JTextArea();

//UserName.setToolTipText("");

//jLabel1.setText("Name");

jLabel2.setText("Top 5 Leaders");

//GameScore.setToolTipText("");

showLeader.setText("Press For Scorces");

showLeader.addActionListener(new java.awt.event.ActionListener() {

public void actionPerformed(java.awt.event.ActionEvent evt) {

showLeaderActionPerformed(evt);

}

});

GameRank.setColumns(20);

GameRank.setRows(5);

jScrollPane1.setViewportView(GameRank);

javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);

this.setLayout(layout);

layout.setHorizontalGroup(

layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)

.addGroup(layout.createSequentialGroup()

.addGap(26, 26, 26)

.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)

.addComponent(jScrollPane1)

.addGroup(layout.createSequentialGroup()

//.addComponent(jLabel1)

.addGap(18, 18, 18)

//.addComponent(UserName, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)

.addGap(18, 18, 18)

.addComponent(jLabel2)

.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)

//.addComponent(GameScore, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)

.addGap(18, 18, 18)

.addComponent(showLeader)))

.addContainerGap(17, Short.MAX_VALUE))

);

layout.setVerticalGroup(

layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)

.addGroup(layout.createSequentialGroup()

.addGap(34, 34, 34)

.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)

//.addComponent(UserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)

//.addComponent(jLabel1)

.addComponent(jLabel2)

//.addComponent(GameScore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)

.addComponent(showLeader))

.addGap(27, 27, 27)

.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)

.addContainerGap(22, Short.MAX_VALUE))

);

}// </ WindowCreator end of code   

// Button to show the leader scores 
private void showLeaderActionPerformed(java.awt.event.ActionEvent evt) {

GameRank.setText(sb.getHighscoreString());

}


}