import utilz.*;
import game.GameManager;
import data.*;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Constant.clearScreen();
        Unique.printSeaBattle();
        GameManager Game = new GameManager();
        FileRank.loadFromFile();

        while(true){
            Unique.showGameMenu();
            int selection = Integer.parseInt(Constant.scanner.nextLine());
            Constant.clearScreen();
            switch(selection){
                case 1 : FileRank.showRank(); break; // Leaderboard
                case 2 : Game.start(); break;   // Game
                case 3 : FileRank.saveToFile(); return; // exit game
                default : Unique.enterAgain();
            }
            Constant.clearScreen();
        }
    }
}
