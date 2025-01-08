package ship;

public class Ship {
    private int size;
    private String symbol;
    private String backgroundColor;
    public Ship(){};
    public Ship(int size, String symbol, String backgroundColor) {
        this.size = size;
        this.symbol = symbol;
        this.backgroundColor = backgroundColor;
    }

    public String getSymbol() {
        return symbol;
    }
    public String getBackgroundColor() {return backgroundColor;}
    public int getSize() {
        return size;
    }

}
