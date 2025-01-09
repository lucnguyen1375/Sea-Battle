package data;

import game.Player;
import utilz.Constant;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FileRank {
    public static List<PlayerRank> rank;

    public static void loadFromFile() throws IOException
    {
        rank = new ArrayList<PlayerRank>();
        File f = new File("rank.txt");
        if (!f.exists()) {
            f.createNewFile();
        }
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        while(true) {
            String name = br.readLine();
            if (name == null) break;
            int score = Integer.parseInt(br.readLine());
            rank.add(new PlayerRank(name, score));
        }
        br.close(); fr.close();
    }

    public static void showRank(){
        System.out.println("__________________________________");
        System.out.printf("|%-5s|%-20s|%-5s|%n", "Rank", "Tên", "Score");
        System.out.println("|-----|--------------------|-----|");
        for(int i = 0; i < rank.size(); i++) {
            System.out.printf("|%-5d|%-20s|%-5d|%n", (i + 1), rank.get(i).getName(), rank.get(i).getScore());
        }
        System.out.println("----------------------------------");
        Constant.enterToContinue();
    }
    public static void sortBxh() {
        rank.sort(new Comparator<PlayerRank>() {
            @Override
            public int compare(PlayerRank p1, PlayerRank p2) {
                return p1.getScore() - p2.getScore();
            }
        });
    }

    public static void updateBxh(Player player){
        for(int i = 0; i < rank.size(); i++) {
            if (player.getName().equals(rank.get(i).getName())) {
                if (rank.get(i).getScore() < player.getSoODaBan()) {
                    rank.get(i).setScore(player.getSoODaBan());
                    return;
                }
            }
        }
        rank.add(new PlayerRank(player.getName(), player.getSoODaBan()));
        sortBxh();
    }

    public static void saveToFile() throws  IOException
    {
        File f = new File("rank.txt");
        FileWriter fw = new FileWriter(f);
        BufferedWriter bw = new BufferedWriter(fw);
        for(PlayerRank p : rank ) {
            bw.write(p.getName() + "\n" + p.getScore() +'\n');
        }
        bw.close();fw.close();
    }
}
