package LeagueInvaders;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Alien extends GameObject{
	
	int speed = new Random().nextInt(3)+1;
	
	Alien(int x, int y, int width, int height){
		super(x, y, width, height);
	}
	
	void update() {
		super.update();
		y += speed;
	}
	
	void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect(x, y, width, height);
	}
}
