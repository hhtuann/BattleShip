import java.util.Scanner;

public class Main {
    private static final String ANSI_RED = "\033[31m";
    private static final String ANSI_GREEN = "\033[32m"
    private static final String ANSI_RESET = "\033[0m";
    private static Player player1 = new Player();
    private static Player player2 = new Player();

    public static void main(String[] args) {
        Scanner scanf = new Scanner(System.in);

        Title.gameWelcome();
        boolean isStart;
        while (true) {
            System.out.println("Do you want to start the game?");
            System.out.print("Enter 'Y' to start, 'N' to exit the game: ");
            char choose = Character.toUpperCase(scanf.next().charAt(0));
            if ((choose == 'Y') || choose == 'N') {
                isStart = (choose == 'Y');
                break;
            } else {
                System.out.println(ANSI_RED + "Your choice is invalid!" + ANSI_RESET);
                System.out.println();
            }
        }

        if (isStart) {
            System.out.println();
            System.out.println(ANSI_GREEN + "Player 1 is preparing to set up the fleet..." + ANSI_RESET);
            Title.gameSetup(1);
            player1.setUp(1);

            System.out.print("Press any key to continue: ");
            scanf.next();

            System.out.println();
            System.out.println(ANSI_GREEN + "Player 2 is preparing to set up the fleet..." + ANSI_RESET);
            Title.gameSetup(2);
            player2.setUp(2);

            System.out.print("Press any key to continue: ");
            scanf.next();

            boolean isEndGame = false;
            for (int player = 1; !isEndGame; player ^= 3) {
                Title.gameChangeTurn();
                System.out.print("Press any key to change turns: ");
                scanf.next();
                System.out.println();
                System.out.println(ANSI_GREEN + "Player " + player + " is preparing to attack..." + ANSI_RESET);
                while (true) {
                    if (player == 1) {
                        Title.gameTurn(1);
                        Board.displayTwoBoard(player1, player2);
                        Coordinates attack = player1.chooseAttackCoord(player2);
                        boolean isEndTurn = !player1.isHitAttack(attack, player2);
                        player1.fireAndAttack(attack, player2);
                        if (isEndTurn) {
                            break;
                        }
                    } else if (player == 2) {
                        Title.gameTurn(2);
                        Board.displayTwoBoard(player2, player1);
                        Coordinates attack = player2.chooseAttackCoord(player1);
                        boolean isEndTurn = !player2.isHitAttack(attack, player1);
                        player2.fireAndAttack(attack, player1);
                        if (isEndTurn) {
                            break;
                        }
                    }
                    if (player1.isLose()) {
                        System.out.println();
                        System.out.println(ANSI_GREEN + "You have destroyed all opponent's ships!" + ANSI_RESET);
                        Title.gameWiner(1);
                        System.out.print("Press any key to exit: ");
                        scanf.next();
                        isEndGame = true;
                        break;
                    } else if (player2.isLose()) {
                        System.out.println();
                        System.out.println(ANSI_GREEN + "You have destroyed all opponent's ships!" + ANSI_RESET);
                        Title.gameWiner(2);
                        System.out.print("Press any key to exit: ");
                        scanf.next();
                        isEndGame = true;
                        break;
                    }
                }
            }
        }
        Title.gameOver();
    }
}