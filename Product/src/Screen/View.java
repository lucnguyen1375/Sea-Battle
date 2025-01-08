package Screen;

public class View {
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public static void toContinue() {
        System.out.println();
        System.out.println("Enter to continue.");
        Output.scanner.nextLine();
        View.clearScreen();
    }
}
