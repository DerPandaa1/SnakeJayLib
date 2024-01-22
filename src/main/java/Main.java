import static com.raylib.Raylib.ClearBackground;
import static com.raylib.Raylib.CloseWindow;
import static com.raylib.Raylib.EndDrawing;
import static com.raylib.Raylib.InitWindow;
import static com.raylib.Raylib.SetTargetFPS;
import static com.raylib.Raylib.WindowShouldClose;

import com.raylib.*;

public class Main {
    public static void main(String args[]) {
    	Snake sn = new Snake();
        InitWindow(800, 450, "Snake");
        SetTargetFPS(60);
        sn.init();
        byte i=0;
        while (!WindowShouldClose()) {
            if (i>=60) {
            	ClearBackground(Jaylib.RAYWHITE);
            	sn.loop();
            	i=0;
            	EndDrawing();
            }
            i++;
        }
        CloseWindow();
    }
}