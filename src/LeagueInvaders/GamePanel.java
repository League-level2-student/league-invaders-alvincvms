package LeagueInvaders;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.crypto.spec.OAEPParameterSpec;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class GamePanel extends JPanel implements ActionListener, KeyListener{
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;
	boolean spacePressed = false;
	
	Font titleFont;
	Timer timer;
	GameObject GObject;
	Rocketship ship = new Rocketship(250, 700, 50, 50);
	ObjectManager O = new ObjectManager(ship);
	GamePanel(){
		timer = new Timer(1000/60, this);
		titleFont = new Font("Serif", Font.BOLD, 48);
	}

	void startGame() {
		timer.start();
	}
	
	void updateMenuState() {
		
	}
	
	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);   
		g.setFont(titleFont);
		g.setColor(Color.BLACK);
		g.drawString("LEAGUE INVADERS", 10, 300);
	}
	
	void updateGameState() {
		O.update();
		O.manageEnemies();
		O.checkCollision();
		O.purgeObjects();
		if(O.S.isAlive == false) {
			currentState = END_STATE;
		}
	}
	
	void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);
		O.draw(g);
	}
	
	void updateEndState() {
		
	}
	
	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);
		g.setFont(titleFont);
		g.setColor(Color.BLACK);
		g.drawString("GAME OVER", 100, 300);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
		if(currentState == MENU_STATE){
            updateMenuState();
		}
		if(currentState == GAME_STATE){
            updateGameState();
		}
		if(currentState == END_STATE){
            updateEndState();
		}

	}
	
	@Override

	public void paintComponent(Graphics g){
		if(currentState == MENU_STATE){
            drawMenuState(g);
		}
		else if(currentState == GAME_STATE){
            drawGameState(g);
		}
		else if(currentState == END_STATE){
            drawEndState(g);
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		if(currentState == GAME_STATE && e.getKeyChar() == ' ' && spacePressed == false) {
			O.addProjectile(new Projectile(O.S.x, O.S.y, 10, 10));
			spacePressed = true;
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
	
		if(e.getKeyCode() == KeyEvent.VK_ENTER && currentState != GAME_STATE) {
			currentState++;
			if(currentState > END_STATE){
                currentState = MENU_STATE;
			}
			
		}
		
		if(currentState == GAME_STATE && ( e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_LEFT + KeyEvent.VK_SPACE)) {
			O.S.speed = -5;
		}
		
		if(currentState == GAME_STATE && ( e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_RIGHT + KeyEvent.VK_SPACE)) {
			O.S.speed = 5;
		}
		
		if(e.getKeyCode() != KeyEvent.VK_LEFT && e.getKeyCode() != KeyEvent.VK_RIGHT && e.getKeyCode() != KeyEvent.VK_SPACE) {
			O.S.speed = 0;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		spacePressed = false;
		if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_LEFT) {
			O.S.speed = 0;
		}
		
	}
	
}
