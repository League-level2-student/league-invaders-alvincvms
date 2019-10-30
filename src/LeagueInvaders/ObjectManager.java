package LeagueInvaders;

import java.awt.Graphics;

import java.util.ArrayList;
import java.util.Random;


public class ObjectManager {
	
	Rocketship S;
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	ArrayList<Alien> aliens = new ArrayList<Alien>();
	
	long enemyTimer = 0;
	int enemySpawnTime = 1000;
	
	ObjectManager(Rocketship S) {
		this.S = S;
	}
	
	void update() {
		S.update();
		for(Projectile p : projectiles) {
			p.update();
		}
		for(Alien a : aliens) {
			a.update();
		}
	}
	
	void draw(Graphics g) {
		S.draw(g);
		for(Projectile p : projectiles) {
			p.draw(g);
		}
		for(Alien a : aliens) {
			a.draw(g);
		}
	}
	
	void addProjectile(Projectile p) {
		projectiles.add(p);
	}
	
	void addAlien(Alien a) {
		aliens.add(a);
	}
	
	public void manageEnemies() {
		if(System.currentTimeMillis() - enemyTimer >= enemySpawnTime){
            addAlien(new Alien(new Random().nextInt(LeagueInvaders.width), 0, 50, 50));
            enemyTimer = System.currentTimeMillis();
		}
	}
	
	void purgeObjects() {
		for(Projectile p : projectiles) {
			if(p.isAlive = false) {
				projectiles.remove(p);
			}
		}
		for(Alien a : aliens) {
			if(a.isAlive = false) {
				aliens.remove(a);
			}
		}
	}
}
