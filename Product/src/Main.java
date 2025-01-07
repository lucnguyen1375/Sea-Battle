import main.*;
import game.ShowBoard;
import template.Template;
import game.GameManager;
import data.*;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        View.clearScreen();
        Template.printSeaBattle();
        GameManager Game = new GameManager();
        FileRank.loadFromFile();
        while(true){
            Template.showGameMenu();
            int selection = Integer.parseInt(system.scanner.nextLine());
            View.clearScreen();
            switch(selection){
                case 1 : FileRank.showRank(); break;
                case 2 : Game.start(); break;
                case 3 : FileRank.saveToFile(); return;
                default : Template.enterAgain();
            }
            View.clearScreen();
        }
    }
}
