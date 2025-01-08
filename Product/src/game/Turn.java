package game;

import Screen.Output;
import Screen.View;
import template.Template;

import java.util.Random;

public class Turn {
    public static void turn(Player player, Player enemy)
    {
        // In trạng thái của người chơi
        System.out.println("Your state: ");
        System.out.println("A number of shoot: " + player.getSoODaBan());
        System.out.println("A number of ship you had destroyed: " + player.getSoTauDaPha());
        System.out.println("Your remaining ship: " + player.getSoTauConLai());
        int checkKhaiHoa = 0;
        while(true)
        {
            Template.showPlayerMenu();
            int selection = Integer.parseInt(Output.scanner.nextLine());
            switch(selection)
            {
                case 1: ShowBoard.showBoard(player); break;
                case 2:
                    if (checkKhaiHoa == 1)
                    {
                        System.out.println("You have shooted!");
                        break;
                    }
                    checkKhaiHoa = 1;
                    while(true) {
                        if (player.getSoTauDaPha() == 5) {
                            return;
                        }
                        ShowBoard.showEnemyBoard(player);
                        ToaDo toaDo = player.toaDoShoot();
                        boolean continueShoot = CheckShoot.shoot(toaDo, player, enemy);
                        if (continueShoot == false) {
                            System.out.println("Oops! You missed!");
                            break;
                        }
                        else {
                            System.out.println("Good! You have hit the enemy board!");
                        }
                    }
                    break;
                case 3: return;
            }
        }
    }

    public static boolean check(int x, int y) {
        if (x < 1 || x > GameManager.kichThuoc) return false;
        if (y < 1 || y > GameManager.kichThuoc) return false;
        return true;
    }

    public static void botTurn(Bot bot, Player player) {
        while(true) {
            bot.soLanBan++;
            //if (bot.soLanBan == 10) return;
            if (bot.getSoTauDaPha() == 5) {
                return;
            }
            int x = 0;
            int y = 0;
            int max = 0;
            for (int i = 1; i <= GameManager.kichThuoc; i++) {
                for (int j = 1; j <= GameManager.kichThuoc; j++) {
                    if (bot.getPriority()[i][j] < 100 && max < bot.getPriority()[i][j]) {
                        max = bot.getPriority()[i][j];
                        x = i;
                        y = j;
                    }
                }
            }
            boolean continueShoot;
            if (x == 0 && y == 0) {
                while(true){ // random until select right location to shoot
                    Random generator = new Random();
                    x = generator.nextInt(GameManager.kichThuoc) + 1;
                    y = generator.nextInt(GameManager.kichThuoc) + 1;
                    if (bot.getPriority()[x][y] < 100) {
                        break;
                    }
                }
            }
            ToaDo toaDo = new ToaDo(x, y);
            continueShoot = CheckShoot.shoot(toaDo, bot, player);
            bot.updatePriority(x,y,100); // value = 100 -> used
            if (continueShoot == false) {
                System.out.printf("----Bot has hit your ship %d times", bot.soLanBan - 1);
                ShowBoard.showBotEnemyBoards(bot);
                View.toContinue();
                return;
            }
            else {
                if (check(x-1,y) && bot.getPriority()[x-1][y] < 100) {
                    bot.updatePriority(x-1,y,1);
                }
                if (check(x+1,y) && bot.getPriority()[x+1][y] < 100) {
                    bot.updatePriority(x+1,y,1);
                }
                if (check(x,y-1) &&bot.getPriority()[x][y+1] < 100) {
                    bot.updatePriority(x,y-1,1);
                }
                if (check(x,y+1) && bot.getPriority()[x][+1] < 100) {
                    bot.updatePriority(x,y+1,1);
                }
            }
        }
    }
}
