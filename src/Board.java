public class Board {
    private static final String ANSI_RED = "\033[31m";
    private static final String ANSI_YELLOW = "\033[33m";
    private static final String ANSI_BLUE = "\033[34m";
    private static final String ANSI_MAGENTA = "\033[35m";
    private static final String ANSI_RESET = "\033[0m";

    private char[][] privateBoard;
    private char[][] publicBoard;

    public Board() {
        privateBoard = new char[11][11];
        publicBoard = new char[11][11];
        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < 10; ++j) {
                publicBoard[i][j] = ' ';
                privateBoard[i][j] = ' ';
            }
        }
    }

    public char[][] getPublicBoard() {
        return publicBoard;
    }

    public char[][] getPrivateBoard() {
        return privateBoard;
    }

    public char getPrivateValue(Coordinates coord) {
        return privateBoard[coord.getY()][coord.getX()];
    }

    public void setPrivateValue(Coordinates coord, char value) {
        privateBoard[coord.getY()][coord.getX()] = value;
    }

    public char getPublicValue(Coordinates coord) {
        return publicBoard[coord.getY()][coord.getX()];
    }

    public void setPublicValue(Coordinates coord, char value) {
        publicBoard[coord.getY()][coord.getX()] = value;
    }

    public void displayBoard(boolean isPrivate) {
        if (isPrivate) {
            System.out.println("|======================= YOUR FLEET BOARD ======================|");
        } else {
            System.out.println("|================= YOUR OPPONENT'S FOGGY BOARD =================|");
        }
        System.out.println("|   |  0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |");
        System.out.println("|---|-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|");
        for (int i = 0; i < 10; ++i) {
            System.out.printf("| %c |", 'A' + i);
            for (int j = 0; j < 10; j++) {
                char c = isPrivate ? privateBoard[i][j] : publicBoard[i][j];
                if (c == 'o') {
                    System.out.print(ANSI_RED + " [o] " + ANSI_RESET + "|");
                } else if (c == 'x') {
                    System.out.print(ANSI_YELLOW + " [x] " + ANSI_RESET + "|");
                } else if (c == '#') {
                    System.out.print(ANSI_MAGENTA + " [#] " + ANSI_RESET + "|");
                } else if (c != ' ') {
                    System.out.print(ANSI_BLUE + " [" + c + "] " + ANSI_RESET + "|");
                } else {
                    System.out.print(" [ ] |");
                }
            }
            System.out.println();
            System.out.println("|---|-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|");
        }
        System.out.println();
    }

    public static void displayTwoBoard(Player player, Player opponent) {
        System.out.println("|======================= YOUR FLEET BOARD ======================|\t|================= YOUR OPPONENT'S FOGGY BOARD =================|");
        System.out.println("|   |  0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |\t|   |  0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |");
        System.out.println("|---|-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|\t|---|-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|");
        for (int i = 0; i < 10; ++i) {
            System.out.printf("| %c |", 'A' + i);
            for (int j = 0; j < 10; j++) {
                char c1 = player.getBoard().getPrivateValue(new Coordinates(j, i));
                char c2 = player.getBoard().getPublicValue(new Coordinates(j, i));
                if (c2 == 'o') {
                    System.out.print(ANSI_RED + " [" + c1 + "] " + ANSI_RESET + "|");
                } else if (c2 == 'x') {
                    System.out.print(ANSI_YELLOW + " [x] " + ANSI_RESET + "|");
                } else if (c2 == '#') {
                    System.out.print(ANSI_MAGENTA + " [" + c1 + "] " + ANSI_RESET + "|");
                } else if (c1 != ' ') {
                    System.out.print(ANSI_BLUE + " [" + c1 + "] " + ANSI_RESET + "|");
                } else {
                    System.out.print(" [ ] |");
                }
            }
            System.out.print("\t");
            System.out.printf("| %c |", 'A' + i);
            for (int j = 0; j < 10; j++) {
                char c = opponent.getBoard().getPublicValue(new Coordinates(j, i));
                if (c == 'o') {
                    System.out.print(ANSI_RED + " [o] " + ANSI_RESET + "|");
                } else if (c == 'x') {
                    System.out.print(ANSI_YELLOW + " [x] " + ANSI_RESET + "|");
                } else if (c == '#') {
                    System.out.print(ANSI_MAGENTA + " [#] " + ANSI_RESET + "|");
                } else {
                    System.out.print(" [ ] |");
                }
            }
            System.out.println();
            System.out.println("|---|-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|\t|---|-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|");
        }
        System.out.println();
        Board.displayNote();
    }

    public static void displayNote() {
        System.out.println("NOTE:");
        System.out.println("The" + ANSI_RED + " RED " + ANSI_RESET + "cell is the position of the hit-attack on the ship");
        System.out.println("The" + ANSI_YELLOW + " YELLOW " + ANSI_RESET + "cell is the position of the missed-attack");
        System.out.println("The" + ANSI_MAGENTA + " MAGENTA " + ANSI_RESET + "cell is the position of the sunken ship");
        System.out.println("The" + ANSI_BLUE + " BLUE " + ANSI_RESET + "cell is the position of the unhit part of the ship");
        System.out.println();
    }
}
