package LeagueInvaders;

import java.awt.Color;
import java.awt.Graphics;

public class Projectile extends GameObject{
	
	int speed = 10;
	
	Projectile(int x,int y,int width,int height){
		super(x, y, width, height);
	}
	
	void update() {
		y -= speed;
		if(y < 0) {
			isAlive = false;
		}
	}
	
	void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect(x+20, y, width, height);
	}
}
