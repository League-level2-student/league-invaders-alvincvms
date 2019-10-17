package LeagueInvaders;

import java.awt.Dimension;

import javax.swing.JFrame;

public class LeagueInvaders {
	
	public static void main(String[] args) {
		new LeagueInvaders().setup();
	}
	
	JFrame frame;
	final int width = 500;
	final int height = 800;
	
	GamePanel GPanel;
	
    LeagueInvaders(){
		frame = new JFrame("LeagueInvaders");
		GPanel = new GamePanel();
	}
	
	void setup() {
		frame.add(GPanel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setPreferredSize(new Dimension(width, height));
        frame.pack();
        GPanel.startGame();
	}
}
