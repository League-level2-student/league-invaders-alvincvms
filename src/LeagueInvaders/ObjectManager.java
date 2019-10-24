package LeagueInvaders;

import java.awt.Graphics;


public class ObjectManager {
	
	Rocketship S;
	
	ObjectManager(Rocketship S) {
		this.S = S;
	}
	
	void update() {
		S.update();
	}
	
	void draw(Graphics g) {
		S.draw(g);
	}
}
