import static com.raylib.Raylib.CloseWindow;

import java.util.*;


//FeldGröße 32*18


/**
 * @author <a href="mailto:Alexander.Rathai@Materna.DE">Alexander Rathai</a>
 *
 */
public class Snake {
	List<Pos> snake = new ArrayList<Pos>();
	Pos posApple = new Pos(-1, -1);
	String richtung="";
	
	public Snake() {
		
	}
	public void init() {
		snake.add(new Pos(9, 7));
		snake.add(new Pos(8, 7));
		snake.add(new Pos(7, 7));
		//Schlange bei Start
		
		int xRandom = getRandomInt(0,31);
		int yRandom = getRandomInt(0,17);
		posApple.x = xRandom;
		posApple.y = yRandom; 
        //Apfel-Mechanismus
		
	}
	public void loop() {
		
		for (int i = 0; i < snake.size(); i++) {
			Pos pos = snake.get(i);
			int x= pos.x;
			int y = pos.y;
			PandaaHelper.drawTile(x, y);
			//Zeichnet für die Koordinaten der Schlange die Blöcke
		}
		

		move(richtung);//Aufruf zur Methode move
		
		
		int xC = posApple.x; 
		int yC = posApple.y; 
		//Zwischenschritt fürs Einsammeln vom Apfel
		PandaaHelper.drawApple(xC, yC);
	}
	private void move(String direction) {
		if(direction==""){
			return;
		}
		Pos posLast = snake.get(snake.size()-1);
		int xNeu = posLast.x;
		int yNeu = posLast.y;
		//Speichern der letzen Position des Hinterteils der Schlange
		for (int i = snake.size()-1; i > 0; i--) {
			snake.get(i).x = snake.get(i-1).x;
			snake.get(i).y = snake.get(i-1).y;
			//Bewegt die Schlange
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
				//Navigation
				
				
		}
		for ( int i = 1; i < snake.size(); i++) {
			if(isColliding(snake.get(0), snake.get(i))) {
				CloseWindow();
				System.out.println("Game Over!");
				//Game Over wenn Kopf der Schlange den Körper berührt
			}
		}
		if(isColliding(snake.get(0), posApple)){
			int xRandom = getRandomInt(0,31);
			int yRandom = getRandomInt(0,17);
			posApple.x = xRandom;
			posApple.y = yRandom; 
			snake.add(new Pos(xNeu, yNeu));
            //Respawn Mechanismus des Apfels
			
		}
	}
	private boolean isColliding(Pos posA, Pos posB) {
		if (posA.x == posB.x ) {
			if (posA.y == posB.y ) {
				return true;
			}
		}
		return false;
	}
	private int getRandomInt(int min, int max) {
		int diff= max-min;
		return Math.round(Math.round(Math.random()*diff +min));
	//Zufallsgenerator für den Apfel (Hat Jannis erstellt, weil er unfassbar genial ist(nicht von Jannis geschrieben worden))
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
	
	public class Pos{
		int x;
		int y;
		public Pos(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}
}
