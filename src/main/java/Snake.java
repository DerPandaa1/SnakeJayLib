import static com.raylib.Raylib.CloseWindow;

import java.util.*;

import com.raylib.Jaylib;
import com.raylib.Raylib;

//FeldGröße 32*18

/**
 * @author <a href="mailto:Alexander.Rathai@Materna.DE">Alexander Rathai</a>
 *
 */


public class Snake {
	List<Pos> snake = new ArrayList<Pos>();
	Pos posApple1 = new Pos(1, 1);
	String richtung = "";
	public boolean isGameOver = false;
	public int score = snake.size()-3;
	Pos[] PowerUps = new Pos[10];
	double powerUp2;
    public int  highscore;
 
	
	
	public Snake() {

	}

	public void init() {
		snake.add(new Pos(9, 7));
		snake.add(new Pos(8, 7));
		snake.add(new Pos(7, 7));

	
		// Schlange bei Start

		
		int x1Random = getRandomInt(0, 31);
		int y1Random = getRandomInt(0, 17);
		posApple1.x = x1Random;
		posApple1.y = y1Random;
		// Apfel-Mechanismus

		score = 0;
	}

	public void zzzz() {

		for (int i = 0; i < snake.size(); i++) {
			Pos pos = snake.get(i);
			int x = pos.x;
			int y = pos.y;
			try {      
				PandaaHelper.drawTile(x, y);
			} catch (IndexOutOfBoundsException e) {
				System.err.println("Caught error");
//				System.exit(1);
				System.out.println("Game Over!");
				isGameOver = true;
			    highscore = PandaaHelper.getHighscore();
				if (isHighScore(score, highscore)) {
					PandaaHelper.setHighscore(highscore);
				}
				return;
			}
			// Zeichnet für die Koordinaten der Schlange die Blöcke
		}

		move(richtung);// Aufruf zur Methode move

		int x1C = posApple1.x;
		int y1C = posApple1.y;
		
		if ( PowerUps[0] != null) {
			int x3C = PowerUps[0].x;
			int y3C = PowerUps[0].y;
			PandaaHelper.drawPowerUp(x3C, y3C, Jaylib.BLUE);
		}
		if ( PowerUps[1] != null) {
			int x3C = PowerUps[1].x;
			int y3C = PowerUps[1].y;
			PandaaHelper.drawPowerUp(x3C, y3C, Jaylib.WHITE);
		}
		if ( PowerUps[2] != null) {
			int x3C = PowerUps[2].x;
			int y3C = PowerUps[2].y;
			PandaaHelper.drawPowerUp(x3C, y3C, Jaylib.GOLD);
		}
		PandaaHelper.drawApple(x1C, y1C, Jaylib.RED);
		// Zwischenschritt fürs Einsammeln vom Apfel
	
		PandaaHelper.drawCurrentScore(score);
	
		
		if(powerUp2 != 0 && Raylib.GetTime()-powerUp2 > 10) {
			powerUp2 = 0;
			Raylib.SetTargetFPS(10);
		}
	}


	private void move(String direction) {
		if (direction == "") {
			return;
		}
		Pos posLast = snake.get(snake.size() - 1);
		int xNeu = posLast.x;
		int yNeu = posLast.y;
		// Speichern der letzen Position des Hinterteils der Schlange
		for (int i = snake.size() - 1; i > 0; i--) {
			snake.get(i).x = snake.get(i - 1).x;
			snake.get(i).y = snake.get(i - 1).y;
			// Bewegt die Schlange
		}
		switch (direction) {
		case "Rechts":
			snake.get(0).x++;
			break;
		case "Links":
			snake.get(0).x--;
			break;
		case "Oben":
			snake.get(0).y--;
			break;
		case "Unten":
			snake.get(0).y++;
			break;
		// Navigation

		}
		for (int i = 1; i < snake.size(); i++) {
			if (isColliding(snake.get(0), snake.get(i))) {
				System.out.println("Game Over!");
				isGameOver = true;
			    highscore = PandaaHelper.getHighscore();
				  if (isHighScore(score, highscore)) {
						PandaaHelper.setHighscore(highscore);
					}
				return;
				// Game Over wenn Kopf der Schlange den Körper berührt
			}
		}
		if (PowerUps[0] != null && isColliding(snake.get(0), PowerUps[0])) {
			PowerUps[0] = null;
			score += 10;
			
		}
		if (PowerUps[1] != null && isColliding(snake.get(0), PowerUps[1])) {
			PowerUps[1] = null;
			Raylib.SetTargetFPS(5);
			powerUp2 = Raylib.GetTime();	
			
		}
	    if (PowerUps[2] != null && isColliding(snake.get(0), PowerUps[2])) {
	        PowerUps[2] = null;		
		    score += 20;	
		}
		if (isColliding(snake.get(0), posApple1)) {
		        int Powerup = getRandomInt(0, 9);
				int x3Random = getRandomInt(0, 31);
				int y3Random = getRandomInt(0, 17);
					
				PowerUps[Powerup] = new Pos(x3Random, y3Random);
		
			score += 10;
			System.out.println("Score increased to " + score);
			int x1Random = getRandomInt(0, 31);
			int y1Random = getRandomInt(0, 17);
			posApple1.x = x1Random;
			posApple1.y = y1Random;
			snake.add(new Pos(xNeu, yNeu));
			// Respawn Mechanismus des Apfels

		}
	
	}

	
	

	private boolean isColliding(Pos posA, Pos posB) {
		if (posA.x == posB.x) {
			if (posA.y == posB.y) {
				return true;
			}
		}
		return false;
	}

	private int getRandomInt(int min, int max) {
		int diff = max - min;
		return Math.round(Math.round(Math.random()*diff + min));
//		return (int) Math.random()*diff + min;
		// Zufallsgenerator für den Apfel(Hat Jannis erstellt, weil er unfassbar genial
		// ist(nicht von Jannis geschrieben worden))
	}

	public void KeyRechtsPressed() {
		if (richtung != "Links") {
			richtung = "Rechts";
		}

	}

	public void KeyLinksPressed() {
		if (richtung != "Rechts") {
			richtung = "Links";
		}

	}

	public void KeyObenPressed() {
		if (richtung != "Unten") {
			richtung = "Oben";
		}

	}

	public void KeyUntenPressed() {
		if (richtung != "Oben") {
			richtung = "Unten";
		}
		// Alle vier: Verhindert Bewegung in die entegegengesetzte Richtung
	}

	private boolean isHighScore (int score, int HighScore) {
		if (HighScore < score) {
	        highscore = score;
	        return true;
		}
		return false;
	}
	public class Pos {
		int x;
		int y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
