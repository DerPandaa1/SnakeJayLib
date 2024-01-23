import java.util.ArrayList;
import java.util.List;


//FeldGröße 32*18


/**
 * @author <a href="mailto:Alexander.Rathai@Materna.DE">Alexander Rathai</a>
 *
 */
public class Snake {
	List<Pos> snake = new ArrayList<Pos>();
	Pos posApple = new Pos(-1, -1);
	public Snake() {
		
	}
	public void init() {
		snake.add(new Pos(9, 7));
		snake.add(new Pos(8, 7));
		snake.add(new Pos(7, 7));
		int xRandom = getRandomInt(0,32);
		int yRandom = getRandomInt(0,18);
		posApple.x = xRandom;
		posApple.y = yRandom; 
//		snake.add(new Pos(xRandom, yRandom));
	}
	public void loop() {
		
		for (int i = 0; i < snake.size(); i++) {
			Pos pos = snake.get(i);
			int x= pos.x;
			int y = pos.y;
			
			PandaaHelper.drawTile(x, y);
		}
		move("Rechts"); 
//		Pos posApple = snake.get();
		int xC = posApple.x; 
		int yC = posApple.y; 
		PandaaHelper.drawApple(xC, yC);
	}
	private void move(String direction) {
		for (int i = snake.size()-1; i > 0; i--) {
			snake.get(i).x = snake.get(i-1).x;
			snake.get(i).y = snake.get(i-1).y;
			
		}
		switch (direction) {
			case "Rechts":
				snake.get(0).x++;
		}
	}
	private boolean isColliding(Pos posA, Pos posB) {
		//TODO
	}
	private int getRandomInt(int min, int max) {
		int diff= max-min;
		return Math.round(Math.round(Math.random()*diff +min));
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
