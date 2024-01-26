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
	static String key = "";
	static boolean started = false;
	static Snake sn = new Snake();

	public static void main(String args[]) {
		InitWindow(800, 450, "Snake");
		int fps = (9);
		SetTargetFPS(fps);
		sn.init();
		boolean draw = false;
		double lastRenderTime = 0;
		while (!WindowShouldClose()) {
			draw = Raylib.GetTime() - lastRenderTime > 1 / 10;
			lastRenderTime = Raylib.GetTime();
			System.out.println(draw + " " + Raylib.GetTime());
			if (draw) {
				Raylib.BeginDrawing();
			}
		
			if (sn.isGameOver) {
				gameOver(draw);
				SetTargetFPS(10);
			} else {
				if (Raylib.IsKeyDown(KEY_W))
					key = "UP";
				if (Raylib.IsKeyDown(KEY_A))
					key = "LEFT";
				if (Raylib.IsKeyDown(KEY_S))
					key = "DOWN";
				if (Raylib.IsKeyDown(KEY_D)) {
					key = "RIGHT";
				}
				if (!key.isEmpty()) {
					started = true;
				}
				PandaaHelper.drawStartScreen(started);
				if(draw) {
					ClearBackground(Jaylib.GREEN);
				}
				if(started) {
					sn.zzzz();
				}
				switch (key) {
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
				key = "";
			}
			if (draw) {
				Raylib.EndDrawing();
			}
		}
		CloseWindow();
	}

	public static void gameOver(boolean draw) {
		if (draw) {
			ClearBackground(Jaylib.RED);
			PandaaHelper.drawGameOver();
			PandaaHelper.drawRetry();
			PandaaHelper.drawHighScore(sn.highscore);
			PandaaHelper.drawEndScore(sn.score);
		}
		if (Raylib.IsKeyPressed(Raylib.KEY_ENTER)) {
			sn = new Snake();
			sn.init();
			started = false;
		}
	}
}