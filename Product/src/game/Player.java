package game;

import Screen.Output;
import template.Template;

public class Player {
    private String name;
    String[][] board;
    String[][] enemyBoard;
    private int soODaBan;
    private int soTauDaPha;
    private int soTauConLai;
    private int patrolBoat1Point;
    private int patrolBoat2Point;
    private int destroyerBoatPoint;
    private int submarinePoint;
    private int battleShipPoint;
    public Player(){}
    public Player(String name) {
        this.name = name;
        board = new String[21][21];
        enemyBoard = new String[21][21];
        for(int i = 1; i <= 20; i++)
            for(int j = 1; j <= 20; j++) {
                board[i][j] = ".";
                enemyBoard[i][j] = "?";
            }
        soODaBan = 0;
        soTauDaPha = 0;
        soTauConLai = 5;
        patrolBoat1Point = 2;
        patrolBoat2Point = 2;
        destroyerBoatPoint = 4;
        submarinePoint = 3;
        battleShipPoint = 5;
    }

    public String[][] getBoard() {
        return board;
    }

    public String[][] getEnemyBoard() {
        return enemyBoard;
    }

    public String getName() {
        return name;
    }

    public void setBoard(String symbol, int i, int j) {
        this.board[i][j] = symbol;
    }

    public void setEnemyBoard(String symbol, int i, int j) {
        this.enemyBoard[i][j] = symbol;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSoODaBan() {
        return soODaBan;
    }

    public int getSoTauDaPha() {
        return soTauDaPha;
    }

    public void updateSoODaBan() {
        soODaBan++;
    }

    public void updateSoTauDaPha() {
        soTauDaPha++;
    }
    public void decreasePatrolBoat1Point()
    {
        patrolBoat1Point--;
    }
    public void decreasePatrolBoat2Point()
    {
        patrolBoat2Point--;
    }
    public void decreaseDestroyerBoatPoint()
    {
        destroyerBoatPoint--;
    }
    public void decreaseSubmarinePoint()
    {
        submarinePoint--;
    }
    public void decreaseBattleShipPoint()
    {
        battleShipPoint--;
    }
    public void decreaseSoTauConLai(){ soTauConLai--; }

    public int getSoTauConLai() {
        return soTauConLai;
    }

    public int getPatrolBoat1Point() {
        return patrolBoat1Point;
    }

    public int getDestroyerBoatPoint() {
        return destroyerBoatPoint;
    }

    public int getPatrolBoat2Point() {
        return patrolBoat2Point;
    }

    public int getSubmarinePoint() {
        return submarinePoint;
    }

    public int getBattleShipPoint() {
        return battleShipPoint;
    }

    public ToaDo toaDoShoot(){
        System.out.println("Enter position to shoot:");
        System.out.printf("Enter horizontal (Hoanh Do): ");

        int x,y;
        while(true){
            x = Integer.parseInt(Output.scanner.nextLine());
            if (x < 1 || x > GameManager.kichThuoc)
                Template.enterAgain();
            else break;
        }
        while(true){
            System.out.printf("Enter vertical (Tung Do): ");
            char c = Output.scanner.nextLine().charAt(0);
            y = c - 'A' + 1;
            if (y < 1 || y > GameManager.kichThuoc)
                Template.enterAgain();
            else break;

        }
        ToaDo toaDo = new ToaDo(x, y);
        return toaDo;
    }

}
