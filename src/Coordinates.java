public class Coordinates {
    private int xCoord;
    private int yCoord;

    public Coordinates() {
        xCoord = yCoord = 0;
    }

    public Coordinates(int xCoord, int yCoord) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }

    public int getX() {
        return xCoord;
    }

    public int getY() {
        return yCoord;
    }

    public String toString() {
        return "(" + xCoord + ", " + (char)(yCoord + 'A') + ")";
    }
}
