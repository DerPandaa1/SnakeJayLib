import static com.raylib.Raylib.ClearBackground;
import static com.raylib.Raylib.CloseWindow;
import static com.raylib.Raylib.EndDrawing;
import static com.raylib.Raylib.GetKeyPressed;
import static com.raylib.Raylib.InitWindow;
import static com.raylib.Raylib.KEY_DOWN;
import static com.raylib.Raylib.KEY_LEFT;
import static com.raylib.Raylib.KEY_RIGHT;
import static com.raylib.Raylib.KEY_UP;
import static com.raylib.Raylib.SetTargetFPS;
import static com.raylib.Raylib.WindowShouldClose;

import com.raylib.*;

public class Main {
static String key;
	public static void main(String args[]) {
    	Snake sn = new Snake();
        InitWindow(800, 450, "Snake");
        SetTargetFPS(10);
        sn.init();
        byte i=0;
        switch( GetKeyPressed() ) {
			case KEY_LEFT:
				key = "LEFT";
				break;
			case KEY_RIGHT:
				key = "RIGHT";
				break;
			case KEY_UP:
				key = "UP";
				break;
			case KEY_DOWN:
				key = "DOWN";
				break;
		}
        while (!WindowShouldClose()) {
            if (i>=100) {
            	ClearBackground(Jaylib.RAYWHITE);
            	sn.loop();
            	i=0;
            	EndDrawing();
            	switch( key ) {
        			case "LEFT":
        				sn.KeyLinksPressed();
        				break;
        			case "RIGHT":
        				sn.KeyRechtsPressed();
        				break;
        			case "UP":
        				sn.KeyObenPressed();
        				break;
        			case "DOWN":
        				sn.KeyUntenPressed();
        				break;
        		}
            }
            i++;
        }
        CloseWindow();
    }
}