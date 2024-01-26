import static com.raylib.Raylib.*;

import com.raylib.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author <a href="mailto:Alexander.Rathai@Materna.DE">Alexander Rathai</a>
 *
 */
public class PandaaHelper {

	private static final int started = 0;

	public static void drawTile(int x, int y) throws IndexOutOfBoundsException {
		if (x * 25 >= 800 || y * 25 >= 450 || x < 0 || y < 0) {
      
			throw new IndexOutOfBoundsException();
		
			
			
		}
		DrawRectangle(x * 25, y * 25, 25, 25, Jaylib.DARKGREEN);
	}

	public static void drawApple(int x, int y, Color color) throws IndexOutOfBoundsException {
		if (x * 25 >= 800 || y * 25 >= 450 || x < 0 || y < 0) {
			System.out.printf("x: %d\n y%d\n", x, y);
			throw new IndexOutOfBoundsException();
		}
		DrawRectangle(x * 25, y * 25, 25, 25, color);
	}
	

	public static void drawPowerUp(int x, int y, Color color) { //throws IndexOutOfBoundsException {
		if (x * 25 >= 800 || y * 25 >= 450 || x < 0 || y < 0) {
			System.out.printf("x: %d\n y: %d\n", x, y);
			throw new IndexOutOfBoundsException();
		}
		DrawRectangle(x * 25, y * 25, 25, 25, color);
	}

	public static boolean drawCurrentScore(int score) {
		String text = "Score: " + String.valueOf(score);
		int fontSize = 20;
		int textWidth = MeasureText(text, fontSize);
		int screenWidth = GetScreenWidth();
		int x = screenWidth - textWidth - 10;
		int screenHeight = GetScreenHeight();
		int y = screenHeight - fontSize - 10;
		DrawText(text, x, y, fontSize, Jaylib.ORANGE);
		return false;

	}

	public static void drawStartScreen(boolean start) {
		if (!start) {

		String text = "Press WASD to start";
		int fontSize = 30;
		int textWidth = MeasureText(text, fontSize);
		int screenHeight = GetScreenHeight();
		int screenWidth = GetScreenWidth();
		int x = screenWidth / 2 - textWidth / 2;
		int y = screenHeight / 2 - fontSize / 2;

		DrawText(text, x, y, 30, Jaylib.DARKBLUE);
	}
	}

	public static void drawGameOver() {
		String text = "Game Over";
		int fontSize = 60;
		int textWidth = MeasureText(text, fontSize);
		int screenHeight = GetScreenHeight();
		int screenWidth = GetScreenWidth();
		int x = screenWidth / 2 - textWidth / 2;
		int y = screenHeight / 6 - fontSize / 6;
		DrawText(text, x, y, fontSize, Jaylib.BLACK);

	}

	public static void drawRetry() {
		String text = "Press Enter to retry";
		int fontSize = 40;
		int textWidth = MeasureText(text, fontSize);
		int screenHeight = GetScreenHeight();
		int screenWidth = GetScreenWidth();
		int x = screenWidth / 2 - textWidth / 2;
		int y = screenHeight /2+30  - fontSize /2+30 ;
		DrawText(text, x, y, fontSize, Jaylib.WHITE);
	}

	public static boolean drawEndScore(int score) {
		String text = "Score: " + String.valueOf(score);
		int fontSize = 40;
		int textWidth = MeasureText(text, fontSize);
		int screenWidth = GetScreenWidth();
		int x = screenWidth / 2 - textWidth / 2;
		int screenHeight = GetScreenHeight();
		int y = screenHeight / 3 - fontSize / 3;
		DrawText(text, x, y, fontSize, Jaylib.BLACK);
		return false;

	}
	public static void drawHighScore(int HighScore) {
		
		String text = "Highscore: " + String.valueOf(HighScore) ;
		int fontSize = 40;
		int textWidth = MeasureText(text, fontSize);
		int screenWidth = GetScreenWidth();
		int x = screenWidth / 2 - textWidth / 2;
		int screenHeight = GetScreenHeight();
		int y = screenHeight / 2  - fontSize / 2;
		DrawText(text, x, y, fontSize, Jaylib.BLACK);
	

	}
	public static int getHighscore() {
		File Highscore = new File("Highscore.txt"); 
		try {
			FileReader fr = new FileReader(Highscore);
			int c;
			String s="";
			while( (c = fr.read()) != -1) {
				s+=(char)c;
			}
			return Integer.valueOf(s);
		}catch(IOException e) {
			return 0;
		}
	}
	public static void setHighscore(int highscore) {
		try ( FileWriter writer = new FileWriter( "Highscore.txt")){
			writer.append(String.valueOf(highscore));
		} catch (Exception e) {
			return;
		}
	}
}