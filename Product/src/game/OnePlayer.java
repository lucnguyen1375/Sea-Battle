package game;

import data.FileRank;
import utilz.*;

public class OnePlayer {
    public void play() {
        // Bot constructor
        Bot bot = new Bot();
        PlaceShip.randomPlaceShip(bot);

        // Player enter information and placeship
        Player player;
        System.out.println("Enter player's name: ");
        String name = Constant.scanner.nextLine();
        player = new Player(name);


        System.out.println("Player " + player.getName() + " place ship: ");
        Unique.showPlaceShipOption(); // Place by hand or randomly
        while(true){
            int selection1 = Integer.parseInt(Constant.scanner.nextLine());
            if (selection1==1) {
                PlaceShip.placeShip(player);
                break;
            }
            else if (selection1==2){
                PlaceShip.randomPlaceShip((player));
                break;
            }
            else {
                Unique.enterAgain();
            }
        }

        Constant.clearScreen();
        System.out.println("Your Board: ");
        ShowBoard.showBoard(player);

        Constant.enterToContinue();
        // InGame

        while(true) {
            System.out.println("Your turn.");
            Turn.turn(player, bot);
            if (player.getSoTauDaPha() == 5) {
                System.out.println("You Won! Congratulations!");
                FileRank.updateBxh(player);
                Constant.enterToContinue();
                break;
            }
            Turn.botTurn(bot, player);
            System.out.println("Bot is playing.");
            //if (bot.soLanBan == 10) return;
            if (bot.getSoTauDaPha() == 5) {
                System.out.println("Bot Won");
                Constant.enterToContinue();
                return;
            }
            Constant.clearScreen();
        }
    }
}
