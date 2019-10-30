package LeagueInvaders;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Rocketship extends GameObject{
	
	int speed;
	
	Rocketship(int x, int y, int width, int height){
		super(x, y, width, height);
		speed = 0;
	}
	
	void update() {
		x += speed;
	}
	
	void draw(Graphics g) {
		g.setColor(Color.BLUE);
        g.fillRect(x, y, width, height);
	}
	
}
