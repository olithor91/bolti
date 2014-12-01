package is.ru.bolti;
import static spark.Spark.*;
import spark.*;
import spark.servlet.SparkApplication;

public class Main{
	public static Game mainGame = new Game();
	public static void main(String[] args) {
		System.out.println("Welcome to Bolti");
		mainGame.playGame();

	}
}