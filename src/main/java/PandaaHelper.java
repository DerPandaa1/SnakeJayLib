import static com.raylib.Raylib.DrawRectangle;

import com.raylib.*;
/**
 * @author <a href="mailto:Alexander.Rathai@Materna.DE">Alexander Rathai</a>
 *
 */
public class PandaaHelper {
	
	public static void drawTile(int a, int b) {
		if(a*25>=800 || b*25>=450||a<0||b<0) {
			throw new IndexOutOfBoundsException();
		}
		DrawRectangle(a*25, b*25, 25, 25, Jaylib.DARKGREEN);		
	}
	public static void drawApple(int a, int b) {
		if(a*25>=800 || b*25>=450||a<0||b<0) {
//			System.out.printf("x: %d\n y%d\n",a,b);
			throw new IndexOutOfBoundsException();
		}
		DrawRectangle(a*25, b*25, 25, 25, Jaylib.RED);		
	}
}
