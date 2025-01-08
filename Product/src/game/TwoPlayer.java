package game;
import data.FileRank;
import Screen.View;
import Screen.Output;
import template.Template;

public class TwoPlayer {
    Player player1;
    Player player2;
    public void play()
    {
        System.out.println("Enter player1's name: ");
        String name1 = Output.scanner.nextLine();
        player1 = new Player(name1);
        System.out.println("Enter player2's name: ");
        String name2 = Output.scanner.nextLine();
        player2 = new Player(name2);

        View.toContinue();

        // Player 1 placeship
        System.out.println("Player " + player1.getName() + " place ship: ");
        Template.showPlaceShipOption();
        while(true){
            int selection1 = Integer.parseInt(Output.scanner.nextLine());
            if (selection1==1) {
                PlaceShip.placeShip(player1);
                break;
            }
            else if (selection1==2){
                PlaceShip.randomPlaceShip((player1));
                break;
            }
            else {
                Template.enterAgain();
            }
        }
        System.out.println("Player " + player1.getName() + "'s Board: ");
        ShowBoard.showBoard(player1);
        View.toContinue();

        // Player 2 placeship
        System.out.println("Player " + player2.getName() + " place ship: ");
        Template.showPlaceShipOption();
        while(true){
            int selection2 = Integer.parseInt(Output.scanner.nextLine());
            if (selection2==1) {
                PlaceShip.placeShip(player2);
                break;
            }
            else if (selection2==2){
                PlaceShip.randomPlaceShip((player2));
                break;
            }
            else {
                Template.enterAgain();
            }
        }
        System.out.println("Player " + player2.getName() + "'s Board: ");
        ShowBoard.showBoard(player2);
        View.toContinue();
        while(true)
        {
            System.out.println("Player's " + player1.getName() + "'s turn.");
            Turn.turn(player1, player2);
            if (player1.getSoTauDaPha() == 5) {
                System.out.println(player1.getName() + " win!");
                View.toContinue();
                FileRank.updateBxh(player1);
                return;
            }
            View.clearScreen();
            System.out.println("Player's " + player2.getName() + "'s turn.");
            Turn.turn(player2, player1);
            if (player2.getSoTauDaPha() == 5) {
                System.out.println(player2.getName() + " win!");
                View.toContinue();
                FileRank.updateBxh(player2);
                return;
            }
            View.clearScreen();
        }
    }
}

