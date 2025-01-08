package game;

import Screen.View;
import Screen.Output;
import template.Template;
import ship.ListOfShips;

public class GameManager {
    ListOfShips ships = new ListOfShips();
    Player player1, player2;
    public static int kichThuoc = 10;

    public void start()
    {
        Template.showBattleMenu();
        int selection = Integer.parseInt(Output.scanner.nextLine());

        while(true){
            System.out.println("Choose Board Size (10 -> 20):");
            kichThuoc = Integer.parseInt(Output.scanner.nextLine());
            if (kichThuoc < 10 || kichThuoc > 20)
                Template.enterAgain();
            else break;
        }
        View.clearScreen();
        if (selection == 1)       { // Play with computer
            OnePlayer onePlayer = new OnePlayer();
            onePlayer.play();
        }
        else if (selection == 2)    { // two player
            TwoPlayer twoPlayer = new TwoPlayer();
            twoPlayer.play();
        }
    }
}
