public class Ship {
    private String name;
    private int size;
    private boolean isVertical;
    private Coordinates prowCoord;
    private Coordinates sternCoord;

    public Ship() {
        this.name = "";
        this.size = 0;
        this.isVertical = true;
        this.prowCoord = new Coordinates();
        this.sternCoord = new Coordinates();
    }

    public Ship(String shipName, boolean isVertical, Coordinates prowCoord) {
        this.name = shipName;
        if (shipName.charAt(0) == 'P') {
            this.size = 2;
        } else if (shipName.charAt(0) == 'D') {
            this.size = 3;
        } else if (shipName.charAt(0) == 'S') {
            this.size = 4;
        } else if (shipName.charAt(0) == 'B') {
            this.size = 5;
        }
        this.isVertical = isVertical;
        this.prowCoord = prowCoord;
        int xProw = prowCoord.getX();
        int yProw = prowCoord.getY();
        if (isVertical) {
            this.sternCoord = new Coordinates(xProw, yProw + size - 1);
        } else {
            this.sternCoord = new Coordinates(xProw + size - 1, yProw);
        }
    }

    public boolean isCoordinatesOfShip(Coordinates coord) {
        int x = coord.getX();
        int y = coord.getY();
        int xProw = prowCoord.getX();
        int yProw = prowCoord.getY();
        int xStern = sternCoord.getX();
        int yStern = sternCoord.getY();
        return xProw <= x && x <= xStern && yProw <= y && y <= yStern;
    }

    public boolean isSunk(char[][] board) {
        for (int x = prowCoord.getX(); x <= sternCoord.getX(); x++) {
            for (int y = prowCoord.getY(); y <= sternCoord.getY(); y++) {
                if (board[y][x] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public char getDirection() {
        if (isVertical) {
            return 'V';
        } else {
            return 'H';
        }
    }

    public char getType() {
        return name.charAt(0);
    }

    public Coordinates getProwCoord() {
        return prowCoord;
    }

    public Coordinates getSternCoord() {
        return sternCoord;
    }
}
