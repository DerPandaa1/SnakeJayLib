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
		snake.add(new Pos(7, 7));
		snake.add(new Pos(8, 7));
		int xRandom = getRandomInt(0,32);
		int yRandom = getRandomInt(0,18);
		posApple.x = xRandom;
		posApple.y = yRandom; 
//		snake.add(new Pos(xRandom, yRandom));
	}
	public void loop() {
		
		Pos posA = snake.get(0);
		int xA= posA.x;
		int yA = posA.y;
		
		PandaaHelper.drawTile(xA, yA);
		

		Pos posB= snake.get(1);
		int xB = posB.x;
		int yB = posB.y; 
		PandaaHelper.drawTile(xB, yB);
		
//		Pos posApple = snake.get();
		int xC = posApple.x; 
		int yC = posApple.y; 
		PandaaHelper.drawApple(xC, yC);
	}
	private void Move(String direction) {
		//TODO
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
