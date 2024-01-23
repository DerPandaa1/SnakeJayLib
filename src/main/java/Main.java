import static com.raylib.Raylib.ClearBackground;
import static com.raylib.Raylib.CloseWindow;
import static com.raylib.Raylib.EndDrawing;
import static com.raylib.Raylib.GetKeyPressed;
import static com.raylib.Raylib.InitWindow;
import static com.raylib.Raylib.KEY_W;
import static com.raylib.Raylib.KEY_A;
import static com.raylib.Raylib.KEY_S;
import static com.raylib.Raylib.KEY_D;
import static com.raylib.Raylib.SetTargetFPS;
import static com.raylib.Raylib.WindowShouldClose;
import static com.raylib.Raylib.IsKeyDown;

import com.raylib.*;

public class Main {
static String key="";
	public static void main(String args[]) {
    	Snake sn = new Snake();
        InitWindow(800, 450, "Snake");
        SetTargetFPS(10);
        sn.init();
        byte i=0;
        while (!WindowShouldClose()) {
        	if(IsKeyDown(KEY_W))
        		key="UP";
        	if(IsKeyDown(KEY_A))
        		key="LEFT";
        	if(IsKeyDown(KEY_S))
        		key="DOWN";
        	if(IsKeyDown(KEY_D)) {
        		key="RIGHT";
        	}
            if (i>=100) {
            	ClearBackground(Jaylib.GREEN);
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
            	key="";
            }
            i++;
        }
        CloseWindow();
    }
}