import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    private static final String ANSI_RED = "\033[31m";
    private static final String ANSI_GREEN = "\033[32m";
    private static final String ANSI_CYAN = "\033[36m";
    private static final String ANSI_RESET = "\033[0m";

    Scanner scanf = new Scanner(System.in);
    private Board board = new Board();
    private ArrayList<Ship> ships = new ArrayList<>();
    public static String[] shipNames = {
            "Patrol Boat 1",
            "Patrol Boat 2",
            "Destroyer Boat",
            "Submarine",
            "Battle Ship"
    };

    public Board getBoard() {
        return board;
    }

    public void setUp(int player) {
        for (int i = 0; i < shipNames.length; ++i) {
            board.displayBoard(true);
            System.out.println();
            System.out.println(ANSI_CYAN + "Set the position for the " + shipNames[i] + ANSI_RESET);
            System.out.println();
            while (true) {
                boolean isVertical;
                while (true) {
                    System.out.println("Choose the direction for the ship");
                    System.out.print("Enter 'V' to place vertically, 'H' to place horizontally: ");
                    char dir = Character.toUpperCase(scanf.next().charAt(0));
                    if ((dir == 'V') || dir == 'H') {
                        isVertical = (dir == 'V');
                        break;
                    } else {
                        System.out.println(ANSI_RED + "The direction is invalid!" + ANSI_RESET);
                        System.out.println();
                    }
                }

                System.out.println();
                System.out.println("Choose the coordinates for the prow (x, y)");
                System.out.print("Enter x (0,1,...): ");
                int xProw = Character.toUpperCase(scanf.next().charAt(0)) - '0';
                System.out.print("Enter y (A,B,...): ");
                int yProw = Character.toUpperCase(scanf.next().charAt(0)) - 'A';
                Coordinates prowCoord = new Coordinates(xProw, yProw);

                Ship ship = new Ship(shipNames[i], isVertical, prowCoord);
                if (isValidLocation(ship)) {
                    ships.add(ship);
                    placeShip(ship);
                    System.out.println("The coordinates of the stern are " + ship.getSternCoord());
                    System.out.println();
                    System.out.println(ANSI_GREEN + "The " + shipNames[i] + " has been successfully placed!" + ANSI_RESET);
                    break;
                } else {
                    System.out.println(ANSI_RED + "The coordinates are invalid!" + ANSI_RESET);
                    System.out.println();
                }
            }
            Title.gameSetup(player);
        }
        board.displayBoard(true);
        System.out.println();
        System.out.println(ANSI_GREEN + "==================== THE SETUP WAS COMPLETED ====================" + ANSI_RESET);
        System.out.println();
    }

    public boolean isValidLocation(Ship ship) {
        int xProw = ship.getProwCoord().getX();
        int yProw = ship.getProwCoord().getY();
        int xStern = ship.getSternCoord().getX();
        int yStern = ship.getSternCoord().getY();
        if (xProw < 0 || xProw >= 10 || yProw < 0 || yProw >= 10) {
            return false;
        }
        if (xStern < 0 || xStern >= 10 || yStern < 0 || yStern >= 10) {
            return false;
        }
        for (int xCoord = xProw; xCoord <= xStern; xCoord++) {
            for (int yCoord = yProw; yCoord <= yStern; yCoord++) {
                if (board.getPrivateValue(new Coordinates(xCoord, yCoord)) != ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public void placeShip(Ship ship) {
        int xProw = ship.getProwCoord().getX();
        int yProw = ship.getProwCoord().getY();
        int xStern = ship.getSternCoord().getX();
        int yStern = ship.getSternCoord().getY();
        for (int xCoord = xProw; xCoord <= xStern; xCoord++) {
            for (int yCoord = yProw; yCoord <= yStern; yCoord++) {
                board.setPrivateValue(new Coordinates(xCoord, yCoord), ship.getType());
            }
        }
    }

    public Coordinates chooseAttackCoord(Player opponent) {
        while (true) {
            System.out.println("Choose the coordinates you want to attack");
            System.out.print("Enter x (0,1,...): ");
            int x = scanf.nextInt();
            System.out.print("Enter y (A,B,...): ");
            int y = Character.toUpperCase(scanf.next().charAt(0)) - 'A';
            Coordinates attack = new Coordinates(x, y);
            if (isValidAttack(attack, opponent)) {
                return attack;
            } else {
                System.out.println(ANSI_RED + "The coordinates are invalid!" + ANSI_RESET);
                System.out.println();
            }
        }
    }

    public void fireAndAttack(Coordinates attack, Player opponent) {
        if (isHitAttack(attack, opponent)) {
            System.out.println();
            System.out.println(ANSI_GREEN + "You have hit the opponent's ship!" + ANSI_RESET);
            opponent.board.setPublicValue(attack, 'o');
            for (Ship ship : opponent.ships) {
                if (ship.isCoordinatesOfShip(attack) && ship.isSunk(opponent.board.getPublicBoard())) {
                    System.out.println();
                    System.out.println(ANSI_GREEN + "The " + ship.getName() + " has been sunk!" + ANSI_RESET);
                    int xProw = ship.getProwCoord().getX();
                    int yProw = ship.getProwCoord().getY();
                    int xStern = ship.getSternCoord().getX();
                    int yStern = ship.getSternCoord().getY();
                    for (int xCoord = xProw; xCoord <= xStern; xCoord++) {
                        for (int yCoord = yProw; yCoord <= yStern; yCoord++) {
                            Coordinates coord = new Coordinates(xCoord, yCoord);
                            opponent.board.setPublicValue(coord, '#');
                        }
                    }
                    opponent.ships.remove(ship);
                    break;
                }
            }
        } else {
            System.out.println();
            System.out.println(ANSI_RED + "You missed the shot!" + ANSI_RESET);
            opponent.board.setPublicValue(attack, 'x');
        }
    }

    public boolean isValidAttack(Coordinates attack, Player opponent) {
        return opponent.board.getPublicValue(attack) == ' ';
    }

    public boolean isHitAttack(Coordinates attack, Player opponent) {
        return opponent.board.getPrivateValue(attack) != ' ';
    }

    public boolean isLose() {
        return ships.isEmpty();
    }
}
