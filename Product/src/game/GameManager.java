package game;

import utilz.*;
import ship.ListOfShips;

public class GameManager {
    ListOfShips ships = new ListOfShips();
    Player player1, player2;
    public static int kichThuoc = 10;

    public void start()
    {
        Unique.showBattleMenu();
        int selection = Integer.parseInt(Constant.scanner.nextLine());

        while(true){
            System.out.println("Choose Board Size (10 -> 20):");
            kichThuoc = Integer.parseInt(Constant.scanner.nextLine());
            if (kichThuoc < 10 || kichThuoc > 20)
                Unique.enterAgain();
            else break;
        }
        Constant.clearScreen();
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
