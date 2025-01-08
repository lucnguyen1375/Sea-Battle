package template;

public class Template {
    public static void showGameMenu(){
        System.out.println("MENU");
        System.out.println("1. Leaderboard.");
        System.out.println("2. New Game.");
        System.out.println("3. Exit Game.");
    }

    public static void showBattleMenu(){
        System.out.println("Mode:");
        System.out.println("1. Play With Computer.");
        System.out.println("2. Two Players.");
    }

    public static void showPlayerMenu() {
        System.out.println("Choose action:.");
        System.out.println("1. Show Your Board.");
        System.out.println("2. Show Enemy Board And Shoot.");
        System.out.println("3. Finish Turn.");
    }
    public static void enterAgain() {
        System.out.println("Invalid value. Please try again!");
    }
    public static void printSeaBattle() {
        System.out.println("███████╗███████╗ █████╗     ██████╗  █████╗ ████████╗████████╗██╗     ███████╗");
        System.out.println("██╔════╝██╔════╝██╔══██╗    ██╔══██╗██╔══██╗╚══██╔══╝╚══██╔══╝██║     ██╔════╝");
        System.out.println("███████╗█████╗  ███████║    ██████╔╝███████║   ██║      ██║   ██║     █████╗");
        System.out.println("╚════██║██╔══╝  ██╔══██║    ██╔══██╗██╔══██║   ██║      ██║   ██║     ██╔══╝");
        System.out.println("███████║███████╗██║  ██║    ██████╔╝██║  ██║   ██║      ██║   ███████╗███████╗");
        System.out.println("╚══════╝╚══════╝╚═╝  ╚═╝    ╚═════╝ ╚═╝  ╚═╝   ╚═╝      ╚═╝   ╚══════╝╚══════╝");
    }
    public static void showPlaceShipOption() {
        System.out.println("You Have 2 Arrange Options: ");
        System.out.println("1. Arrange Yourself.");
        System.out.println("2. Randomly Arrange.");
    }
}
