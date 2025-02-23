package game;

import utilz.Constant;

public class ShowBoard {
    public static void showBoard(Player player) {
        System.out.printf("     ");
        for(char i = 'A'; i < 'A' + GameManager.kichThuoc; i++)
        {
            System.out.printf("%-5c",i);
        }
        System.out.println();
        for(int i = 1; i <= GameManager.kichThuoc; i++)
        {
            System.out.printf("%-3s",i);
            for(int j = 1; j <= GameManager.kichThuoc; j+=1)
            {
                if (player.getBoard()[i][j].equals("."))
                    System.out.printf(" [%s] ", player.getBoard()[i][j]);
                else if (player.getBoard()[i][j].equals("X"))
                    System.out.printf(" %s[%s]%s ", Constant.BackgroundRed,player.getBoard()[i][j], Constant.Reset);
                else if (player.getBoard()[i][j].equals("P") || player.getBoard()[i][j].equals("p"))
                    System.out.printf(" %s[%s]%s ", Constant.BackgroundBlue,player.getBoard()[i][j], Constant.Reset);
                else if (player.getBoard()[i][j].equals("D"))
                    System.out.printf(" %s[%s]%s ", Constant.BackgroundGreen,player.getBoard()[i][j], Constant.Reset);
                else if (player.getBoard()[i][j].equals("S"))
                    System.out.printf(" %s[%s]%s ", Constant.BackgroundMagenta,player.getBoard()[i][j], Constant.Reset);
                else if (player.getBoard()[i][j].equals("B"))
                    System.out.printf(" %s[%s]%s ", Constant.BackgroundCyan,player.getBoard()[i][j], Constant.Reset);
            }
            System.out.printf("%n");
        }
    }
    public static void showEnemyBoard(Player player) {
        System.out.printf("      ");
        for(char i = 'A'; i < 'A' + GameManager.kichThuoc; i++)
        {
            System.out.printf("%-5c",i);
        }
        System.out.println();
        for(int i = 1; i <= GameManager.kichThuoc; i++)
        {
            System.out.printf("%-3s ",i);
            for(int j = 1; j <= GameManager.kichThuoc; j+=1)
            {
                    if (player.getEnemyBoard()[i][j].equals("?"))
                        System.out.printf(" [%s] ", player.getEnemyBoard()[i][j]);
                    else if (player.getEnemyBoard()[i][j].equals("X"))
                        System.out.printf(" %s[%s]%s ", Constant.BackgroundRed,player.getEnemyBoard()[i][j], Constant.Reset);
                    else if (player.getEnemyBoard()[i][j].equals("V"))
                        System.out.printf(" %s[%s]%s ", Constant.BackgroundGreen,player.getEnemyBoard()[i][j], Constant.Reset);
            }
            System.out.printf("%n");
        }
    }
    public static void showBotEnemyBoards(Bot bot) {
        System.out.printf("    ");
        for(char i = 'A'; i < 'A' + GameManager.kichThuoc; i++)
        {
            System.out.printf("%-5c",i);
        }
        System.out.println();
        for(int i = 1; i <= GameManager.kichThuoc; i++)
        {
            System.out.printf("%-3s ",i);
            for(int j = 1; j <= GameManager.kichThuoc; j+=1) {
                if (bot.getEnemyBoard()[i][j] != "?")
                    System.out.printf(" [%s] ", bot.getEnemyBoard()[i][j]);
                else System.out.printf(".  ");
            }
            System.out.printf("%n");
        }
    }
}
