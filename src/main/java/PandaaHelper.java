import static com.raylib.Raylib.DrawRectangle;

import com.raylib.*;
/**
 * @author <a href="mailto:Alexander.Rathai@Materna.DE">Alexander Rathai</a>
 *
 */
public class PandaaHelper {
	class Pos{
		int x;
		int y;
		public Pos(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}
	public static void drawTile(int a, int b) {
		if(a*25>800 || b*25>450) {
			throw new IndexOutOfBoundsException();
		}
		DrawRectangle(a*25, b+25, 25, 25, Jaylib.BLACK);		
	}
	public static void drawApple(int a, int b) {
		if(a*25>800 || b*25>450) {
			throw new IndexOutOfBoundsException();
		}
		DrawRectangle(a*25, b+25, 25, 25, Jaylib.RED);		
	}
}
