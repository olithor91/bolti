//game class
package is.ru.bolti;
import static spark.Spark.*;
import spark.*;
import spark.servlet.SparkApplication;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

public class Game {
    public Team Team1;
    public Team Team2;
	
	Game(){
		Team Team1 = new Team();
		Team Team2 = new Team();
	}


	public void playGame(){
		staticFileLocation("/public");
		String port = System.getenv("PORT");
        if (port != null) {
            setPort(Integer.valueOf(port));
        }

		get(new Route("/newgame") {
            @Override
            public Object handle(Request request, Response response) {
                //Team1.clearTeam();
                //Team2.clearTeam();
                return "reset";
            }
        });


        get(new Route("/move") {
            @Override
            public Object handle(Request request, Response response) {
            	
                String cell = request.queryParams("e");
       			System.out.println(cell);
                String[] players = cell.split(",");
                ArrayList<String> allPlayers= new ArrayList<String>(Arrays.asList(players));
                Collections.shuffle(allPlayers);

               // if(players.length%2==0){
                    for(int i=0; i<players.length/2; i++){
                        Team1.addPlayer(allPlayers.get(i));
                    }

                    for(int i=players.length/2; i<players.length; i++){
                        Team2.addPlayer(allPlayers.get(i));
                    }

               // }

                    String json="{ \"team1\": "; 

       		        for(int i=0; i<Team1.size(); i++){
                        json=json+Team1.get(i) + " ";
                    }

                    json=json+ ", \"team2\": ";

                    for(int i=0; i<Team2.size(); i++){
                        json=json+Team2.get(i);
                    }

                    json=json+" }";
       			// if(theGame.whosTurn){
       			// 	theGame.move(moveinput,"X");
       			// }
                    System.out.println(json);
                
       			// else{
       			// 	theGame.move(moveinput,"O");
       			// }

          //       boolean haswon = theGame.hasWon();
          //       boolean isfull = theGame.isFull();
          //       boolean whosturn = theGame.whosTurn;
          //       int p1Score = Player1.wins;
          //       int p2Score = Player2.wins;
          //       System.out.println(moveinput);
          //       String p1Mark=Player1.mark;
          //       String p2Mark=Player2.mark;
          //       System.out.println("moveinput: " + moveinput);
          //       String json  = "{ \"isfull\": " + isfull + ", \"haswon\": " + haswon +  ", \"whosturn\": " + whosturn + ", \"p2Score\": " + p2Score + " }"; 
          //       System.out.println(json);
                // if(haswon || isfull){
                // 	if(whosturn){
                // 		Player2.wins++;
                // 	}
                // 	else{
                // 		Player1.wins++;
                // 	}
                // 	theGame.clearAll();
                // 	theGame.whosTurn=true;
                // }
                return json;
            }
        });
	}




}
